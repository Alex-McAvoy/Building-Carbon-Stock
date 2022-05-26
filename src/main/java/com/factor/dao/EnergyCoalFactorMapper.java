package com.factor.dao;

import com.factor.bean.EnergyCoalFactor;

import java.util.List;

/**
 * @Description: 各种能源折标准煤参考系数 EnergyCoalFactor 的 dao 接口
 * @Author: Alex McAvoy
 * @Date: 2022/5/14 0:40
 **/
public interface EnergyCoalFactorMapper {
      EnergyCoalFactor selectByPrimaryKey(Integer energyId); //根据主键查询
      List<EnergyCoalFactor> getAll(); //获取所有数据
      int update(EnergyCoalFactor record); //更新
}