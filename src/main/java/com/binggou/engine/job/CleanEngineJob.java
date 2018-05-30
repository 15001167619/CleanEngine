package com.binggou.engine.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-29 11:35
 */
public class CleanEngineJob implements Job,Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("现在是北京时间:" + LocalDateTime.now() + " - helloJob任务执行");
        System.out.println("大吉大利、" +
                "卓秀北街6号院7号楼" +
                "今晚吃鸡");
    }

}
