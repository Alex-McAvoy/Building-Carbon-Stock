package com.calculation.controller;

import com.calculation.bean.SteamConsumption;
import com.calculation.service.SteamConsumptionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.utils.DateParse;
import com.utils.Msg;
import com.utils.calculation.CalSteamConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: 蒸汽能耗与碳排放 SteamConsumption 控制器
 * @Author: Alex McAvoy
 * @Date: 2022/5/22 2:37
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/steam-consumption")
public class SteamController {
    @Autowired
    SteamConsumptionService steamConsumptionService;

    /**
     * @Description: 保存蒸汽能耗能耗与碳排放 SteamConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:40
     **/
    @ResponseBody
    @RequestMapping(value = "/saveSteamConsumptionForm", method = RequestMethod.POST)
    public Msg saveSteamConsumptionForm(@RequestBody Map<String, String> map) {
        double z = Double.parseDouble(map.get("z")); //输入，蒸汽消耗量，MJ
        Date createdTime = new DateParse(map.get("createdTime")).getCreatedTime(); //输入，创建时间

        SteamConsumption judgeObj = steamConsumptionService.selectByCreatedTime(createdTime);
        if (judgeObj != null) {
            return Msg.fail().add("message", map.get("createdTime") + " 的数据已存在，请确认日期无误");
        } else {
            CalSteamConsumption calObj = new CalSteamConsumption(z);
            double wSteam = calObj.calWSteam(); //输出，蒸汽转换能耗，tce
            double tSteam = calObj.calTSteam(); //输出，蒸汽转换碳排放，tCO2

            SteamConsumption obj = new SteamConsumption(null, z, wSteam, tSteam, createdTime);
            steamConsumptionService.insert(obj);

            return Msg.success().add("message", "提交成功");
        }
    }


    /**
     * @Description: 获取蒸汽能耗与碳排放 SteamConsumption 分页数据
     * @Param: [pn]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:48
     **/
    @ResponseBody
    @RequestMapping(value = "/getSteamConsumption", method = RequestMethod.GET)
    public Msg getSteamConsumption(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10); //分页查询
        List<SteamConsumption> list = steamConsumptionService.getAll();
        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
    }

    /**
     * @Description: 更新蒸汽能耗与碳排放 SteamConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 3:04
     **/
    @ResponseBody
    @RequestMapping(value = "/updateSteamConsumption", method = RequestMethod.PUT)
    public Msg updateSteamConsumption(@RequestBody Map<String, String> map) {
        int id = Integer.parseInt(map.get("id")); //id
        double z = Double.parseDouble(map.get("z")); //输入，蒸汽消耗量

        CalSteamConsumption calObj = new CalSteamConsumption(z);
        double wSteam = calObj.calWSteam(); //输出，蒸汽转换能耗
        double tSteam = calObj.calTSteam(); //输出，转换碳排放

        SteamConsumption obj = new SteamConsumption(id,z,wSteam,tSteam,null);
        steamConsumptionService.update(obj);

        return Msg.success().add("message", "更新成功");
    }

    /**
     * @Description: 删除蒸汽能耗与碳排放 SteamConsumption
     * @Param: [id]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 3:09
     **/
    @ResponseBody
    @RequestMapping(value = "/deleteSteamConsumption/{id}", method = RequestMethod.DELETE)
    public Msg deleteSteamConsumption(@PathVariable("id") String id){
        int deleteId = Integer.parseInt(id);
        steamConsumptionService.deleteByPrimaryKey(deleteId);
        return Msg.success().add("message","删除成功");
    }

    /**
     * @Description: 获取蒸汽能耗与碳排放 SteamConsumption 所有数据
     * @Param: []
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/6/4 5:06
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllSteamConsumption",method = RequestMethod.GET)
    public Msg getAllSteamConsumption() {
        List<SteamConsumption> list = steamConsumptionService.getAll();
        return Msg.success().add("list",list);
    }
}
