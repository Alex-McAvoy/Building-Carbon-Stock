package com.utils.calculation;

import com.factor.bean.CarbonEmissionFactor;
import com.factor.bean.EnergyCoalFactor;
import com.factor.service.CarbonEmissionFactorService;
import com.factor.service.EnergyCoalFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description: 蒸汽能耗与碳排放 SteamConsumption 计算
 * @Author: Alex McAvoy
 * @Date: 2022/5/21 2:34
 * @Version: 1.0
 **/
@Component
public class CalSteamConsumption {
    private double z; //蒸汽消耗量

    public CalSteamConsumption() {
    }

    public CalSteamConsumption(double z) {
        this.z = z;
    }

    @Autowired
    EnergyCoalFactorService energyCoalFactorService;
    @Autowired
    CarbonEmissionFactorService carbonEmissionFactorService;

    public static CalSteamConsumption calSteamConsumption;

    @PostConstruct
    public void init() {
        calSteamConsumption = this;
    }

    /**
     * @Description: 获取折标准煤系数
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:35
     **/
    private double getStandardCoaCoefficient() {
        EnergyCoalFactor energyCoalFactor = calSteamConsumption.energyCoalFactorService.selectByPrimaryKey(6);
        double factor = energyCoalFactor.getStandardCoaCoefficient();
        return factor;
    }

    /**
     * @Description: 获取 CO2 排放系数
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:36
     **/
    private double getCO2Factor() {
        CarbonEmissionFactor carbonEmissionFactor = calSteamConsumption.carbonEmissionFactorService.selectByPrimaryKey(5);
        double CO2Factor = carbonEmissionFactor.getCo2EmissionFactor();
        return CO2Factor;
    }

    /**
     * @Description: 计算蒸汽转换能耗 W_steam
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:37
     **/
    public double calWSteam() {
        return (z / 3763) * this.getStandardCoaCoefficient();
    }

    /**
     * @Description: 计算转换碳排放 T_steam
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:37
     **/
    public double calTSteam() {
        return z * this.getCO2Factor();
    }
}
