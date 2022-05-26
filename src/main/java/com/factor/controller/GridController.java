package com.factor.controller;

import com.factor.bean.GridEmissionFactor;
import com.factor.service.GridEmissionFactorService;
import com.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Description: 中国区域电网基准线排放因子 GridEmissionFactor 控制器
 * @Author: Alex McAvoy
 * @Date: 2022/5/23 16:34
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/grid-factor")
public class GridController {
    @Autowired
    GridEmissionFactorService gridEmissionFactorService;

    /**
     * @Description: 获取区域排放因子 GridEmissionFactor 列表
     * @Param: []
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/23 21:04
     **/
    @ResponseBody
    @RequestMapping(value = "/getGridEmissionFactor", method = RequestMethod.GET)
    public Msg getGridEmissionFactor() {
        List<GridEmissionFactor> list = gridEmissionFactorService.getAll();
        return Msg.success().add("gridEmissionFactor", list);
    }

}
