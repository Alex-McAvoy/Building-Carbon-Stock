package com.calculation.dao;

import com.calculation.bean.SteamConsumption;

import java.util.Date;
import java.util.List;

/**
 * @Description: 蒸汽能耗与碳排放 SteamConsumption 的 dao 接口
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 0:17
 **/
public interface SteamConsumptionMapper {
    int insert(SteamConsumption record); //插入
    int deleteByPrimaryKey(Integer id); //根据主键删除
    int update(SteamConsumption record); //更新
    SteamConsumption selectByPrimaryKey(Integer id); //根据主键查询
    SteamConsumption selectByCreatedTime(Date date); //根据日期查询
    SteamConsumption getMinCreatedTime(); //获取日期最小的数据
    List<SteamConsumption> getAllOrderById(); //获取按Id升序的所有数据
    List<SteamConsumption> getAllOrderByCreatedTime(); //获取按日期升序的所有数据
}