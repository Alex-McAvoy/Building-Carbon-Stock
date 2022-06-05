package com.calculation.service;

import com.calculation.bean.SteamConsumption;
import com.calculation.dao.SteamConsumptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: 蒸汽能耗与碳排放 SteamConsumption 的 Service
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 0:18
 * @Version: 1.0
 **/
@Service
public class SteamConsumptionService {
    @Autowired(required = false)
    SteamConsumptionMapper steamConsumptionMapper;

    /**
     * @Description: 根据主键删除
     * @Param: [id]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:19
     **/
    public int deleteByPrimaryKey(Integer id) {
        return steamConsumptionMapper.deleteByPrimaryKey(id);
    }

    /**
     * @Description: 插入
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:19
     **/
    public int insert(SteamConsumption record) {
        return steamConsumptionMapper.insert(record);
    }

    /**
     * @Description: 根据主键查询
     * @Param: [id]
     * @Return: com.calculation.bean.SteamConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:19
     **/
    public SteamConsumption selectByPrimaryKey(Integer id) {
        return steamConsumptionMapper.selectByPrimaryKey(id);
    }

    /**
     * @Description: 根据日期查询
     * @Param: [date]
     * @Return: com.calculation.bean.SteamConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 17:06
     **/
    public SteamConsumption selectByCreatedTime(Date date) {
        return steamConsumptionMapper.selectByCreatedTime(date);
    }

    /**
     * @Description: 获取日期最小的数据
     * @Param: []
     * @Return: com.calculation.bean.SteamConsumption
     * @Author: Alex McAvoy
     * @Date: 2022/6/5 13:43
     **/
    public SteamConsumption getMinCreatedTime(){
        return steamConsumptionMapper.getMinCreatedTime();
    }
    
    /**
     * @Description: 获取所有数据
     * @Param: []
     * @Return: java.util.List<com.calculation.bean.SteamConsumption>
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:18
     **/
    public List<SteamConsumption> getAll() {
        return steamConsumptionMapper.getAll();
    }

    /**
     * @Description: 更新
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:18
     **/
    public int update(SteamConsumption record) {
        return steamConsumptionMapper.update(record);
    }
}
