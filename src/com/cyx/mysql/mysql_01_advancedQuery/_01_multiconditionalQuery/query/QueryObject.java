package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.query;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryObject {

    // 封装查询条件
    private List<String> conditions = new ArrayList<>();
    // 用来存放条件查询占位参数
    private List<Object> parameters = new ArrayList<>();

    /**
     * @return 获取拼接的多条件查询 SQL
     */
    public String getQuery() {
        // 存入查询条件和参数
        customizedQuery();

        // 若没有任何查询条件，则返回空字符
        if (conditions.isEmpty()) {
            return "";
        }

        // 使用 org.apache.commons.lang3.StringUtils 包中的 join 方法，该方法会用指定字符串来将集合元素一个接一个拼接成一个字符串
        return " WHERE " + StringUtils.join(conditions, " AND ");
    }

    /**
     * @return 获取多条件查询占位符参数集合
     */
    public List<Object> getParameters() {
        return parameters;
    }

    /**
     * 暴露给子类：让子类覆盖并编写自身的查询条件
     */
    protected void customizedQuery() {
    }

    /**
     * 暴露给子类：让子类在 customizedQuery() 方法中调用，调价自己的查询条件和参数
     *
     * @param condition 查询条件
     * @param params 查询条件对应的参数
     */
    protected void addQuery(String condition, Object... params) {
        conditions.add(condition);
        // 将多参数转化为集合然后全部添加至参数集合中
        parameters.addAll(Arrays.asList(params));
    }
}