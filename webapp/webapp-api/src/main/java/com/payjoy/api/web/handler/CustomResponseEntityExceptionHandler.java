package com.payjoy.api.web.handler;

import cn.com.allunion.common.RestResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import java.util.Set;

/**
 * 内部异常处理handler
 * Created by YangJie on 2016/4/20.
 */
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${JSONP_CALLBACK}")
    String jsonCallback ;

    /**
     * 处理接口不支持访问方式，抛出的异常
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.warn(ex.getMessage());
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8");
        Set<HttpMethod> supportedMethods = ex.getSupportedHttpMethods();
        StringBuilder supportMethodsBuilder = new StringBuilder() ;
        if (!supportedMethods.isEmpty()) {
            headers.setAllow(supportedMethods);
            supportMethodsBuilder.append(supportedMethods) ;
        }

        String callback = (String) request.getAttribute(jsonCallback, WebRequest.SCOPE_REQUEST);

        Object result = RestResponse.build(status.value(), "该接口只支持" + supportMethodsBuilder.toString()+"方式访问");

        return new ResponseEntity<Object>(result, headers, status);
    }

    /**
     * 处理访问接口，由于没有携带指定的参数，抛出的异常
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.warn(ex.getMessage());
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8");
        String callback = (String) request.getAttribute(jsonCallback, WebRequest.SCOPE_REQUEST);
        Object result = RestResponse.build(status.value(), "参数错误");
        return new ResponseEntity<Object>(result, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleNoSuchRequestHandlingMethod(NoSuchRequestHandlingMethodException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        pageNotFoundLogger.warn(ex.getMessage());
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8");

        String callback = (String) request.getAttribute(jsonCallback, WebRequest.SCOPE_REQUEST);

        Object result = RestResponse.build(status.value(), "访问资源无效");

        return new ResponseEntity<Object>(result, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        pageNotFoundLogger.warn(ex.getMessage());
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE +";charset=UTF-8");

        String callback = (String) request.getAttribute(jsonCallback, WebRequest.SCOPE_REQUEST);

        Object result = RestResponse.build(status.value(), "访问资源无效");

        return new ResponseEntity<Object>(result, headers, status);
    }
}
