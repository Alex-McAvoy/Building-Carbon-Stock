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
    int deleteByPrimaryKey(Integer id); //根据主键删除
    int insert(SteamConsumption record); //插入
    SteamConsumption selectByPrimaryKey(Integer id); //根据主键查询
    SteamConsumption selectByCreatedTime(Date date); //根据日期查询
    List<SteamConsumption> getAll(); //获取所有数据
    int update(SteamConsumption record); //更新
}