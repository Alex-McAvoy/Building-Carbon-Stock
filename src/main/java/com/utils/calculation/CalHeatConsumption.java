package com.utils.calculation;

import com.factor.bean.CarbonEmissionFactor;
import com.factor.bean.EnergyCoalFactor;
import com.factor.service.CarbonEmissionFactorService;
import com.factor.service.EnergyCoalFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description: 供热供冷能耗与碳排放 HeatConsumption 计算
 * @Author: Alex McAvoy
 * @Date: 2022/5/21 2:45
 * @Version: 1.0
 **/
@Component
public class CalHeatConsumption {
    private double r; //热量/冷量

    public CalHeatConsumption() {
    }

    public CalHeatConsumption(double r) {
        this.r = r;
    }

    @Autowired
    EnergyCoalFactorService energyCoalFactorService;
    @Autowired
    CarbonEmissionFactorService carbonEmissionFactorService;

    public static CalHeatConsumption calHeatConsumption;

    @PostConstruct
    public void init() {
        calHeatConsumption = this;
    }

    /**
     * @Description: 获取折标准煤系数
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:47
     **/
    private double getStandardCoaCoefficient() {
        EnergyCoalFactor energyCoalFactor = calHeatConsumption.energyCoalFactorService.selectByPrimaryKey(4);
        double factor = energyCoalFactor.getStandardCoaCoefficient();
        return factor;
    }

    /**
     * @Description: 获取 CO2 排放系数
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:47
     **/
    private double getCO2Factor() {
        CarbonEmissionFactor carbonEmissionFactor = calHeatConsumption.carbonEmissionFactorService.selectByPrimaryKey(4);
        double CO2Factor = carbonEmissionFactor.getCo2EmissionFactor();
        return CO2Factor;
    }

    /**
     * @Description: 计算热量/冷量转换能耗 W_heat
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:48
     **/
    public double calWHeat() {
        return r * this.getStandardCoaCoefficient() * 0.001;
    }

    /**
     * @Description: 计算热量/冷量转换碳排放 T_heat
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:50
     **/
    public double calTHeat() {
        return this.calWHeat() * this.getCO2Factor();
    }

}
