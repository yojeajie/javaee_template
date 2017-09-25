package cn.com.allunion.common.support.service;

import cn.com.allunion.common.page.QueryResult;
import cn.com.allunion.common.support.service.criterion.Criteria;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 通用Service接口定义
 * @param <T> 实体类
 * @param <K> 实体类主键类型
 * @author yang.jie
 * @email yang.jie@all-union.com.cn
 * @date 2016/5/6.
 * @copyright <url>http://www.all-union.com.cn/</url>
 */
public interface IService<T, K> {
    /**
     * 全属性保存实体类对象到数据库，如果有为null的属性，同样会保存
     * @param entity 实体类对象
     * @return 保存成功的记录数量
     */
    Integer save(T entity) ;

    /**
     * 实体类对象到数据库，属性按需保存，如果有为null的属性，不会保存
     * @param entity 实体类对象
     * @return 保存成功的记录数量
     */
    Integer saveNeeds(T entity) ;

    /**
     * 根据的实体对象id，删除对应的实体类对象
     * @param entityIds 将要删除的实体类对象id集
     * @return  删除成功的记录数量
     */
    Integer delete(K... entityIds);

    /**
     * 全属性更新实体类对象数据到数据库
     * @param entity 将要更新的实体类对象
     * @return 更新成功的记录数量
     */
    Integer update(T entity) ;

    /**
     * 根据实体类 id，按需更新实体属性，既更新对象不为null的属性，实体类的id必须提供
     * @param entity 将要按需更新的实体类对象
     * @return 更新成功的记录数量
     */
    Integer updateNeeds(T entity) ;

    /**
     * 根据指定的条件进行更新实体对象，更新的属性为 entity 中不为null的字段
     * @param entity 将要按需更新的实体类对象属性
     * @param criteria 条件
     * @return 更新成功的记录数量
     */
    Integer updateNeedsByCriteria(T entity, Criteria criteria) ;

    /**
     * 根据指定的条件进行更新实体对象，更新的属性为 entity 中不为null的字段
     * @param entity 将要按需更新的实体类对象属性，即不为null的属性
     * @param orCriteriaList 集合参数之间 是 or 的关系
     * @return 更新成功的记录数量
     */
    Integer updateNeedsByCriteria(T entity, List<Criteria> orCriteriaList) ;

    /**
     * 根据实体类id查询实体对象
     * @param entityId 实体类id
     * @return 查询到的实体对象，可能返回null
     */
    T get(K entityId) ;

    /**
     * 根据参数实体属性中非空字段的 and 条件进行查询
     *      例如：如果实体对象中属性name和passwd不为空，那么会根据 name = ? and passwd = ? 来进行查询
     * @param param 参数实体对象
     * @return 查询到的实体对象
     */
    T getByParam(T param) ;

    /**
     * 根据指定的条件进行查询对象
     * @param orCriteriaList 集合参数之间 是 or 的关系
     * @return 查询到的实体对象
     */
    T getByCriteria(List<Criteria> orCriteriaList) ;

    /**
     * 根据指定的条件进行查询对象
     * @param criteria 条件对象
     * @return 查询到的实体对象
     */
    T getByCriteria(Criteria criteria) ;

    /**
     * 获取总记录数量
     * @return 总记录数量
     */
    long getCount() ;

    /**
     * 根据参数实体属性中非空字段的 and 条件进行 统计
     *      例如：如果实体对象中属性name和passwd不为空，那么会根据 name = ? and passwd = ? 来进行 统计
     * @param param 参数实体对象
     * @return 统计的结果数量
     */
    long getCountByParam(T param);

    /**
     * 根据指定的条件进行统计对象数量
     * @param criteria 条件对象
     * @return 统计到的实体对象数量
     */
    long getCountByCriteria(Criteria criteria);

    /**
     * 根据指定的条件进行统计对象数量
     * @param orCriteriaList 集合参数，如果集合长度大于1，那么条件之间是or的关系
     * @return 统计到的实体对象数量
     */
    long getCountByCriteria(List<Criteria> orCriteriaList);

    /**
     * 获取所有实体类数据
     * @return 查询到的结果集封装对象
     */
    QueryResult<T> getScrollData() ;

    /**
     * 分页获取实体类数据，pagination和maxResult如果其中有一个小于等于0，表示查询所有记录
     * @param pagination 页码，从1开始，如果传递过来的小于1，表示查询所有记录
     * @param maxResult 每页最多显示的记录数量，如果传递过来的小于1，表示查询所有记录
     * @return 查询到的结果集封装对象
     */
    QueryResult<T> getScrollData(int pagination, int maxResult) ;

    /**
     * 分页获取实体类数据，pagination和maxResult如果其中有一个小于等于0，表示查询所有记录
     * @param pagination 页码，从1开始，如果传递过来的小于1，表示查询所有记录
     * @param maxResult 每页最多显示的记录数量，如果传递过来的小于1，表示查询所有记录
     * @param orderBy 字段的排序情况：
     * 		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>() ;
     * 		orderby.put("username", "asc") ;
     * 		orderby.put("email", "desc") ;
     * @return 查询到的结果集封装对象
     */
    QueryResult<T> getScrollData(int pagination, int maxResult, LinkedHashMap<String, String> orderBy) ;

    /**
     * 分页获取实体类数据，pagination和maxResult如果其中有一个小于等于0，表示查询所有记录
     * @param pagination 页码，从1开始，如果传递过来的小于1，表示查询所有记录
     * @param maxResult 每页最多显示的记录数量，如果传递过来的小于1，表示查询所有记录
     * @param entity 查询条件，实体对象不为null的字段作为 and 条件
     * @param orderBy 字段的排序情况：
     * 		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>() ;
     * 		orderby.put("username", "asc") ;
     * 		orderby.put("email", "desc") ;
     * @return 查询到的结果集封装对象
     */
    QueryResult<T> getScrollData(int pagination, int maxResult, T entity, LinkedHashMap<String, String> orderBy) ;

    /**
     * 分页获取实体类数据，pagination和maxResult如果其中有一个小于等于0，表示查询所有记录
     * @param pagination 页码，从1开始，如果传递过来的小于1，表示查询所有记录
     * @param maxResult 每页最多显示的记录数量，如果传递过来的小于1，表示查询所有记录
     * @param entities 查询条件，实体对象不为null的字段作为 and 条件，传递多个之间是or的关系
     * @param orderBy 字段的排序情况：
     * 		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>() ;
     * 		orderby.put("username", "asc") ;
     * 		orderby.put("email", "desc") ;
     * @return 查询到的结果集封装对象
     */
    QueryResult<T> getScrollData(int pagination, int maxResult, List<T> entities, LinkedHashMap<String, String> orderBy) ;

    /**
     * 根据条件获取实体类数据，查询所有记录
     * @param orCriteriaList 查询条件，如果集合长度大于1，那么条件之间是or的关系
     * @param orderBy 字段的排序情况：
     * 		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>() ;
     * 		orderby.put("username", "asc") ;
     * 		orderby.put("email", "desc") ;
     * 	                传递过来null，表示不排序
     * @return 查询到的结果集封装对象
     */
    QueryResult<T> getScrollDataByCriteria(List<Criteria> orCriteriaList, LinkedHashMap<String, String> orderBy) ;

    /**
     * 分页获取实体类数据，pagination和maxResult如果其中有一个小于等于0，表示查询所有记录
     * @param pagination 页码，从1开始，如果传递过来的小于1，表示查询所有记录
     * @param maxResult 每页最多显示的记录数量，如果传递过来的小于1，表示查询所有记录
     * @param orCriteriaList 查询条件，如果集合长度大于1，那么条件之间是or的关系
     * @param orderBy 字段的排序情况：
     * 		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>() ;
     * 		orderby.put("username", "asc") ;
     * 		orderby.put("email", "desc") ;
     * 	                传递过来null，表示不排序
     * @return 查询到的结果集封装对象
     */
    QueryResult<T> getScrollDataByCriteria(int pagination, int maxResult, List<Criteria> orCriteriaList, LinkedHashMap<String, String> orderBy) ;

}
