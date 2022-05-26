package com.calculation.controller;

import com.calculation.bean.ElectricityConsumption;
import com.calculation.service.ElectricityConsumptionService;
import com.factor.bean.GridEmissionFactor;
import com.factor.service.GridEmissionFactorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.utils.DateParse;
import com.utils.Msg;
import com.utils.calculation.CalElectricityConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 楼宇电力能耗与碳排放 ElectricityConsumption 控制器
 * @Author: Alex McAvoy
 * @Date: 2022/5/21 19:09
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/electricity-consumption")
public class ElectricityConsumptionController {
    @Autowired
    ElectricityConsumptionService electricityConsumptionService;

    @Autowired
    GridEmissionFactorService gridEmissionFactorService;

    /**
     * @Description: 保存电力能耗与碳排放 ElectricityConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 0:33
     **/
    @ResponseBody
    @RequestMapping(value = "/saveElectricityConsumption", method = RequestMethod.POST)
    public Msg saveElectricityConsumption(@RequestBody Map<String, String> map) {
        double dN = Double.parseDouble(map.get("dN")); //输入，暖通空调系统的用电量
        double dR = Double.parseDouble(map.get("dR")); //输入，生活热水系统的用电量
        double dW = Double.parseDouble(map.get("dW")); //输入，照明系统用电量
        double dE = Double.parseDouble(map.get("dE")); //输入，其他用能设备用电量
        double e = Double.parseDouble(map.get("e")); //输入，光伏发电量
        Date createdTime = new DateParse(map.get("createdTime")).getCreatedTime(); //输入，创建时间
        Integer areaId = Integer.parseInt(map.get("areaId")); //输入，区域id

        ElectricityConsumption judgeObj = electricityConsumptionService.selectByCreatedTime(createdTime);
        if (judgeObj != null) {
            return Msg.fail().add("message", map.get("createdTime") + " 的数据已存在，请确认日期无误");
        } else {
            CalElectricityConsumption calObj = new CalElectricityConsumption(dN, dR, dW, dE, e, areaId);
            Double wN = calObj.calWN(); //输出，暖通空调能耗
            Double wR = calObj.calWR(); //输出，生活热水能耗
            Double wW = calObj.calWW(); //输出，照明能耗
            Double wE = calObj.calWE(); //输出，其他用能设备能耗
            Double d = calObj.calD(); //输出，总用电量
            Double wElectricity = calObj.calWElectricity(); //输出，电力转换能耗，tce
            GridEmissionFactor gridEmissionFactor = gridEmissionFactorService.selectByPrimaryKey(areaId); //外键，区域排放因子
            Double tGrid = calObj.calTGrid(); //输出，区域电力转换碳排放，tCO2

            ElectricityConsumption obj = new ElectricityConsumption(null, dN, dR, dW, dE, e, wN, wR, wW, wE, d, wElectricity, gridEmissionFactor, tGrid, createdTime);
            electricityConsumptionService.insert(obj);

            return Msg.success().add("message", "提交成功");
        }
    }

    /**
     * @Description: 获取电力能耗与碳排放 ElectricityConsumption 分页数据
     * @Param: [pn]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 23:40
     **/
    @ResponseBody
    @RequestMapping(value = "/getElectricityConsumption", method = RequestMethod.GET)
    public Msg getElectricityConsumption(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10); //分页查询
        List<ElectricityConsumption> list = electricityConsumptionService.getAll();
        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
    }

    /**
     * @Description: 更新电力能耗与碳排放 ElectricityConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 23:40
     **/
    @ResponseBody
    @RequestMapping(value = "/updateElectricityConsumption", method = RequestMethod.PUT)
    public Msg updateElectricityConsumption(@RequestBody Map<String, String> map) {
        int id = Integer.parseInt(map.get("id")); //id
        double dN = Double.parseDouble(map.get("dN")); //输入，暖通空调系统的用电量
        double dR = Double.parseDouble(map.get("dR")); //输入，生活热水系统的用电量
        double dW = Double.parseDouble(map.get("dW")); //输入，照明系统用电量
        double dE = Double.parseDouble(map.get("dE")); //输入，其他用能设备用电量
        double e = Double.parseDouble(map.get("e")); //输入，光伏发电量
        Integer areaId = Integer.parseInt(map.get("areaId")); //输入，区域id

        CalElectricityConsumption calObj = new CalElectricityConsumption(dN, dR, dW, dE, e, areaId);
        Double wN = calObj.calWN(); //输出，暖通空调能耗
        Double wR = calObj.calWR(); //输出，生活热水能耗
        Double wW = calObj.calWW(); //输出，照明能耗
        Double wE = calObj.calWE(); //输出，其他用能设备能耗
        Double d = calObj.calD(); //输出，总用电量
        Double wElectricity = calObj.calWElectricity(); //输出，电力转换能耗，tce
        GridEmissionFactor gridEmissionFactor = gridEmissionFactorService.selectByPrimaryKey(areaId); //外键，区域排放因子
        Double tGrid = calObj.calTGrid(); //输出，区域电力转换碳排放，tCO2

        ElectricityConsumption obj = new ElectricityConsumption(id, dN, dR, dW, dE, e, wN, wR, wW, wE, d, wElectricity, gridEmissionFactor, tGrid, null);
        electricityConsumptionService.update(obj);

        return Msg.success().add("message", "更新成功");
    }

    /**
     * @Description: 删除电力能耗与碳排放 ElectricityConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 0:49
     **/
    @ResponseBody
    @RequestMapping(value = "/deleteElectricityConsumption/{id}", method = RequestMethod.DELETE)
    public Msg deleteElectricityConsumption(@PathVariable("id") String id) {
        int deleteId = Integer.parseInt(id);
        electricityConsumptionService.deleteByPrimaryKey(deleteId);
        return Msg.success().add("message", "删除成功");
    }

    @ResponseBody
    @RequestMapping(value = "getElectricityAnalysis", method = RequestMethod.GET)
    public Msg getElectricityAnalysis() {
        List<ElectricityConsumption> list = electricityConsumptionService.getAll();

        double wNSum = 0; //暖通空调总能耗
        double wRSum = 0; //生活热水总能耗
        double wWSum = 0; //照明总能耗
        double wESum = 0; //其他用能设备总能耗
        double wSum = 0; //总能耗
        for (int i = 0; i < list.size(); i++) {
            ElectricityConsumption obj = list.get(i);
            wNSum += obj.getWN(); //暖通空调能耗
            wRSum += obj.getWN(); //生活热水能耗
            wWSum += obj.getWN(); //照明能耗
            wESum += obj.getWN(); //其他用能设备能耗
        }
        wSum = wNSum + wRSum + wWSum + wESum;

        double wNProportion = wNSum/wSum; //暖通空调能耗比例
        double wRProportion = wRSum/wSum; //暖通空调能耗比例
        double wWProportion = wWSum/wSum; //暖通空调能耗比例
        double wEProportion = wESum/wSum; //暖通空调能耗比例

        Map<String,Double> map = new HashMap<>();
        map.put("wNProportion",wNProportion);
        map.put("wRProportion",wRProportion);
        map.put("wWProportion",wWProportion);
        map.put("wEProportion",wEProportion);

        return Msg.success().add("proportion",map);
    }
}
