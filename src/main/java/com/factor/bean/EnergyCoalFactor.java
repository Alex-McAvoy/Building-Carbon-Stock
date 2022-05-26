package com.factor.bean;

/**
 * @Description: 各种能源折标准煤参考系数
 * @Author: Alex McAvoy
 * @Date: 2022/5/14 0:34
 **/
public class EnergyCoalFactor {
    private Integer energyId; //id，主键
    private String energyName; //能源名称
    private Integer averageLowCalorificValue; //平均低位发热量
    private Double standardCoaCoefficient; //折标准煤系数

    public EnergyCoalFactor() {
    }

    public EnergyCoalFactor(Integer energyId, String energyName, Integer averageLowCalorificValue, Double standardCoaCoefficient) {
        this.energyId = energyId;
        this.energyName = energyName;
        this.averageLowCalorificValue = averageLowCalorificValue;
        this.standardCoaCoefficient = standardCoaCoefficient;
    }

    public Integer getEnergyId() {
        return energyId;
    }

    public void setEnergyId(Integer energyId) {
        this.energyId = energyId;
    }

    public String getEnergyName() {
        return energyName;
    }

    public void setEnergyName(String energyName) {
        this.energyName = energyName == null ? null : energyName.trim();
    }

    public Integer getAverageLowCalorificValue() {
        return averageLowCalorificValue;
    }

    public void setAverageLowCalorificValue(Integer averageLowCalorificValue) {
        this.averageLowCalorificValue = averageLowCalorificValue;
    }

    public Double getStandardCoaCoefficient() {
        return standardCoaCoefficient;
    }

    public void setStandardCoaCoefficient(Double standardCoaCoefficient) {
        this.standardCoaCoefficient = standardCoaCoefficient;
    }

    @Override
    public String toString() {
        return "EnergyCoalFactor{" +
                "energyId=" + energyId +
                ", energyName='" + energyName + '\'' +
                ", averageLowCalorificValue=" + averageLowCalorificValue +
                ", standardCoaCoefficient=" + standardCoaCoefficient +
                '}';
    }
}