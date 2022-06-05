package com.calculation.service;

import com.calculation.bean.GasConsumption;
import com.calculation.dao.GasConsumptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: 天然气能耗与碳排放 GasConsumptionAndCarbonEmission 的 Service
 * @Author: Alex McAvoy
 * @Date: 2022/5/19 20:51
 * @Version: 1.0
 **/
@Service
public class GasConsumptionService {
    @Autowired(required = false)
    GasConsumptionMapper gasConsumptionAndCarbonEmissionMapper;

    /**
     * @Description: 根据主键删除
     * @Param: [id]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 20:52
     **/
    public int deleteByPrimaryKey(Integer id){
        return gasConsumptionAndCarbonEmissionMapper.deleteByPrimaryKey(id);
    }
    
    /**
     * @Description: 插入
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 20:52
     **/
    public int insert(GasConsumption record){
        return gasConsumptionAndCarbonEmissionMapper.insert(record);
    }

    /**
     * @Description: //根据主键查询
     * @Param: [id]
     * @Return: com.calculation.bean.GasConsumptionAndCarbonEmission
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 20:53
     **/
    public GasConsumption selectByPrimaryKey(Integer id){
        return gasConsumptionAndCarbonEmissionMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: 根据日期查询
     * @Param: [date]
     * @Return: com.calculation.bean.GasConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 17:04
     **/
    public GasConsumption selectByCreatedTime(Date date) {
        return gasConsumptionAndCarbonEmissionMapper.selectByCreatedTime(date);
    }
    
    /**
     * @Description: 获取日期最小的数据
     * @Param: []
     * @Return: com.calculation.bean.GasConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/6/5 14:08
     **/
    public GasConsumption getMinCreatedTime(){
        return gasConsumptionAndCarbonEmissionMapper.getMinCreatedTime();
    }
    
    /**
     * @Description: 获取所有数据
     * @Param: []
     * @Return: java.util.List<com.calculation.bean.GasConsumption>
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:21
     **/
    public List<GasConsumption> getAll() {
        return gasConsumptionAndCarbonEmissionMapper.getAll();
    }

    /**
     * @Description: 更新
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:21
     **/
    public int update(GasConsumption record) {
        return gasConsumptionAndCarbonEmissionMapper.update(record);
    }

}
