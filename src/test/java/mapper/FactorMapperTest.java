package mapper;

import com.calculation.bean.*;
import com.calculation.dao.*;
import com.factor.bean.CarbonEmissionFactor;
import com.factor.bean.EnergyCoalFactor;
import com.factor.bean.GridEmissionFactor;
import com.user.bean.User;
import com.factor.dao.CarbonEmissionFactorMapper;
import com.factor.dao.EnergyCoalFactorMapper;
import com.factor.dao.GridEmissionFactorMapper;
import com.user.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description: 测试 Factor 的 Dao 层
 * @Author: Alex McAvoy
 * @Date: 2022/5/13 21:09
 * @Version: 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class FactorMapperTest {
    @Autowired
    SqlSession sqlSession;

    @Autowired(required = false)
    CarbonEmissionFactorMapper carbonEmissionFactorMapper;

    @Autowired(required = false)
    EnergyCoalFactorMapper energyCoalFactorMapper;

    @Autowired(required = false)
    GridEmissionFactorMapper gridEmissionFactorMapper;


    /**
     * @Description: 测试 carbon_emission_factor 表
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 20:10
     **/
    @Test
    public void testCarbonEmissionFactorSelect() {
        //根据主键查询
        CarbonEmissionFactor obj = carbonEmissionFactorMapper.selectByPrimaryKey(1);
        System.out.println(obj);

        //获取所有数据
        List<CarbonEmissionFactor> list = carbonEmissionFactorMapper.getAll();
        System.out.println(list);

        //更新
        CarbonEmissionFactor updateObj = new CarbonEmissionFactor(1,null,1.0,1.0,1.0);
        carbonEmissionFactorMapper.update(updateObj);
    }

    /**
     * @Description: 测试 energy_coal_factor 表
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 20:16
     **/
    @Test
    public void testEnergyCoalFactorSelect() {
        //根据主键查询
        EnergyCoalFactor obj = energyCoalFactorMapper.selectByPrimaryKey(5);
        System.out.println(obj);

        //获取所有数据
        List<EnergyCoalFactor> list = energyCoalFactorMapper.getAll();
        System.out.println(list);

        //更新
        EnergyCoalFactor updateObj = new EnergyCoalFactor(1,null,1,1.0);
        energyCoalFactorMapper.update(updateObj);
    }

    /**
     * @Description: 测试 grid_emission_factor 表
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 20:17
     **/
    @Test
    public void testGridEmissionFactorSelect() {
        //根据主键查询
        GridEmissionFactor obj = gridEmissionFactorMapper.selectByPrimaryKey(1);
        System.out.println(obj);

        //获取所有数据
        List<GridEmissionFactor> list = gridEmissionFactorMapper.getAll();
        System.out.println(list);

        //更新
        GridEmissionFactor updateObj = new GridEmissionFactor(1,null,1.0,1.0);
        gridEmissionFactorMapper.update(updateObj);
    }
}
