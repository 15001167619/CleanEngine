package com.binggou.engine.config;

import com.binggou.engine.business.entity.QuartzEntity;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-30 10:06
 */
@Component
@Slf4j
public class TaskRunner  implements ApplicationRunner {

    @Autowired @Qualifier("Scheduler")
    private Scheduler scheduler;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("初始化测试任务");
        QuartzEntity quartz = new QuartzEntity();
        Class cls = Class.forName(quartz.getJobClassName()) ;
        cls.newInstance();
        //构建job信息
        JobDetail job = JobBuilder.newJob(cls).withIdentity(quartz.getJobName(),
                quartz.getJobGroup()).build();
        // 触发时间点
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartz.getCronExpression());
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger_"+quartz.getJobName(), quartz.getJobGroup())
                .startNow().withSchedule(cronScheduleBuilder).build();
        //交由Scheduler安排触发
        scheduler.scheduleJob(job, trigger);
    }
}
