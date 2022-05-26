package com.calculation.bean;

import com.factor.bean.GridEmissionFactor;

import java.util.Date;

/**
 * @Description: 电力能耗与碳排放计算
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 1:00
 **/
public class ElectricityConsumption {
    private Integer id; //id，主键
    private Double dN; //输入，暖通空调系统的用电量，kWh
    private Double dR; //输入，生活热水系统的用电量，kWh
    private Double dW; //输入，照明系统用电量，kWh
    private Double dE; //输入，其他用能设备（电梯、水泵与通风机）用电量
    private Double e; //输入，光伏发电量
    private Double wN; //输出，暖通空调能耗
    private Double wR; //输出，生活热水能耗
    private Double wW; //输出，照明能耗
    private Double wE; //输出，其他用能设备能耗
    private Double d; //输出，总用电量
    private Double wElectricity; //输出，电力转换能耗，tce
    private GridEmissionFactor gridEmissionFactor; //输入，外键，区域排放因子
    private Double tGrid; //输出，区域电力转换碳排放，tCO2
    private Date createdTime; //输入，创建时间

    public ElectricityConsumption() {
    }

    public ElectricityConsumption(Integer id, Double dN, Double dR, Double dW, Double dE, Double e, Double wN, Double wR, Double wW, Double wE, Double d, Double wElectricity, GridEmissionFactor gridEmissionFactor, Double tGrid, Date createdTime) {
        this.id = id;
        this.dN = dN;
        this.dR = dR;
        this.dW = dW;
        this.dE = dE;
        this.e = e;
        this.wN = wN;
        this.wR = wR;
        this.wW = wW;
        this.wE = wE;
        this.d = d;
        this.wElectricity = wElectricity;
        this.gridEmissionFactor = gridEmissionFactor;
        this.tGrid = tGrid;
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDN() {
        return dN;
    }

    public void setDN(Double dN) {
        this.dN = dN;
    }

    public Double getDR() {
        return dR;
    }

    public void setDR(Double dR) {
        this.dR = dR;
    }

    public Double getDW() {
        return dW;
    }

    public void setDW(Double dW) {
        this.dW = dW;
    }

    public Double getDE() {
        return dE;
    }

    public void setDE(Double dE) {
        this.dE = dE;
    }

    public Double getE() {
        return e;
    }

    public void setE(Double e) {
        this.e = e;
    }

    public Double getWN() {
        return wN;
    }

    public void setWN(Double wN) {
        this.wN = wN;
    }

    public Double getWR() {
        return wR;
    }

    public void setWR(Double wR) {
        this.wR = wR;
    }

    public Double getWW() {
        return wW;
    }

    public void setWW(Double wW) {
        this.wW = wW;
    }

    public Double getWE() {
        return wE;
    }

    public void setWE(Double wE) {
        this.wE = wE;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Double getWElectricity() {
        return wElectricity;
    }

    public void setWElectricity(Double wElectricity) {
        this.wElectricity = wElectricity;
    }

    public GridEmissionFactor getGridEmissionFactor() {
        return gridEmissionFactor;
    }

    public void setGridEmissionFactor(GridEmissionFactor gridEmissionFactor) {
        this.gridEmissionFactor = gridEmissionFactor;
    }

    public Double getTGrid() {
        return tGrid;
    }

    public void setTGrid(Double tGrid) {
        this.tGrid = tGrid;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createTime) {
        this.createdTime = createTime;
    }

    @Override
    public String toString() {
        return "ElectricityConsumption{" +
                "id=" + id +
                ", dN=" + dN +
                ", dR=" + dR +
                ", dW=" + dW +
                ", dE=" + dE +
                ", e=" + e +
                ", wN=" + wN +
                ", wR=" + wR +
                ", wW=" + wW +
                ", wE=" + wE +
                ", d=" + d +
                ", wElectricity=" + wElectricity +
                ", gridEmissionFactor=" + gridEmissionFactor +
                ", tGrid=" + tGrid +
                ", createdTime=" + createdTime +
                '}';
    }
}