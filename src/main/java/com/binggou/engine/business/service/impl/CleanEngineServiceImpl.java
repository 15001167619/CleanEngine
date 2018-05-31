package com.binggou.engine.business.service.impl;

import com.binggou.engine.business.service.ICleanEngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-25 14:01
 */
@Service
@Slf4j
public class CleanEngineServiceImpl implements ICleanEngineService{

    @Override
    public void executeCleanEngine() {
        log.info("执行清洗引擎开始");
    }
}
