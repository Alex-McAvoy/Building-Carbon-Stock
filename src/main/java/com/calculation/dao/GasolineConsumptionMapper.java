package com.calculation.dao;

import com.calculation.bean.GasolineConsumption;

import java.util.Date;
import java.util.List;

/**
 * @Description: 汽油能耗与碳排放计算 GasolineConsumption 的 dao 接口
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 0:04
 **/
public interface GasolineConsumptionMapper {
    int insert(GasolineConsumption record); //插入
    int deleteByPrimaryKey(Integer id); //根据主键删除
    int update(GasolineConsumption record); //更新
    GasolineConsumption selectByPrimaryKey(Integer id); //根据主键查询
    GasolineConsumption selectByCreatedTime(Date date); //根据日期查询
    GasolineConsumption getMinCreatedTime(); //获取日期最小的数据
    List<GasolineConsumption> getAllOrderById(); //获取按Id升序的所有数据
    List<GasolineConsumption> getAllOrderByCreatedTime(); //获取按日期升序的所有数据
}