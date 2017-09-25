package com.payjoy.api.web.handler;

import cn.com.allunion.common.RestResponse;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 * Created by YangJie on 2016/4/19.
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyHandlerExceptionResolver.class) ;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        LOGGER.warn(ex.getMessage(), ex);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMsg", JSON.toJSON(RestResponse.build(-1, "发生错误: " + ex.getMessage())));

        return modelAndView;
    }
}
