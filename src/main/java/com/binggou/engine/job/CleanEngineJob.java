package com.binggou.engine.job;

import com.binggou.engine.business.service.ICleanEngineService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-29 11:35
 */
@Slf4j
@Component
public class CleanEngineJob implements Job,Serializable {

    @Autowired
    private ICleanEngineService cleanEngineService;

    private static final long serialVersionUID = 1L;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        log.info(LocalDateTime.now() + " - helloJob任务执行");
        cleanEngineService.executeCleanEngine();
    }

}
