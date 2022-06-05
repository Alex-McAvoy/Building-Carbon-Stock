package com.calculation.dao;

import com.calculation.bean.HeatConsumption;

import java.util.Date;
import java.util.List;

/**
 * @Description: 供热供冷能耗与碳排放计算 HeatConsumption 的 dao 接口
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 0:29
 **/
public interface HeatConsumptionMapper {
    int insert(HeatConsumption record); //插入
    int deleteByPrimaryKey(Integer id); //根据主键删除
    int update(HeatConsumption record); //更新
    HeatConsumption selectByPrimaryKey(Integer id); //根据主键查询
    HeatConsumption selectByCreatedTime(Date date); //根据日期查询
    HeatConsumption getMinCreatedTime(); //获取日期最小的数据
    List<HeatConsumption> getAllOrderById(); //获取按Id升序的所有数据
    List<HeatConsumption> getAllOrderByCreatedTime(); //获取按日期升序的所有数据
}