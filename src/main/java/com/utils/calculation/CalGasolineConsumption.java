package com.utils.calculation;

import com.factor.bean.CarbonEmissionFactor;
import com.factor.bean.EnergyCoalFactor;
import com.factor.service.CarbonEmissionFactorService;
import com.factor.service.EnergyCoalFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description: 汽油能耗与碳排放 GasolineConsumption 计算
 * @Author: Alex McAvoy
 * @Date: 2022/5/21 1:57
 * @Version: 1.0
 **/
@Component
public class CalGasolineConsumption {
    private double yGasoline; //汽油消耗量

    public CalGasolineConsumption() {
    }

    public CalGasolineConsumption(double yGasoline) {
        this.yGasoline = yGasoline;
    }

    @Autowired
    EnergyCoalFactorService energyCoalFactorService;
    @Autowired
    CarbonEmissionFactorService carbonEmissionFactorService;

    public static CalGasolineConsumption calGasolineConsumption;

    @PostConstruct
    public void init() {
        calGasolineConsumption = this;
    }

    /**
     * @Description: 获取折标准煤系数
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 1:33
     **/
    private double getStandardCoaCoefficient() {
        EnergyCoalFactor energyCoalFactor = calGasolineConsumption.energyCoalFactorService.selectByPrimaryKey(2);
        double factor = energyCoalFactor.getStandardCoaCoefficient();
        return factor;
    }

    /**
     * @Description: 获取 CO2 排放系数
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 1:40
     **/
    private double getCO2Factor() {
        CarbonEmissionFactor carbonEmissionFactor = calGasolineConsumption.carbonEmissionFactorService.selectByPrimaryKey(3);
        double CO2Factor = carbonEmissionFactor.getCo2EmissionFactor();
        return CO2Factor;
    }

    /**
     * @Description: 计算汽油转换能耗 W_gasoline
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:04
     **/
    public double calWGasoline() {
        return yGasoline * this.getStandardCoaCoefficient() * 0.001;
    }

    /**
     * @Description: 计算汽油转换碳排放 T_gasoline
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:05
     **/
    public double calTGasoline() {
        return yGasoline * this.getCO2Factor() * 0.001;
    }
}
