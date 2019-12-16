package cn.tacomall.tacomallspringbootapistore;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tacomall.tacomallspringboottask.quartz.QuartzJobManager;
import cn.tacomall.tacomallspringbootapistore.task.TestQuartz;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuartzTest {
    @Resource
    private QuartzJobManager quartzJobManager;

    @Test
    public void testAdd() {
        //任务名称
        String name = "test";
        //任务组名称
        String groupName = "task";
        //cron表达式
        String cron = "0 0/1 * * * ?";
        //需要给任务携带的参数
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("sex", "0");
        quartzJobManager.addJob(TestQuartz.class, name, groupName, cron, map);
    }

    @Test
    public void testDelete() {
        String name = "test";
        String groupName = "task";
        quartzJobManager.deleteJob(name, groupName);
    }
}
