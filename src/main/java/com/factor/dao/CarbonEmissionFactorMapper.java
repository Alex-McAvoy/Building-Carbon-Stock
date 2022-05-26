package com.factor.dao;

import com.factor.bean.CarbonEmissionFactor;

import java.util.List;

/**
 * @Description: 各种能源折碳排放因子 GridEmissionFactor 的 dao 接口
 * @Author: Alex McAvoy
 * @Date: 2022/5/14 0:37
 **/
public interface CarbonEmissionFactorMapper {
    CarbonEmissionFactor selectByPrimaryKey(Integer carbonId); //根据主键查询
    List<CarbonEmissionFactor> getAll(); //获取所有数据
    int update(CarbonEmissionFactor record); //更新
}