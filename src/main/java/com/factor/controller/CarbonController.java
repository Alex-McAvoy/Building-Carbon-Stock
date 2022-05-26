package com.factor.controller;

import com.factor.bean.CarbonEmissionFactor;
import com.factor.service.CarbonEmissionFactorService;
import com.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: 各种能源折碳排放因子 CarbonEmissionFactor 控制器
 * @Author: Alex McAvoy
 * @Date: 2022/5/24 0:20
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/carbon-factor")
public class CarbonController {
    @Autowired
    CarbonEmissionFactorService carbonEmissionFactorService;

    @ResponseBody
    @RequestMapping(value = "/getCarbonEmission", method = RequestMethod.GET)
    public Msg getCarbonEmission() {
        List<CarbonEmissionFactor> list = carbonEmissionFactorService.getAll();
        return Msg.success().add("carbonEmissionFactor", list);
    }
}
