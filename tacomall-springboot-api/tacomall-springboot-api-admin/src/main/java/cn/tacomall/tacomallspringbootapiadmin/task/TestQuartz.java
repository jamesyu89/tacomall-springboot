package cn.tacomall.tacomallspringbootapiadmin.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class TestQuartz implements Job {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //获取任务名
        String taskName = context.getJobDetail().getKey().getName();
        //处理执行任务之后的业务
        this.logger.info("开启任务: ========>" + taskName);
    }
}