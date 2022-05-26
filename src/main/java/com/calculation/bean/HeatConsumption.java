package com.calculation.bean;

import java.util.Date;

/**
 * @Description: 供热供冷能耗与碳排放
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 0:29
 **/
public class HeatConsumption {
    private Integer id; //id，主键
    private Double r; //输入，热量/冷量，MJ
    private Double wHeat; //输出，热量/冷量转换能耗，tce
    private Double tHeat; //输出，热量/冷量转换碳排放，tCO2
    private Date createdTime; //输入，创建时间

    public HeatConsumption() {
    }

    public HeatConsumption(Integer id, Double r, Double wHeat, Double tHeat, Date createdTime) {
        this.id = id;
        this.r = r;
        this.wHeat = wHeat;
        this.tHeat = tHeat;
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Double getWHeat() {
        return wHeat;
    }

    public void setWHeat(Double wHeat) {
        this.wHeat = wHeat;
    }

    public Double getTHeat() {
        return tHeat;
    }

    public void setTHeat(Double tHeat) {
        this.tHeat = tHeat;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "HeatConsumption{" +
                "id=" + id +
                ", r=" + r +
                ", wHeat=" + wHeat +
                ", tHeat=" + tHeat +
                ", createdTime=" + createdTime +
                '}';
    }
}