package com.calculation.service;

import com.calculation.bean.GasolineConsumption;
import com.calculation.dao.GasolineConsumptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: 汽油能耗与碳排放计算 GasolineConsumption 的 Service
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 0:08
 * @Version: 1.0
 **/
@Service
public class GasolineConsumptionService {
    @Autowired(required = false)
    GasolineConsumptionMapper gasolineConsumptionMapper;

    /**
     * @Description: 插入
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:09
     **/
    public int insert(GasolineConsumption record) {
        return gasolineConsumptionMapper.insert(record);
    }

    /**
     * @Description: 根据主键删除
     * @Param: [id]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:08
     **/
    public int deleteByPrimaryKey(Integer id) {
        return gasolineConsumptionMapper.deleteByPrimaryKey(id);
    }

    /**
     * @Description: 更新
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:21
     **/
    public int update(GasolineConsumption record) {
        return gasolineConsumptionMapper.update(record);
    }


    /**
     * @Description: 根据主键查询
     * @Param: [id]
     * @Return: com.calculation.bean.GasolineConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:09
     **/
    public GasolineConsumption selectByPrimaryKey(Integer id) {
        return gasolineConsumptionMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: 根据日期查询
     * @Param: [date]
     * @Return: com.calculation.bean.GasolineConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 17:05
     **/
    public GasolineConsumption selectByCreatedTime(Date date) {
        return gasolineConsumptionMapper.selectByCreatedTime(date);
    }

    /**
     * @Description: 获取日期最小的数据
     * @Param: []
     * @Return: com.calculation.bean.GasolineConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/6/5 13:51
     **/
    public GasolineConsumption getMinCreatedTime() {
        return gasolineConsumptionMapper.getMinCreatedTime();
    }

    /**
     * @Description: 获取按Id升序的所有数据
     * @Param: []
     * @Return: java.util.List<com.calculation.bean.GasolineConsumption>
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:21
     **/
    public List<GasolineConsumption> getAllOrderById() {
        return gasolineConsumptionMapper.getAllOrderById();
    }

    /**
     * @Description: 获取按日期升序的所有数据
     * @Param: []
     * @Return: java.util.List<com.calculation.bean.GasolineConsumption>
     * @Author: Alex McAvoy
     * @Date: 2022/6/5 22:00
     **/
    public List<GasolineConsumption> getAllOrderByCreatedTime() {
        return gasolineConsumptionMapper.getAllOrderByCreatedTime();
    }

}
