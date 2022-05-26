package com.utils.calculation;

import com.factor.bean.EnergyCoalFactor;
import com.factor.bean.GridEmissionFactor;
import com.factor.service.EnergyCoalFactorService;
import com.factor.service.GridEmissionFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @Description: 电力能耗与碳排放 ElectricityConsumption 计算
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 23:12
 * @Version: 1.0
 **/
@Component
public class CalElectricityConsumption {
    private double dN; //暖通空调系统的用电量
    private double dR; //生活热水系统的用电量
    private double dW; //照明系统用电量
    private double dE; //其他用能设备用电量
    private double e; //光伏发电量
    private Integer areaId; //区域对应 OM 因子

    public CalElectricityConsumption() {
    }

    public CalElectricityConsumption(double dN, double dR, double dW, double dE, double e, Integer areaId) {
        this.dN = dN;
        this.dR = dR;
        this.dW = dW;
        this.dE = dE;
        this.e = e;
        this.areaId = areaId;
    }

    @Autowired
    EnergyCoalFactorService energyCoalFactorService;
    @Autowired
    GridEmissionFactorService gridEmissionFactorService;
    
    public static CalElectricityConsumption calElectricityConsumption;
    
    @PostConstruct
    public void init() {
        calElectricityConsumption = this;
    }
    
    /**
     * @Description: 获取折标准煤系数
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 1:17
     **/
    private double getStandardCoaCoefficient(){
        EnergyCoalFactor energyCoalFactor = calElectricityConsumption.energyCoalFactorService.selectByPrimaryKey(5);
        double factor = energyCoalFactor.getStandardCoaCoefficient(); //电力（当量值）的折标准煤系数
        return factor;
    }

    /**
     * @Description: 获取区域对应的 om
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 1:19
     **/
    private double getOM() {
        GridEmissionFactor gridEmissionFactor = calElectricityConsumption.gridEmissionFactorService.selectByPrimaryKey(areaId);
        double om = gridEmissionFactor.getOm();
        return om;
    }

    /**
     * @Description: 计算总用电量 D
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 23:16
     **/
    public double calD() {
        return dN + dR + dW + dE - e;
    }

    /**
     * @Description: 计算暖通空调能耗 Wn
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 23:17
     **/
    public double calWN() {
        return dN * this.getStandardCoaCoefficient() * 0.001;
    }

    /**
     * @Description: 计算生活热水能耗 Wr
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 23:17
     **/
    public double calWR() {
        return dR * this.getStandardCoaCoefficient() * 0.001;
    }

    /**
     * @Description: 计算照明能耗 We
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 23:17
     **/
    public double calWW() {
        return dW * this.getStandardCoaCoefficient() * 0.001;
    }

    /**
     * @Description: 其他用能设备能耗 We
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 23:17
     **/
    public double calWE() {
        return dE * this.getStandardCoaCoefficient() * 0.001;
    }

    /**
     * @Description: 计算电力转换能耗 W_electricity
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 23:30
     **/
    public double calWElectricity() {
        return this.calD() * this.getStandardCoaCoefficient() * 0.001;
    }

    /**
     * @Description: 计算选定区域电力转换碳排放 T_grid
     * @Param: []
     * @Return: double
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 23:34
     **/
    public double calTGrid() {
        return (this.calD() / 1000) * this.getOM();
    }
}
