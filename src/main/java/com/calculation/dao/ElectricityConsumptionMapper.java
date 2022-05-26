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
    int deleteByPrimaryKey(Integer id); //根据主键删除
    int insert(ElectricityConsumption record); //插入
    ElectricityConsumption selectByPrimaryKey(Integer id); //根据主键查询
    ElectricityConsumption selectByCreatedTime(Date date); //根据日期查询
    List<ElectricityConsumption> getAll(); //获取所有数据
    int update(ElectricityConsumption record); //更新
}