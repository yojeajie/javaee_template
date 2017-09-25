package com.payjoy.api.web.controller;

import cn.com.allunion.common.AbstractDataForm;
import com.payjoy.api.web.bean.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用户 前端控制器
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2017/3/8.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
@RestController
@RequestMapping(value = "/testuser", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class TestUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestUserController.class) ;

    /**
     * 新增用户
     * @param dataForm 数据接收form
     */
    @RequestMapping("/add")
    public Response add(AbstractDataForm dataForm) {
        // TODO 待实现
        return Response.ok();
    }
}
