package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 页面导入控制器
 * @Author: Alex McAvoy
 * @Date: 2022/5/19 22:38
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/import")
public class PageController {

    /**
     * @Description: 数据导入页
     * @Param: []
     * @Return: java.lang.String
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 21:06
     **/
    @RequestMapping("/data-input")
    public String toDataInputPage(){
        return "/import/data-input";
    }

    /**
     * @Description: 电力计算页
     * @Param: []
     * @Return: java.lang.String
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 21:06
     **/
    @RequestMapping("/calculation/electricity")
    public String importElectricityPage(){
        return "/import/calculation/electricity";
    }

    /**
     * @Description: 天然气计算页
     * @Param: []
     * @Return: java.lang.String
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 21:06
     **/
    @RequestMapping("/calculation/gas")
    public String importGasPage(){
        return "/import/calculation/gas";
    }

    /**
     * @Description: 汽油计算页
     * @Param: []
     * @Return: java.lang.String
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 21:06
     **/
    @RequestMapping("/calculation/gasoline")
    public String importGasolinePage(){
        return "/import/calculation/gasoline";
    }

    /**
     * @Description: 柴油计算页
     * @Param: []
     * @Return: java.lang.String
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 21:06
     **/
    @RequestMapping("/calculation/dieselFuel")
    public String importDieselFuelPage(){
        return "/import/calculation/dieselFuel";
    }

    /**
     * @Description: 蒸汽计算页
     * @Param: []
     * @Return: java.lang.String
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 21:06
     **/
    @RequestMapping("/calculation/steam")
    public String importSteamPage(){
        return "/import/calculation/steam";
    }

    /**
     * @Description: 供热供冷计算页
     * @Param: []
     * @Return: java.lang.String
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 21:06
     **/
    @RequestMapping("/calculation/heat")
    public String importHeatingCoolingPage(){
        return "/import/calculation/heat";
    }

    /**
     * @Description: 因子库展示页
     * @Param: []
     * @Return: java.lang.String
     * @Author: Alex McAvoy
     * @Date: 2022/5/23 16:21
     **/
    @RequestMapping("/factor-show")
    public String importFactorShowPage(){
        return "/import/factor-show";
    }

}
