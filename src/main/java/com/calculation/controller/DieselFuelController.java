package com.calculation.controller;

import com.calculation.bean.DieselFuelConsumption;
import com.calculation.service.DieselFuelConsumptionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.utils.DateParse;
import com.utils.Msg;
import com.utils.calculation.CalDieselFuelConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: 柴油能耗与碳排放 DieselFuelConsumption 控制器
 * @Author: Alex McAvoy
 * @Date: 2022/5/22 2:36
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/dieselFuel-consumption")
public class DieselFuelController {
    @Autowired
    DieselFuelConsumptionService dieselFuelConsumptionService;

    /**
     * @Description: 保存柴油能耗与碳排放 DieselFuelConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:20
     **/
    @ResponseBody
    @RequestMapping(value = "/saveDieselFuelConsumptionForm", method = RequestMethod.POST)
    public Msg saveDieselFuelConsumptionForm(@RequestBody Map<String, String> map) {
        double yDiesel = Double.parseDouble(map.get("yDiesel")); //输入，柴油消耗量，kg
        Date createdTime = new DateParse(map.get("createdTime")).getCreatedTime(); //输入，创建时间

        DieselFuelConsumption judgeObj = dieselFuelConsumptionService.selectByCreatedTime(createdTime);
        if (judgeObj != null) {
            return Msg.fail().add("message", map.get("createdTime") + " 的数据已存在，请确认日期无误");
        } else {
            CalDieselFuelConsumption calObj = new CalDieselFuelConsumption(yDiesel);
            double wDiesel = calObj.calWDiesel(); //输出，柴油转换能耗，tce
            double tDiesel = calObj.calTDiesel(); //输出，柴油转换碳排放，tCO2

            DieselFuelConsumption obj = new DieselFuelConsumption(null, yDiesel, wDiesel, tDiesel, createdTime);
            dieselFuelConsumptionService.insert(obj);
            return Msg.success().add("message", "提交成功");
        }
    }

    /**
     * @Description: 获取柴油能耗与碳排放 DieselFuelConsumption 分页数据
     * @Param: [pn]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:47
     **/
    @ResponseBody
    @RequestMapping(value = "/getDieselFuelConsumption", method = RequestMethod.GET)
    public Msg getDieselFuelConsumption(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10); //分页查询
        List<DieselFuelConsumption> list = dieselFuelConsumptionService.getAllOrderById();
        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
    }

    /**
     * @Description: 更新柴油能耗与碳排放 DieselFuelConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 3:05
     **/
    @ResponseBody
    @RequestMapping(value = "/updateDieselFuelConsumption", method = RequestMethod.PUT)
    public Msg updateDieselFuelConsumption(@RequestBody Map<String, String> map) {
        int id = Integer.parseInt(map.get("id")); //id
        double yDiesel = Double.parseDouble(map.get("yDiesel")); //输入，柴油消耗量

        CalDieselFuelConsumption calObj = new CalDieselFuelConsumption(yDiesel);
        double wDiesel = calObj.calWDiesel(); //输出，柴油转换能耗
        double tDiesel = calObj.calTDiesel(); //输出，柴油转换碳排放

        DieselFuelConsumption obj = new DieselFuelConsumption(id,yDiesel,wDiesel,tDiesel,null);
        dieselFuelConsumptionService.update(obj);

        return Msg.success().add("message", "更新成功");
    }

    /**
     * @Description: 删除柴油能耗与碳排放 DieselFuelConsumption
     * @Param: [id]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 3:10
     **/
    @ResponseBody
    @RequestMapping(value = "/deleteDieselFuelConsumption/{id}", method = RequestMethod.DELETE)
    public Msg deleteDieselFuelConsumption(@PathVariable("id") String id){
        int deleteId = Integer.parseInt(id);
        dieselFuelConsumptionService.deleteByPrimaryKey(deleteId);
        return Msg.success().add("message","删除成功");
    }

    /**
     * @Description: 获取柴油能耗与碳排放 DieselFuelConsumption 所有数据
     * @Param: []
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/6/4 4:51
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllDieselFuelConsumption",method = RequestMethod.GET)
    public Msg getAllDieselFuelConsumption() {
        List<DieselFuelConsumption> list = dieselFuelConsumptionService.getAllOrderByCreatedTime();
        return Msg.success().add("list",list);
    }
}
