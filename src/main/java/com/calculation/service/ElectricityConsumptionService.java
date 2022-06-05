package com.calculation.service;

import com.calculation.bean.ElectricityConsumption;
import com.calculation.dao.ElectricityConsumptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: 电力能耗与碳排放计算 ElectricityConsumption 的 dao 接口
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 1:01
 * @Version: 1.0
 **/
@Service
public class ElectricityConsumptionService {
    @Autowired(required = false)
    ElectricityConsumptionMapper electricityConsumptionMapper;

    /**
     * @Description: 根据主键删除
     * @Param: [id]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 1:02
     **/
    public int deleteByPrimaryKey(Integer id) {
        return electricityConsumptionMapper.deleteByPrimaryKey(id);
    }

    /**
     * @Description: 插入
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 1:02
     **/
    public int insert(ElectricityConsumption record) {
        return electricityConsumptionMapper.insert(record);
    }

    /**
     * @Description: 根据主键查询
     * @Param: [id]
     * @Return: com.calculation.bean.ElectricityConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 1:02
     **/
    public ElectricityConsumption selectByPrimaryKey(Integer id) {
        return electricityConsumptionMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: 根据日期查询
     * @Param: [date]
     * @Return: com.calculation.bean.ElectricityConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 16:37
     **/
    public ElectricityConsumption selectByCreatedTime(Date date) {
        return electricityConsumptionMapper.selectByCreatedTime(date);
    }

    /**
     * @Description: 获取日期最小的数据
     * @Param: []
     * @Return: com.calculation.bean.ElectricityConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/6/5 14:09
     **/
    public ElectricityConsumption getMinCreatedTime() {
        return electricityConsumptionMapper.getMinCreatedTime();
    }

    /**
     * @Description: 获取所有数据
     * @Param: []
     * @Return: java.util.List<com.calculation.bean.ElectricityConsumption>
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 19:15
     **/
    public List<ElectricityConsumption> getAll() {
        return electricityConsumptionMapper.getAll();
    }

    /**
     * @Description: 更新
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 23:36
     **/
    public int update(ElectricityConsumption record) {
        return electricityConsumptionMapper.update(record);
    }
}
