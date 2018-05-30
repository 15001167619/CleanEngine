package com.binggou.engine.business.controller;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-30 10:20
 */
@Slf4j
@RestController
public class QuartzController {

    @Autowired
    @Qualifier("Scheduler")
    private Scheduler scheduler;

    @RequestMapping(value = "list")
    public String userListForm(Model model) {
        return "modules/userList";
    }

    @RequestMapping(value = "executeJob")
    public String executeJob() {
        log.info("重启Job");
        try {
            scheduler.resumeJob(JobKey.jobKey("cleanEngineJob","jobGroup"));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "executeJob";
    }

    @RequestMapping(value = "pauseJob")
    public String pauseJob() {
        log.info("停止Job");
        try {
            scheduler.pauseJob(JobKey.jobKey("cleanEngineJob","jobGroup"));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "pauseJob";
    }

    @RequestMapping(value = "updateJob")
    public String updateJob() {
        log.info("修改Job运行时间");
        String cronExpression = "0/5 * * * * ?";
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey("trigger_cleanEngineJob", "jobGroup");
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return null;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cronExpression)) {
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity("trigger_cleanEngineJob", "jobGroup");
                triggerBuilder.startNow();
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
                // 创建Trigger对象
                trigger = (CronTrigger) triggerBuilder.build();
                // 方式一 ：修改一个任务的触发时间
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "updateJob";
    }

}
