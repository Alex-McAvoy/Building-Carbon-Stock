package com.factor.dao;

import com.factor.bean.GridEmissionFactor;

import java.util.List;

/**
 * @Description: 中国区域电网基准线排放因子 GridEmissionFactor 的 dao 接口
 * @Author: Alex McAvoy
 * @Date: 2022/5/14 0:43
 **/
public interface GridEmissionFactorMapper {
    GridEmissionFactor selectByPrimaryKey(Integer areaId); //根据主键查询
    List<GridEmissionFactor> getAll(); //获取所有数据
    int update(GridEmissionFactor record); //更新

}