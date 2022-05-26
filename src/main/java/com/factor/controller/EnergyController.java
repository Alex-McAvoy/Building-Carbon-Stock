package com.factor.controller;

import com.factor.bean.EnergyCoalFactor;
import com.factor.service.EnergyCoalFactorService;
import com.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: 各种能源折标准煤参考系数 EnergyCoalFactor 控制器
 * @Author: Alex McAvoy
 * @Date: 2022/5/24 0:06
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/energy-factor")
public class EnergyController {
    @Autowired
    EnergyCoalFactorService energyCoalFactorService;

    /**
     * @Description: 获取各种能源折标准煤参考系数 EnergyCoalFactor 列表
     * @Param: []
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/23 21:04
     **/
    @ResponseBody
    @RequestMapping(value = "/getEnergyCoalFactor", method = RequestMethod.GET)
    public Msg getEnergyCoalFactor() {
        List<EnergyCoalFactor> list = energyCoalFactorService.getAll();
        return Msg.success().add("energyCoalFactor", list);
    }
}
