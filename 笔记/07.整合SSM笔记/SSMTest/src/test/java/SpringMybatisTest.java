import com.shiyanlou.model.User;
import com.shiyanlou.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 **/
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SpringMybatisTest {
    @Autowired
    private UserService userService;

/*    @Autowired
    private User user;*/

/*    @Test
    public void testLogin() {
        //User user = new User();
        user.setUsername("shiyanlou");
        user.setPassword("123456");
        System.out.println(userService.login(user).toString());

    }*/

    @Test
    public void testSelectAllUser() {
        List<User> users = userService.selectAllUser();
        for (User us : users) {
            System.out.println(us.toString());
        }
    }

/*    @Test
    public void testAdd() {
        //User user = new User();
        user.setUsername("user2");
        user.setPassword("123456");
        user.setSex("female");
        user.setAge(25);
        userService.addUser(user);
    }

    @Test
    public void testUpdate() {
        //User user = new User();
        user.setId(3);
        user.setUsername("user2");
        user.setPassword("123");
        user.setSex("female");
        user.setAge(30);
        userService.updateUser(user);
    }

    @Test
    public void testUpdate() {
        int id = 3;
        userService.deleteUser(id);
    }*/

}
