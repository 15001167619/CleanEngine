package com.binggou.engine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-05-25 13:45
 */
@SpringBootApplication
@Slf4j
public class CleanEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanEngineApplication.class, args);
        log.info("CleanEngineApplication start-up is success!");
    }

}
