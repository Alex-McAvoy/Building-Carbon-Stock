package com.factor.service;

import com.factor.bean.EnergyCoalFactor;
import com.factor.dao.EnergyCoalFactorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 各种能源折标准煤参考系数 EnergyCoalFactor 的 Service
 * @Author: Alex McAvoy
 * @Date: 2022/5/14 0:51
 * @Version: 1.0
 **/
@Service
public class EnergyCoalFactorService {
    @Autowired(required = false)
    EnergyCoalFactorMapper energyCoalFactorMapper;

    /**
     * @Description: 根据主键查询
     * @Param: [energyName]
     * @Return: com.factor.bean.EnergyCoalFactor
     * @Author: Alex McAvoy
     * @Date: 2022/5/14 0:53
     **/
    public EnergyCoalFactor selectByPrimaryKey(Integer energyId) {
        return energyCoalFactorMapper.selectByPrimaryKey(energyId);
    }

    /**
     * @Description: 获取所有数据
     * @Param: []
     * @Return: java.util.List<com.factor.bean.EnergyCoalFactor>
     * @Author: Alex McAvoy
     * @Date: 2022/5/23 20:30
     **/
    public List<EnergyCoalFactor> getAll() {
        return energyCoalFactorMapper.getAll();
    }

    /**
     * @Description: 更新
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/23 21:54
     **/
    public int update(EnergyCoalFactor record) {
        return energyCoalFactorMapper.update(record);
    }

}
