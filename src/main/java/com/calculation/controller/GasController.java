package com.calculation.controller;

import com.calculation.bean.GasConsumption;
import com.calculation.service.GasConsumptionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.utils.DateParse;
import com.utils.Msg;
import com.utils.calculation.CalGasConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: 天然气能耗与碳排放 GasConsumption 控制器
 * @Author: Alex McAvoy
 * @Date: 2022/5/22 2:36
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/gas-consumption")
public class GasController {
    @Autowired
    GasConsumptionService gasConsumptionService;

    /**
     * @Description: 保存天然气能耗与碳排放 GasConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 1:53
     **/
    @ResponseBody
    @RequestMapping(value = "/saveGasConsumption", method = RequestMethod.POST)
    public Msg saveGasConsumption(@RequestBody Map<String, String> map) {
        double q = Double.parseDouble(map.get("q")); //输入，天然气消耗量，m3
        Date createdTime = new DateParse(map.get("createdTime")).getCreatedTime(); //输入，创建时间

        GasConsumption judgeObj = gasConsumptionService.selectByCreatedTime(createdTime);
        if (judgeObj != null) {
            return Msg.fail().add("message", map.get("createdTime") + " 的数据已存在，请确认日期无误");
        } else {
            CalGasConsumption calObj = new CalGasConsumption(q);
            double wGas = calObj.calWGas(); //输出，天然气转换能耗，tce
            double tGas = calObj.calTGas(); //输出，天然气转换碳排放，tCO2

            GasConsumption obj = new GasConsumption(null, q, wGas, tGas, createdTime);
            gasConsumptionService.insert(obj);

            return Msg.success().add("message", "提交成功");
        }
    }

    /**
     * @Description: 获取天然气能耗与碳排放 GasConsumption 分页数据
     * @Param: [pn]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 2:47
     **/
    @ResponseBody
    @RequestMapping(value = "/getGasConsumption", method = RequestMethod.GET)
    public Msg getGasConsumption(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10); //分页查询
        List<GasConsumption> list = gasConsumptionService.getAllOrderById();
        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
    }

    /**
     * @Description: 更新天然气能耗与碳排放 GasConsumption
     * @Param: [map]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 3:05
     **/
    @ResponseBody
    @RequestMapping(value = "/updateGasConsumption", method = RequestMethod.PUT)
    public Msg updateGasConsumption(@RequestBody Map<String, String> map) {
        int id = Integer.parseInt(map.get("id")); //id
        double q = Double.parseDouble(map.get("q")); //输入，天然气消耗量

        CalGasConsumption calObj = new CalGasConsumption(q);
        double wGas = calObj.calWGas(); //输出，天然气转换能耗
        double tGas = calObj.calTGas(); //输出，天然气转换碳排放

        GasConsumption obj = new GasConsumption(id,q,wGas,tGas,null);
        gasConsumptionService.update(obj);

        return Msg.success().add("message", "更新成功");
    }

    /**
     * @Description: 删除天然气能耗与碳排放 GasConsumption
     * @Param: [id]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/22 3:09
     **/
    @ResponseBody
    @RequestMapping(value = "/deleteGasConsumption/{id}", method = RequestMethod.DELETE)
    public Msg deleteGasConsumption(@PathVariable("id") String id){
        int deleteId = Integer.parseInt(id);
        gasConsumptionService.deleteByPrimaryKey(deleteId);
        return Msg.success().add("message","删除成功");
    }

    /**
     * @Description: 获取天然气能耗与碳排放 GasConsumption 所有数据
     * @Param: []
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/25 17:09
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllGasConsumption",method = RequestMethod.GET)
    public Msg getAllGasConsumption() {
        List<GasConsumption> list = gasConsumptionService.getAllOrderByCreatedTime();
        return Msg.success().add("list",list);
    }
}
