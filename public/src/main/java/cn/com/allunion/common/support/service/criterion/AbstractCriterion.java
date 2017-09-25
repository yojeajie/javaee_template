package cn.com.allunion.common.support.service.criterion;

import cn.com.allunion.common.ReflectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象条件实现定义
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/10.
 * @copyright http://www.all-union.com.cn/
 */
public abstract class AbstractCriterion<T> implements Criteria.Criterion<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCriterion.class) ;

    protected static void invokeAdaptMethod(Object object, String methodName, Object[] args) {
        Class<?>[] parameterTypes = null ;
        if (ArrayUtils.isNotEmpty(args)) {
            parameterTypes = new Class<?>[args.length];
            for (int i=0; i < parameterTypes.length; ++i) {
                parameterTypes[i] = args[i].getClass();
            }
        }

        invokeAdaptMethod(object, methodName, parameterTypes, args);
    }

    protected static void invokeAdaptMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] args) {
        if (null == object || StringUtils.isEmpty(methodName)) {
            return ;
        }

        try {
            ReflectionUtils.invokeMethod(object, methodName, parameterTypes, args) ;
        } catch (Exception e) {
            LOGGER.error("调用适配方法出现错误， methodName: {}", methodName, e);
        }
    }
}
