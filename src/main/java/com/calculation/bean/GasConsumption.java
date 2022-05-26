package com.calculation.bean;

import java.util.Date;

/**
 * @Description: 天然气能耗与碳排放
 * @Author: Alex McAvoy
 * @Date: 2022/5/19 20:48
 **/
public class GasConsumption {
    private Integer id; //id，主键
    private Double q; //输入，天然气消耗量，m3
    private Double wGas; //输出，天然气转换能耗，tce
    private Double tGas; //输出，天然气转换碳排放，tCO2
    private Date createdTime; //输入，创建时间

    public GasConsumption() {
    }

    public GasConsumption(Integer id, Double q, Double wGas, Double tGas, Date createdTime) {
        this.id = id;
        this.q = q;
        this.wGas = wGas;
        this.tGas = tGas;
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQ() {
        return q;
    }

    public void setQ(Double q) {
        this.q = q;
    }

    public Double getWGas() {
        return wGas;
    }

    public void setWGas(Double wGas) {
        this.wGas = wGas;
    }

    public Double getTGas() {
        return tGas;
    }

    public void setTGas(Double tGas) {
        this.tGas = tGas;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "GasConsumptionAndCarbonEmission{" +
                "id=" + id +
                ", q=" + q +
                ", wGas=" + wGas +
                ", tGas=" + tGas +
                ", createdTime=" + createdTime +
                '}';
    }
}