package com.calculation.service;

import com.calculation.bean.DieselFuelConsumption;
import com.calculation.dao.DieselFuelConsumptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: 柴油能耗与碳排放 DieselFuelConsumption 的 service
 * @Author: Alex McAvoy
 * @Date: 2022/5/19 23:55
 * @Version: 1.0
 **/
@Service
public class DieselFuelConsumptionService {
    @Autowired(required = false)
    DieselFuelConsumptionMapper dieselFuelConsumptionMapper;

    /**
     * @Description: 根据主键删除
     * @Param: [id]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 23:56
     **/
    public int deleteByPrimaryKey(Integer id) {
        return dieselFuelConsumptionMapper.deleteByPrimaryKey(id);
    }

    /**
     * @Description: 插入
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 23:56
     **/
    public int insert(DieselFuelConsumption record) {
        return dieselFuelConsumptionMapper.insert(record);
    }

    /**
     * @Description: 根据主键查询
     * @Param: [id]
     * @Return: com.calculation.bean.DieselFuelConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 23:57
     **/
    public DieselFuelConsumption selectByPrimaryKey(Integer id) {
        return dieselFuelConsumptionMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: 根据日期查询
     * @Param: [date]
     * @Return: com.calculation.bean.DieselFuelConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 17:03
     **/
    public DieselFuelConsumption selectByCreatedTime(Date date) {
        return dieselFuelConsumptionMapper.selectByCreatedTime(date);
    }

    /**
     * @Description: 获取日期最小的数据
     * @Param: []
     * @Return: com.calculation.bean.DieselFuelConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/6/5 12:59
     **/
    public DieselFuelConsumption getMinCreatedTime(){
        return dieselFuelConsumptionMapper.getMinCreatedTime();
    }
    
    /**
     * @Description: 获取所有数据
     * @Param: []
     * @Return: java.util.List<com.calculation.bean.DieselFuelConsumption>
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:20
     **/
    public List<DieselFuelConsumption> getAll() {
        return dieselFuelConsumptionMapper.getAll();
    }

    /**
     * @Description: 更新
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:20
     **/
    public int update(DieselFuelConsumption record) {
        return dieselFuelConsumptionMapper.update(record);
    }
}
