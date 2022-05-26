package mapper;

import com.user.bean.User;
import com.user.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


/**
 * @Description: 测试 User 的 Dao 层
 * @Author: Alex McAvoy
 * @Date: 2022/5/13 21:09
 * @Version: 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserMapperTest {
    @Autowired
    SqlSession sqlSession;

    @Autowired(required = false)
    UserMapper userMapper;


    /**
     * @Description: 测试 users 表
     * @Param: []
     * @Return: void
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 20:10
     **/
    @Test
    public void testUsersSelect() {
        User user = userMapper.getUserByUsername("root");
        System.out.println(user);
    }

}
