package com.factor.bean;

/**
 * @Description: 各种能源折碳排放因子
 * @Author: Alex McAvoy
 * @Date: 2022/5/14 0:33
 **/
public class CarbonEmissionFactor {
    private Integer carbonId; //id，主键
    private String energyName; //能源名称
    private Double carbonContent; //单位热值含碳量（吨碳/TJ）
    private Double carbonOxidationRate; //碳氧化率
    private Double co2EmissionFactor; //CO2排放系数（kgCO2/kg）

    public CarbonEmissionFactor() {
    }

    public CarbonEmissionFactor(Integer carbonId, String energyName, Double carbonContent, Double carbonOxidationRate, Double co2EmissionFactor) {
        this.carbonId = carbonId;
        this.energyName = energyName;
        this.carbonContent = carbonContent;
        this.carbonOxidationRate = carbonOxidationRate;
        this.co2EmissionFactor = co2EmissionFactor;
    }

    public Integer getCarbonId() {
        return carbonId;
    }

    public void setCarbonId(Integer carbonId) {
        this.carbonId = carbonId;
    }

    public String getEnergyName() {
        return energyName;
    }

    public void setEnergyName(String energyName) {
        this.energyName = energyName == null ? null : energyName.trim();
    }

    public Double getCarbonContent() {
        return carbonContent;
    }

    public void setCarbonContent(Double carbonContent) {
        this.carbonContent = carbonContent;
    }

    public Double getCarbonOxidationRate() {
        return carbonOxidationRate;
    }

    public void setCarbonOxidationRate(Double carbonOxidationRate) {
        this.carbonOxidationRate = carbonOxidationRate;
    }

    public Double getCo2EmissionFactor() {
        return co2EmissionFactor;
    }

    public void setCo2EmissionFactor(Double co2EmissionFactor) {
        this.co2EmissionFactor = co2EmissionFactor;
    }

    @Override
    public String toString() {
        return "CarbonEmissionFactor{" +
                "carbonId=" + carbonId +
                ", energyName='" + energyName + '\'' +
                ", carbonContent=" + carbonContent +
                ", carbonOxidationRate=" + carbonOxidationRate +
                ", co2EmissionFactor=" + co2EmissionFactor +
                '}';
    }
}