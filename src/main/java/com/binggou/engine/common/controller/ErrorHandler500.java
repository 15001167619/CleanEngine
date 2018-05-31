package com.binggou.engine.common.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-26 10:02
 */
@Component
public class ErrorHandler500 implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Nullable Object o, Exception e) {
        return new ModelAndView("error/error-500");
    }
}
