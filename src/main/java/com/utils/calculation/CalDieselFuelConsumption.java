package com.utils.calculation;

import com.factor.bean.CarbonEmissionFactor;
import com.factor.bean.EnergyCoalFactor;
import com.factor.service.CarbonEmissionFactorService;
import com.factor.service.EnergyCoalFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description: 柴油能耗与碳排放 DieselFuelConsumption 计算
 * @Author: Alex McAvoy
 * @Date: 2022/5/21 2:21
 * @Version: 1.0
 **/
@Component
public class CalDieselFuelConsumption {
    private double yDiesel; //柴油消耗量

    public CalDieselFuelConsumption() {
    }

    public CalDieselFuelConsumption(double yDiesel) {
        this.yDiesel = yDiesel;
    }

    @Autowired
    EnergyCoalFactorService energyCoalFactorService;
    @Autowired
    CarbonEmissionFactorService carbonEmissionFactorService;

    public static CalDieselFuelConsumption calDieselFuelConsumption;

    @PostConstruct
    public void init() {
        calDieselFuelConsumption = this;
    }

    /**
     * @Description: 获取折标准煤系数
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:23
     **/
    private double getStandardCoaCoefficient() {
        EnergyCoalFactor energyCoalFactor = calDieselFuelConsumption.energyCoalFactorService.selectByPrimaryKey(1);
        double factor = energyCoalFactor.getStandardCoaCoefficient();
        return factor;
    }

    /**
     * @Description: 获取 CO2 排放系数
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:23
     **/
    private double getCO2Factor() {
        CarbonEmissionFactor carbonEmissionFactor = calDieselFuelConsumption.carbonEmissionFactorService.selectByPrimaryKey(2);
        double CO2Factor = carbonEmissionFactor.getCo2EmissionFactor();
        return CO2Factor;
    }

    /**
     * @Description: 计算柴油转换能耗 W_diesel
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:25
     **/
    public double calWDiesel() {
        return yDiesel * this.getStandardCoaCoefficient() * 0.001;
    }

    /**
     * @Description: 计算柴油转换碳排放 T_diesel
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:26
     **/
    public double calTDiesel() {
        return yDiesel * this.getCO2Factor() * 0.001;
    }
}
