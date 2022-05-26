package com.calculation.bean;

import java.util.Date;

/**
 * @Description: 柴油能耗与碳排放
 * @Author: Alex McAvoy
 * @Date: 2022/5/19 23:51
 **/
public class DieselFuelConsumption {
    private Integer id; //id，主键
    private Double yDiesel; //输入，柴油消耗量，kg
    private Double wDiesel; //输出，柴油转换能耗，tce
    private Double tDiesel; //输出，柴油转换碳排放，tCO2
    private Date createdTime; //输入，创建时间

    public DieselFuelConsumption() {
    }

    public DieselFuelConsumption(Integer id, Double yDiesel, Double wDiesel, Double tDiesel, Date createdTime) {
        this.id = id;
        this.yDiesel = yDiesel;
        this.wDiesel = wDiesel;
        this.tDiesel = tDiesel;
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getYDiesel() {
        return yDiesel;
    }

    public void setYDiesel(Double yDiesel) {
        this.yDiesel = yDiesel;
    }

    public Double getWDiesel() {
        return wDiesel;
    }

    public void setWDiesel(Double wDiesel) {
        this.wDiesel = wDiesel;
    }

    public Double getTDiesel() {
        return tDiesel;
    }

    public void setTDiesel(Double tDiesel) {
        this.tDiesel = tDiesel;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "DieselFuelConsumption{" +
                "id=" + id +
                ", yDiesel=" + yDiesel +
                ", wDiesel=" + wDiesel +
                ", tDiesel=" + tDiesel +
                ", createdTime=" + createdTime +
                '}';
    }
}