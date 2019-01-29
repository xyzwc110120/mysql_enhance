package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.query;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

// 封装了商品的查询条件
@Getter@Setter
public class ProductQuery extends QueryObject {

    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer type;

    /**
     * 自定义查询条件
     */
    public void customizedQuery() {
        if (StringUtils.isNotBlank(name)) {
            addQuery("p.`name` LIKE ?", "%" + name + "%");
        }
        if (minPrice != null) {
            addQuery("p.purchasing_price >= ?", minPrice);
        }
        if (maxPrice != null) {
            addQuery("p.purchasing_price <= ?", minPrice);
        }
        if (type != null) {
            addQuery("p.product_type_id = ?", type);
        }
    }
}