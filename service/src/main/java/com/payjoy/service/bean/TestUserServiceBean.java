package com.payjoy.service.bean;

import com.payjoy.dao.DAOSupport;
import com.payjoy.entity.TestUser;
import com.payjoy.service.TestUserService;
import org.springframework.stereotype.Service;

/**
 * 测试用户 业务逻辑接口 实现类
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2017/3/8.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
@Service
public class TestUserServiceBean extends DAOSupport<TestUser> implements TestUserService {
}
