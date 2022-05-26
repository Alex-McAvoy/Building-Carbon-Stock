import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * @Description: 测试 MVC
 * @Author: Alex McAvoy
 * @Date: 2022/5/13 22:42
 * @Version: 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:dispatcherServlet.xml"})
public class MVCTest {
    @Autowired
    WebApplicationContext webApplicationContext; //SpringMVC的IOC

    MockMvc mockMvc; //虚拟MVC，获取处理结果

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testLogin() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.
                get("/login").
                param("username", "admin").
                param("password","123456")).
                andReturn(); //模拟请求拿到返回值

        MockHttpServletRequest request = mvcResult.getRequest();
//        User user =(User) request.getAttribute("user");
//        System.out.println(user);
    }

}
