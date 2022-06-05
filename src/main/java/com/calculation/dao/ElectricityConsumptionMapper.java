package com.calculation.dao;

import com.calculation.bean.ElectricityConsumption;

import java.util.Date;
import java.util.List;

/**
 * @Description: 电力能耗与碳排放计算 ElectricityConsumption 的 dao 接口
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 1:00
 **/
public interface ElectricityConsumptionMapper {
    int insert(ElectricityConsumption record); //插入
    int deleteByPrimaryKey(Integer id); //根据主键删除
    int update(ElectricityConsumption record); //更新
    ElectricityConsumption selectByPrimaryKey(Integer id); //根据主键查询
    ElectricityConsumption selectByCreatedTime(Date date); //根据日期查询
    ElectricityConsumption getMinCreatedTime(); //获取日期最小的数据
    List<ElectricityConsumption> getAllOrderById(); //获取按Id升序的所有数据
    List<ElectricityConsumption> getAllOrderByCreatedTime(); //获取按日期升序的所有数据
}