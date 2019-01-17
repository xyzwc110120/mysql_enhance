package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.query;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// 条件查询对象
@Getter@Setter
public class ProductQuery {

    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer type;

    // 用来存放条件查询占位参数
    private List<Object> parameters = new ArrayList<>();

    /**
     * @return 获取拼接的多条件查询 SQL
     */
    public String getQuery() {
        // 封装查询条件
        List<String> conditions = new ArrayList<>();

        StringBuilder sql = new StringBuilder(70);
        if (StringUtils.isNotBlank(name)) {
            conditions.add("p.`name` LIKE ?");
            parameters.add("%" + name + "%");
        }
        if (minPrice != null) {
            conditions.add("p.purchasing_price >= ?");
            parameters.add(minPrice);
        }
        if (maxPrice != null) {
            conditions.add("p.purchasing_price <= ?");
            parameters.add(maxPrice);
        }
        if (type != null) {
            conditions.add("p.product_type_id = ?");
            parameters.add(type);
        }

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
}