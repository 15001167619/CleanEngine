package com.binggou.engine.common.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-26 10:02
 */
@Controller
public class ErrorHandler404 implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value=ERROR_PATH)
    public String handleError404(){
        return "404";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
