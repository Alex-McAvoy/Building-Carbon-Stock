package com.calculation.service;

import com.calculation.bean.HeatConsumption;
import com.calculation.dao.HeatConsumptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: 供热供冷能耗与碳排放计算 HeatConsumption 的 Service
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 0:31
 * @Version: 1.0
 **/
@Service
public class HeatConsumptionService {
    @Autowired(required = false)
    HeatConsumptionMapper heatConsumptionMapper;

    /**
     * @Description: 根据主键删除
     * @Param: [id]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:31
     **/
    public int deleteByPrimaryKey(Integer id) {
        return heatConsumptionMapper.deleteByPrimaryKey(id);
    }

    /**
     * @Description: 插入
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:32
     **/
    public int insert(HeatConsumption record) {
        return heatConsumptionMapper.insert(record);
    }

    /**
     * @Description: 根据主键查询
     * @Param: [id]
     * @Return: com.calculation.bean.HeatConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:32
     **/
    public HeatConsumption selectByPrimaryKey(Integer id) {
        return heatConsumptionMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: 根据日期查询
     * @Param: [date]
     * @Return: com.calculation.bean.HeatConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 17:05
     **/
    public HeatConsumption selectByCreatedTime(Date date) {
        return heatConsumptionMapper.selectByCreatedTime(date);
    }

    public HeatConsumption getMinCreatedTime(){
        return heatConsumptionMapper.getMinCreatedTime();
    }
    /**
     * @Description: 获取所有数据
     * @Param: []
     * @Return: java.util.List<com.calculation.bean.HeatConsumption>
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:21
     **/
    public List<HeatConsumption> getAll() {
        return heatConsumptionMapper.getAll();
    }

    /**
     * @Description: 更新
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:21
     **/
    public int update(HeatConsumption record) {
        return heatConsumptionMapper.update(record);
    }

}
