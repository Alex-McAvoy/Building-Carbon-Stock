package com.calculation.bean;

import java.util.Date;

/**
 * @Description: 汽油能耗与碳排放
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 0:05
 **/
public class GasolineConsumption {
    private Integer id; //id，主键
    private Double yGasoline; //输入，汽油消耗量，kg
    private Double wGasoline; //输出，汽油转换能耗，tce
    private Double tGasoline; //输出，汽油转换碳排放，tCO2
    private Date createdTime; //输入，创建时间

    public GasolineConsumption() {
    }

    public GasolineConsumption(Integer id, Double yGasoline, Double wGasoline, Double tGasoline, Date createdTime) {
        this.id = id;
        this.yGasoline = yGasoline;
        this.wGasoline = wGasoline;
        this.tGasoline = tGasoline;
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getYGasoline() {
        return yGasoline;
    }

    public void setYGasoline(Double yGasoline) {
        this.yGasoline = yGasoline;
    }

    public Double getWGasoline() {
        return wGasoline;
    }

    public void setWGasoline(Double wGasoline) {
        this.wGasoline = wGasoline;
    }

    public Double getTGasoline() {
        return tGasoline;
    }

    public void setTGasoline(Double tGasoline) {
        this.tGasoline = tGasoline;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "GasolineConsumption{" +
                "id=" + id +
                ", yGasoline=" + yGasoline +
                ", wGasoline=" + wGasoline +
                ", tGasoline=" + tGasoline +
                ", createdTime=" + createdTime +
                '}';
    }
}