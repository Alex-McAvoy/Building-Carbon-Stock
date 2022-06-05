package com.calculation.controller;

import com.calculation.bean.HeatConsumption;
import com.calculation.service.HeatConsumptionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.utils.DateParse;
import com.utils.Msg;
import com.utils.calculation.CalHeatConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: 供热供冷能耗与碳排放 HeatConsumption 控制器
 * @Author: Alex McAvoy
 * @Date: 2022/5/22 2:37
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/heat-consumption")
public class HeatController {
    @Autowired
    HeatConsumptionService heatConsumptionService;

    /**
     * @Description: 保存供热供冷能耗与碳排放 HeatConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:55
     **/
    @ResponseBody
    @RequestMapping(value = "/saveHeatConsumptionForm", method = RequestMethod.POST)
    public Msg saveHeatConsumptionForm(@RequestBody Map<String, String> map) {
        double r = Double.parseDouble(map.get("r")); //输入，热量/冷量消耗量，MJ
        Date createdTime = new DateParse(map.get("createdTime")).getCreatedTime(); //输入，创建时间

        HeatConsumption judgeObj = heatConsumptionService.selectByCreatedTime(createdTime);
        if (judgeObj != null) {
            return Msg.fail().add("message", map.get("createdTime") + " 的数据已存在，请确认日期无误");
        } else {
            CalHeatConsumption calObj = new CalHeatConsumption(r);
            double wHeat = calObj.calWHeat(); //输出，热量/冷量转换能耗，tce
            double tHeat = calObj.calTHeat(); //输出，热量/冷量转换碳排放，tCO2

            HeatConsumption obj = new HeatConsumption(null, r, wHeat, tHeat, createdTime);
            heatConsumptionService.insert(obj);

            return Msg.success().add("message", "提交成功");
        }
    }

    /**
     * @Description: 获取供热供冷能耗与碳排放 HeatConsumption 分页数据
     * @Param: [pn]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:48
     **/
    @ResponseBody
    @RequestMapping(value = "/getHeatConsumption", method = RequestMethod.GET)
    public Msg getHeatConsumption(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10); //分页查询
        List<HeatConsumption> list = heatConsumptionService.getAllOrderById();
        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
    }

    /**
     * @Description: 更新供热供冷能耗与碳排放 HeatConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 3:04
     **/
    @ResponseBody
    @RequestMapping(value = "/updateHeatConsumption", method = RequestMethod.PUT)
    public Msg updateHeatConsumption(@RequestBody Map<String, String> map) {
        int id = Integer.parseInt(map.get("id")); //id
        double r = Double.parseDouble(map.get("r")); //输入，热量/冷量

        CalHeatConsumption calObj = new CalHeatConsumption(r);
        double wHeat = calObj.calWHeat(); //输出，热量/冷量转换能耗
        double tHeat = calObj.calTHeat(); //输出，热量/冷量转换碳排放

        HeatConsumption obj = new HeatConsumption(id,r,wHeat,tHeat,null);
        heatConsumptionService.update(obj);

        return Msg.success().add("message", "更新成功");
    }

    /**
     * @Description: 删除供热供冷能耗与碳排放 HeatConsumption
     * @Param: [id]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 3:09
     **/
    @ResponseBody
    @RequestMapping(value = "/deleteHeatConsumption/{id}", method = RequestMethod.DELETE)
    public Msg deleteHeatConsumption(@PathVariable("id") String id){
        int deleteId = Integer.parseInt(id);
        heatConsumptionService.deleteByPrimaryKey(deleteId);
        return Msg.success().add("message","删除成功");
    }

    /**
     * @Description: 获取供热供冷能耗与碳排放 HeatConsumption 所有数据
     * @Param: []
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/6/4 5:04
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllHeatConsumption",method = RequestMethod.GET)
    public Msg getAllHeatConsumption() {
        List<HeatConsumption> list = heatConsumptionService.getAllOrderByCreatedTime();
        return Msg.success().add("list",list);
    }
}
