package mapper;

import com.calculation.bean.*;
import com.calculation.dao.*;
import com.factor.bean.GridEmissionFactor;
import com.factor.dao.GridEmissionFactorMapper;
import com.utils.DateParse;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @Description: 测试 Consumption 的 Dao 层
 * @Author: Alex McAvoy
 * @Date: 2022/5/13 21:09
 * @Version: 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConsumptionMapperTest {
    @Autowired
    SqlSession sqlSession;

    @Autowired(required = false)
    GridEmissionFactorMapper gridEmissionFactorMapper;

    @Autowired(required = false)
    ElectricityConsumptionMapper electricityConsumptionMapper;

    @Autowired(required = false)
    GasConsumptionMapper gasConsumptionMapper;

    @Autowired(required = false)
    GasolineConsumptionMapper gasolineConsumptionMapper;

    @Autowired(required = false)
    DieselFuelConsumptionMapper dieselFuelConsumptionMapper;

    @Autowired(required = false)
    SteamConsumptionMapper steamConsumptionMapper;

    @Autowired(required = false)
    HeatConsumptionMapper heatConsumptionMapper;

    /**
     * @Description: 测试表 electricity_consumption
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 16:50
     **/
    @Test
    public void testElectricityConsumptionMapper() {
        //根据主键查询
        ElectricityConsumption obj = electricityConsumptionMapper.selectByPrimaryKey(1);
        System.out.println(obj);

        //根据日期查询
        DateParse dateParse = new DateParse("2022-05-08");
        Date date = dateParse.getCreatedTime();
        obj = electricityConsumptionMapper.selectByCreatedTime(date);
        System.out.println(obj);

        //获取按Id升序的所有数据
        List<ElectricityConsumption> list = electricityConsumptionMapper.getAllOrderById();
        System.out.println(list);

        //获取按日期升序的所有数据
        list = electricityConsumptionMapper.getAllOrderByCreatedTime();
        System.out.println(list);

        //获取日期最小的数据
        ElectricityConsumption min = electricityConsumptionMapper.getMinCreatedTime();
        System.out.println(min);

        //插入
        GridEmissionFactor grid = gridEmissionFactorMapper.selectByPrimaryKey(1);
        ElectricityConsumption newObj = new ElectricityConsumption(2,1000.0,1000.0,1000.0,1000.0,1000.0,0.1229,0.1229,0.1229,0.1229,3000.0,0.36869,grid,2.8257,new Date());
        electricityConsumptionMapper.insert(newObj);

        //删除
        electricityConsumptionMapper.deleteByPrimaryKey(2);

        //更新
        GridEmissionFactor updateGrid = gridEmissionFactorMapper.selectByPrimaryKey(1);
        ElectricityConsumption updateObj = new ElectricityConsumption(1,1000.0,1000.0,1000.0,1000.0,1000.0,0.1229,0.1229,0.1229,0.1229,3000.0,0.36869,updateGrid,2.8257,new Date());
        electricityConsumptionMapper.update(updateObj);
    }

    /**
     * @Description: 测试表 gas_consumption
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 20:56
     **/
    @Test
    public void testGasConsumption() {
        //根据主键查询
        GasConsumption obj = gasConsumptionMapper.selectByPrimaryKey(1);
        System.out.println(obj);

        //根据日期查询
        DateParse dateParse = new DateParse("2022-05-20");
        Date date = dateParse.getCreatedTime();
        obj = gasConsumptionMapper.selectByCreatedTime(date);
        System.out.println(obj);

        //获取按Id升序的所有数据
        List<GasConsumption> list = gasConsumptionMapper.getAllOrderById();
        System.out.println(list);

        //获取按日期升序的所有数据
        list = gasConsumptionMapper.getAllOrderByCreatedTime();
        System.out.println(list);

        //获取日期最小的数据
        GasConsumption min = gasConsumptionMapper.getMinCreatedTime();
        System.out.println(min);

        //插入
        GasConsumption newObj = new GasConsumption(2,16.0,0.02128,0.0345952,new Date());
        gasConsumptionMapper.insert(newObj);

        //删除
        gasConsumptionMapper.deleteByPrimaryKey(2);

        //更新
        GasConsumption updateObj = new GasConsumption(2,20.0,0.02128,0.0345952,new Date());
        gasConsumptionMapper.update(updateObj);
    }

    /**
     * @Description: 测试表 gasoline_consumption
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:10
     **/
    @Test
    public void testGasolineConsumption() {
        //根据主键查询
        GasolineConsumption obj = gasolineConsumptionMapper.selectByPrimaryKey(1);
        System.out.println(obj);

        //根据日期查询
        DateParse dateParse = new DateParse("2022-05-21");
        Date date = dateParse.getCreatedTime();
        obj = gasolineConsumptionMapper.selectByCreatedTime(date);
        System.out.println(obj);

        //获取按Id升序的所有数据
        List<GasolineConsumption> list = gasolineConsumptionMapper.getAllOrderById();
        System.out.println(list);

        //获取按日期升序的所有数据
        list = gasolineConsumptionMapper.getAllOrderByCreatedTime();
        System.out.println(list);

        //获取日期最小的数据
        GasolineConsumption min = gasolineConsumptionMapper.getMinCreatedTime();
        System.out.println(min);

        //插入
        GasolineConsumption newObj = new GasolineConsumption(2,12.0,0.0176568,0.0351012,new Date());
        gasolineConsumptionMapper.insert(newObj);

        //删除
        gasolineConsumptionMapper.deleteByPrimaryKey(2);

        //更新
        GasolineConsumption updateObj = new GasolineConsumption(2,12.0,0.0176568,0.0351012,new Date());
        gasolineConsumptionMapper.update(updateObj);
    }

    /**
     * @Description: 测试表 diesel_fuel_consumption
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 23:58
     **/
    @Test
    public void testDieselFuelConsumption() {
        //根据主键查询
        DieselFuelConsumption obj = dieselFuelConsumptionMapper.selectByPrimaryKey(1);
        System.out.println(obj);

        //根据日期查询
        DateParse dateParse = new DateParse("2022-05-21");
        Date date = dateParse.getCreatedTime();
        obj = dieselFuelConsumptionMapper.selectByCreatedTime(date);
        System.out.println(obj);

        //获取按Id升序的所有数据
        List<DieselFuelConsumption> list = dieselFuelConsumptionMapper.getAllOrderById();
        System.out.println(list);

        //获取按日期升序的所有数据
        list = dieselFuelConsumptionMapper.getAllOrderByCreatedTime();
        System.out.println(list);

        //获取日期最小的数据
        DieselFuelConsumption min = dieselFuelConsumptionMapper.getMinCreatedTime();
        System.out.println(min);

        //插入
        DieselFuelConsumption newObj = new DieselFuelConsumption(2,11.0,0.0160281,0.0340549,new Date());
        dieselFuelConsumptionMapper.insert(newObj);

        //删除
        dieselFuelConsumptionMapper.deleteByPrimaryKey(2);

        //更新
        DieselFuelConsumption updateObj = new DieselFuelConsumption(2,10.0,0.0160281,0.0340549,new Date());
        dieselFuelConsumptionMapper.update(updateObj);
    }

    /**
     * @Description: 测试表 steam_consumption
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:21
     **/
    @Test
    public void testSteamConsumption() {
        //根据主键查询
        SteamConsumption obj = steamConsumptionMapper.selectByPrimaryKey(1);
        System.out.println(obj);

        //根据日期查询
        DateParse dateParse = new DateParse("2022-05-21");
        Date date = dateParse.getCreatedTime();
        obj = steamConsumptionMapper.selectByCreatedTime(date);
        System.out.println(obj);

        //获取按Id升序的所有数据
        List<SteamConsumption> list = steamConsumptionMapper.getAllOrderById();
        System.out.println(list);

        //获取按日期升序的所有数据
        list = steamConsumptionMapper.getAllOrderByCreatedTime();
        System.out.println(list);

        //获取日期最小的数据
        SteamConsumption min = steamConsumptionMapper.getMinCreatedTime();
        System.out.println(min);

        //插入
        SteamConsumption newObj = new SteamConsumption(2,1000.0,0.0347486,2772.5,new Date());
        steamConsumptionMapper.insert(newObj);

        //删除
        steamConsumptionMapper.deleteByPrimaryKey(2);

        //更新
        SteamConsumption updateObj = new SteamConsumption(2,500.0,0.0347486,2772.5,new Date());
        steamConsumptionMapper.update(updateObj);
    }

    /**
     * @Description: 测试表 heat_consumption
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 0:34
     **/
    @Test
    public void testHeatConsumption() {
        //根据主键查询
        HeatConsumption obj = heatConsumptionMapper.selectByPrimaryKey(1);
        System.out.println(obj);

        //根据日期查询
        DateParse dateParse = new DateParse("2022-05-21");
        Date date = dateParse.getCreatedTime();
        obj = heatConsumptionMapper.selectByCreatedTime(date);
        System.out.println(obj);

        //获取按Id升序的所有数据
        List<HeatConsumption> list = heatConsumptionMapper.getAllOrderById();
        System.out.println(list);

        //获取按日期升序的所有数据
        list = heatConsumptionMapper.getAllOrderByCreatedTime();
        System.out.println(list);

        //获取日期最小的数据
        HeatConsumption min = heatConsumptionMapper.getMinCreatedTime();
        System.out.println(min);

        //插入
        HeatConsumption newObj = new HeatConsumption(2,1000.0,0.03412,0.0945977,new Date());
        heatConsumptionMapper.insert(newObj);

        //删除
        heatConsumptionMapper.deleteByPrimaryKey(2);

        //更新
        HeatConsumption updateObj = new HeatConsumption(2,500.0,0.03412,0.0945977,new Date());
        heatConsumptionMapper.update(updateObj);
    }
}