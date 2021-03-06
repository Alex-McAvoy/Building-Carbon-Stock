package com.calculation.dao;

import com.calculation.bean.DieselFuelConsumption;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Description: 柴油能耗与碳排放 DieselFuelConsumption 的 dao 接口
 * @Author: Alex McAvoy
 * @Date: 2022/5/19 23:51
 **/
public interface DieselFuelConsumptionMapper {
    int insert(DieselFuelConsumption record); //插入
    int deleteByPrimaryKey(Integer id); //根据主键删除
    int update(DieselFuelConsumption record); //更新
    DieselFuelConsumption selectByPrimaryKey(Integer id); //根据主键查询
    DieselFuelConsumption selectByCreatedTime(Date date); //根据日期查询
    DieselFuelConsumption getMinCreatedTime(); //获取日期最小的数据
    List<DieselFuelConsumption> getAllOrderById(); //获取按Id升序的所有数据
    List<DieselFuelConsumption> getAllOrderByCreatedTime(); //获取按日期升序的所有数据

}