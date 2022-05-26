package com.calculation.bean;

import java.util.Date;

/**
 * @Description: 蒸汽能耗与碳排放
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 0:17
 **/
public class SteamConsumption {
    private Integer id; //id，主键
    private Double z; //输入，蒸汽消耗量，MJ
    private Double wSteam; //输出，蒸汽转换能耗，tce
    private Double tSteam; //输出，蒸汽转换碳排放，tCO2
    private Date createdTime; //输入，创建时间

    public SteamConsumption() {
    }

    public SteamConsumption(Integer id, Double z, Double wSteam, Double tSteam, Date createdTime) {
        this.id = id;
        this.z = z;
        this.wSteam = wSteam;
        this.tSteam = tSteam;
        this.createdTime = createdTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Double getWSteam() {
        return wSteam;
    }

    public void setWSteam(Double wSteam) {
        this.wSteam = wSteam;
    }

    public Double getTSteam() {
        return tSteam;
    }

    public void setTSteam(Double tSteam) {
        this.tSteam = tSteam;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "SteamConsumption{" +
                "id=" + id +
                ", z=" + z +
                ", wSteam=" + wSteam +
                ", tSteam=" + tSteam +
                ", createdTime=" + createdTime +
                '}';
    }
}