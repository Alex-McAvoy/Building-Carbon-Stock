package com.factor.service;

import com.factor.bean.CarbonEmissionFactor;
import com.factor.dao.CarbonEmissionFactorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 各种能源折碳排放因子 CarbonEmissionFactor 的 Service
 * @Author: Alex McAvoy
 * @Date: 2022/5/14 0:46
 * @Version: 1.0
 **/
@Service
public class CarbonEmissionFactorService {
    @Autowired(required = false)
    CarbonEmissionFactorMapper carbonEmissionFactorMapper;

    /**
     * @Description: 根据主键查询
     * @Param: [energyName]
     * @Return: com.factor.bean.CarbonEmissionFactor
     * @Author: Alex McAvoy
     * @Date: 2022/5/14 0:50
     **/
    public CarbonEmissionFactor selectByPrimaryKey(Integer carbonId) {
        return carbonEmissionFactorMapper.selectByPrimaryKey(carbonId);
    }

    /**
     * @Description: 获取所有数据
     * @Param: []
     * @Return: java.util.List<com.factor.bean.CarbonEmissionFactor>
     * @Author: Alex McAvoy
     * @Date: 2022/5/23 20:31
     **/
    public List<CarbonEmissionFactor> getAll() {
        return carbonEmissionFactorMapper.getAll();
    }

    /**
     * @Description: 更新
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/23 21:55
     **/
    public int update(CarbonEmissionFactor record) {
        return carbonEmissionFactorMapper.update(record);
    }

}
