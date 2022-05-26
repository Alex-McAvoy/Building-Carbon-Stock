package com.utils.calculation;

import com.factor.bean.CarbonEmissionFactor;
import com.factor.bean.EnergyCoalFactor;
import com.factor.service.CarbonEmissionFactorService;
import com.factor.service.EnergyCoalFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description: 天然气能耗与碳排放 GasConsumption 计算
 * @Author: Alex McAvoy
 * @Date: 2022/5/21 0:48
 * @Version: 1.0
 **/
@Component
public class CalGasConsumption {
    private double q; //天然气消耗量

    public CalGasConsumption() {
    }

    public CalGasConsumption(double q) {
        this.q = q;
    }

    @Autowired
    EnergyCoalFactorService energyCoalFactorService;
    @Autowired
    CarbonEmissionFactorService carbonEmissionFactorService;

    public static CalGasConsumption calGasConsumption;

    @PostConstruct
    public void init() {
        calGasConsumption = this;
    }

    /**
     * @Description: 获取折标准煤系数
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 1:33
     **/
    private double getStandardCoaCoefficient() {
        EnergyCoalFactor energyCoalFactor = calGasConsumption.energyCoalFactorService.selectByPrimaryKey(3);
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
        CarbonEmissionFactor carbonEmissionFactor = calGasConsumption.carbonEmissionFactorService.selectByPrimaryKey(1);
        double CO2Factor = carbonEmissionFactor.getCo2EmissionFactor();
        return CO2Factor;
    }


    /**
     * @Description: 计算天然气转换能耗 W_gas
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 1:30
     **/
    public double calWGas() {
        return q * this.getStandardCoaCoefficient() * 0.001;
    }

    /**
     * @Description: 计算天然气转换碳排放 T_gas
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 1:30
     **/
    public double calTGas() {
        return q * this.getCO2Factor() * 0.001;
    }
}
