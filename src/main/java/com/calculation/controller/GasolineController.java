package com.calculation.controller;

import com.calculation.bean.GasolineConsumption;
import com.calculation.service.GasolineConsumptionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.utils.DateParse;
import com.utils.Msg;
import com.utils.calculation.CalGasolineConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: 汽油能耗与碳排放 GasolineConsumption 控制器
 * @Author: Alex McAvoy
 * @Date: 2022/5/22 2:37
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/gasoline-consumption")
public class GasolineController {
    @Autowired
    GasolineConsumptionService gasolineConsumptionService;

    /**
     * @Description: 保存汽油能耗能耗与碳排放 GasolineConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 1:55
     **/
    @ResponseBody
    @RequestMapping(value = "/saveGasolineConsumptionForm", method = RequestMethod.POST)
    public Msg saveGasolineConsumptionForm(@RequestBody Map<String, String> map) {
        double yGasoline = Double.parseDouble(map.get("yGasoline")); //输入，天然气消耗量，m3
        Date createdTime = new DateParse(map.get("createdTime")).getCreatedTime(); //输入，创建时间

        GasolineConsumption judgeObj = gasolineConsumptionService.selectByCreatedTime(createdTime);
        if (judgeObj != null) {
            return Msg.fail().add("message", map.get("createdTime") + " 的数据已存在，请确认日期无误");
        } else {
            CalGasolineConsumption calObj = new CalGasolineConsumption(yGasoline);
            double wGasoline = calObj.calWGasoline(); //输出，汽油转换能耗，tce
            double tGasoline = calObj.calTGasoline(); //汽油转换碳排放，tCO2

            GasolineConsumption obj = new GasolineConsumption(null, yGasoline, wGasoline, tGasoline, createdTime);
            gasolineConsumptionService.insert(obj);

            return Msg.success().add("message", "提交成功");
        }
    }

    /**
     * @Description: 获取汽油能耗与碳排放 GasolineConsumption 分页数据
     * @Param: [pn]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:48
     **/
    @ResponseBody
    @RequestMapping(value = "/getGasolineConsumption", method = RequestMethod.GET)
    public Msg getGasolineConsumption(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10); //分页查询
        List<GasolineConsumption> list = gasolineConsumptionService.getAllOrderById();
        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
    }

    /**
     * @Description: 更新汽油能耗与碳排放 GasolineConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 3:05
     **/
    @ResponseBody
    @RequestMapping(value = "/updateGasolineConsumption", method = RequestMethod.PUT)
    public Msg updateGasolineConsumption(@RequestBody Map<String, String> map) {
        int id = Integer.parseInt(map.get("id")); //id
        double yGasoline = Double.parseDouble(map.get("yGasoline")); //输入，汽油消耗量

        CalGasolineConsumption calObj = new CalGasolineConsumption(yGasoline);
        double wGasoline = calObj.calWGasoline(); //输出，汽油转换能耗
        double tGasoline = calObj.calTGasoline(); //输出，汽油转换碳排放

        GasolineConsumption obj = new GasolineConsumption(id,yGasoline,wGasoline,tGasoline,null);
        gasolineConsumptionService.update(obj);

        return Msg.success().add("message", "更新成功");
    }

    /**
     * @Description: 删除汽油能耗与碳排放 GasolineConsumption
     * @Param: [id]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 3:09
     **/
    @ResponseBody
    @RequestMapping(value = "/deleteGasolineConsumption/{id}", method = RequestMethod.DELETE)
    public Msg deleteGasolineConsumption(@PathVariable("id") String id){
        int deleteId = Integer.parseInt(id);
        gasolineConsumptionService.deleteByPrimaryKey(deleteId);
        return Msg.success().add("message","删除成功");
    }

    /**
     * @Description: 获取汽油能耗与碳排放 GasolineConsumption 所有数据
     * @Param: []
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/6/4 5:02
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllGasolineConsumption",method = RequestMethod.GET)
    public Msg getAllGasolineConsumption() {
        List<GasolineConsumption> list = gasolineConsumptionService.getAllOrderByCreatedTime();
        return Msg.success().add("list",list);
    }

}
