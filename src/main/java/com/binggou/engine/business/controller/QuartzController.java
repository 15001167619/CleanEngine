package com.binggou.engine.business.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String index(Model model) {
        model.addAttribute("cronExpression",getCronExpression());
        return "index";
    }

    private String  getCronExpression(){
        String cronExpression = "";
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey("trigger_cleanEngineJob", "jobGroup");
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger != null) {
                cronExpression = trigger.getCronExpression();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
            return cronExpression;
        }
        return cronExpression;
    }


    @RequestMapping(value = "executeJob")
    @ResponseBody
    public JSONObject executeJob() {
        JSONObject jsonObject = new JSONObject();
        log.info("重启Job");
        try {
            scheduler.resumeJob(JobKey.jobKey("cleanEngineJob","jobGroup"));
            jsonObject.put("result",true);
            jsonObject.put("cronExpression",getCronExpression());
        } catch (SchedulerException e) {
            e.printStackTrace();
            jsonObject.put("result",false);
            return jsonObject;
        }
        return jsonObject;
    }

    @RequestMapping(value = "pauseJob")
    @ResponseBody
    public Boolean pauseJob() {
        log.info("停止Job");
        try {
            scheduler.pauseJob(JobKey.jobKey("cleanEngineJob","jobGroup"));
        } catch (SchedulerException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping(value = "updateJob")
    @ResponseBody
    public JSONObject updateJob( String cronExpression) {
        JSONObject jsonObject = new JSONObject();
        log.info("修改Job");
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
            jsonObject.put("result",true);
            jsonObject.put("cronExpression",cronExpression);
        } catch (SchedulerException e) {
            e.printStackTrace();
            jsonObject.put("result",false);
            return jsonObject;
        }
        return jsonObject;
    }

}
