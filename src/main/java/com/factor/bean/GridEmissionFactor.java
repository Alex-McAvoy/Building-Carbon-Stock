package com.factor.bean;

/**
 * @Description: 中国区域电网基准线排放因子
 * @Author: Alex McAvoy
 * @Date: 2022/5/14 0:35
 **/
public class GridEmissionFactor {
    private Integer areaId; //区域编号，主键
    private String gridName; //电网名称
    private Double om; //EF grid,OMSimple
    private Double bm; //EF grid,BM

    public GridEmissionFactor() {
    }

    public GridEmissionFactor(Integer areaId, String gridName, Double om, Double bm) {
        this.areaId = areaId;
        this.gridName = gridName;
        this.om = om;
        this.bm = bm;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName == null ? null : gridName.trim();
    }

    public Double getOm() {
        return om;
    }

    public void setOm(Double om) {
        this.om = om;
    }

    public Double getBm() {
        return bm;
    }

    public void setBm(Double bm) {
        this.bm = bm;
    }

    @Override
    public String toString() {
        return "GridEmissionFactor{" +
                "areaId=" + areaId +
                ", gridName='" + gridName + '\'' +
                ", om=" + om +
                ", bm=" + bm +
                '}';
    }
}