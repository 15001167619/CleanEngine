package com.binggou.engine.business.controller;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-30 10:20
 */
@Slf4j
@Controller
public class QuartzController {

    @Autowired
    @Qualifier("Scheduler")
    private Scheduler scheduler;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return "index";
    }

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
        log.info("修改Job");
        String cronExpression = "0/5 * * * * ?";
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey("trigger_cleanEngineJob", "jobGroup");
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return null;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cronExpression)) {
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                triggerBuilder.withIdentity("trigger_cleanEngineJob", "jobGroup");
                triggerBuilder.startNow();
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression));
                trigger = (CronTrigger) triggerBuilder.build();
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "updateJob";
    }

}
