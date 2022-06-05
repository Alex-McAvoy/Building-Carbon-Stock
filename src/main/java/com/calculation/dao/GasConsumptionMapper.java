package com.calculation.dao;

import com.calculation.bean.GasConsumption;

import java.util.Date;
import java.util.List;

/**
 * @Description: 天然气能耗与碳排放 GasConsumption 的 dao 接口
 * @Author: Alex McAvoy
 * @Date: 2022/5/19 20:50
 **/
public interface GasConsumptionMapper {
    int deleteByPrimaryKey(Integer id); //根据主键删除
    int insert(GasConsumption record); //插入
    GasConsumption selectByPrimaryKey(Integer id); //根据主键查询
    GasConsumption selectByCreatedTime(Date date); //根据日期查询
    GasConsumption getMinCreatedTime(); //获取日期最小的数据
    List<GasConsumption> getAllOrderById(); //获取按Id升序的所有数据
    List<GasConsumption> getAllOrderByCreatedTime(); //获取按日期升序的所有数据
    int update(GasConsumption record); //更新
}