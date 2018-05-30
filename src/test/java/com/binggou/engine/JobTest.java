package com.binggou.engine;

import com.binggou.engine.business.entity.QuartzEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-25 14:01
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JobTest {

    @Autowired @Qualifier("Scheduler")
    private Scheduler scheduler;

    @Test
    public void insertTest() throws Exception {

        log.info("初始化测试任务");
        QuartzEntity quartz = new QuartzEntity();
        quartz.setJobName("test01");
        quartz.setJobGroup("test");
        quartz.setDescription("测试任务");
        quartz.setJobClassName("com.binggou.engine.job.CleanEngineJob");
        quartz.setCronExpression("0/20 * * * * ?");
        Class cls = Class.forName(quartz.getJobClassName()) ;
        cls.newInstance();
        //构建job信息
        JobDetail job = JobBuilder.newJob(cls).withIdentity(quartz.getJobName(),
                quartz.getJobGroup())
                .withDescription(quartz.getDescription()).build();
        // 触发时间点
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartz.getCronExpression());
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+quartz.getJobName(), quartz.getJobGroup())
                .startNow().withSchedule(cronScheduleBuilder).build();
        //交由Scheduler安排触发
        scheduler.scheduleJob(job, trigger);

    }

}
