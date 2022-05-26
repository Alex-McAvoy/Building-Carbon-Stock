import com.calculation.bean.ElectricityConsumption;
import com.utils.DateParse;
import com.utils.calculation.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Description: 工具测试
 * @Author: Alex McAvoy
 * @Date: 2022/5/20 22:59
 * @Version: 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class utilsTest {

    /**
     * @Description: 日期解析测试
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/20 22:59
     **/
    @Test
    public void testDateParse() {
        DateParse dateParse = new DateParse("2022-05-20");
        System.out.println(dateParse.getCreatedTime());
    }

    /**
     * @Description: 测试工具类 CalElectricityConsumption 能否正常调用 service 接口
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 1:26
     **/
    @Test
    public void testCalElectricityConsumption() {
        CalElectricityConsumption calObj = new CalElectricityConsumption(1000, 1000, 1000, 1000, 1000, 1);
        System.out.println(calObj.calTGrid());
    }

    /**
     * @Description: 测试工具类 CalGasConsumption 能否正常调用 service 接口
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 1:26
     **/
    @Test
    public void testCalGasConsumption() {
        CalGasConsumption calObj = new CalGasConsumption(16);
        System.out.println(calObj.calTGas());
    }

    /**
     * @Description: 测试工具类 CalGasolineConsumption 能否正常调用 service 接口
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:07
     **/
    @Test
    public void testCalGasolineConsumption(){
        CalGasolineConsumption calObj = new CalGasolineConsumption(12);
        System.out.println(calObj.calTGasoline());
    }

    /**
     * @Description: 测试工具类 CalDieselFuelConsumption 能否正常调用 service 接口
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:26
     **/
    @Test
    public void testCalDieselFuelConsumption(){
        CalDieselFuelConsumption calObj = new CalDieselFuelConsumption(11);
        System.out.println(calObj.calTDiesel());
    }

    /**
     * @Description: 测试工具类 CalSteamConsumption 能否正常调用 service 接口
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:52
     **/
    @Test
    public void testCalSteamConsumption(){
        CalSteamConsumption calObj = new CalSteamConsumption(1000);
        System.out.println(calObj.calTSteam());
    }

    /**
     * @Description: 测试工具类 CalHeatConsumption 能否正常调用 service 接口
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/21 2:53
     **/
    @Test
    public void testCalHeatConsumption(){
        CalHeatConsumption calObj = new CalHeatConsumption(1000);
        System.out.println(calObj.calTHeat());
    }
}
