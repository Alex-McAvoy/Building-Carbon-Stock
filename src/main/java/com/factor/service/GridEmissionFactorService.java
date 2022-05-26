package com.factor.service;

import com.factor.bean.GridEmissionFactor;
import com.factor.dao.GridEmissionFactorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 中国区域电网基准线排放因子 GridEmissionFactor 的 Service
 * @Author: Alex McAvoy
 * @Date: 2022/5/14 0:55
 * @Version: 1.0
 **/
@Service
public class GridEmissionFactorService {
    @Autowired(required = false)
    GridEmissionFactorMapper gridEmissionFactorMapper;

    /**
     * @Description: 根据主键查询
     * @Param: [areaId]
     * @Return: com.factor.bean.GridEmissionFactor
     * @Author: Alex McAvoy
     * @Date: 2022/5/14 0:57
     **/
    public GridEmissionFactor selectByPrimaryKey(Integer areaId) {
        return gridEmissionFactorMapper.selectByPrimaryKey(areaId);
    }

    /**
     * @Description: 获取所有数据
     * @Param: []
     * @Return: java.util.List<com.factor.bean.GridEmissionFactor>
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 22:03
     **/
    public List<GridEmissionFactor> getAll() {
        return gridEmissionFactorMapper.getAll();
    }

    /**
     * @Description: 更新
     * @Param: [record]
     * @Return: int
     * @Author: Alex McAvoy
     * @Date: 2022/5/23 21:55
     **/
    public int update(GridEmissionFactor record) {
        return gridEmissionFactorMapper.update(record);
    }

}
