package cn.tacomall.tacomallspringbootapiportal;

import java.util.List;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tacomall.tacomallspringbootentity.user.User;
import cn.tacomall.tacomallspringbootmapper.user.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
