package cn.com.allunion.common.handler;

/**
 * 处理器接口类
 * @param <P> 处理方法参数类型
 * @param <R> 处理方法返回参数类型
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/12.
 * @copyright http://www.all-union.com.cn/
 */
public interface Handler<P, R> {
    /**
     * 处理方法
     * @param p 传递参数
     * @return 执行返回结果
     */
    R handle(P p) ;
}
