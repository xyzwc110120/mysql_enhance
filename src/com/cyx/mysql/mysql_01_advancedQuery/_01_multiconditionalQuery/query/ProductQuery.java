package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.query;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

// 封装了商品的查询条件
@Getter@Setter
public class ProductQuery extends QueryObject {

    private String name;                // 商品名
    private BigDecimal minPrice;        // 最低价格
    private BigDecimal maxPrice;        // 最高价格
    private Integer type;               // 商品类型
    private String keyword;             // 关键字

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
        // 从商品名和商品品牌中查询关键字
        if (StringUtils.isNotBlank(keyword)) {
            // 因为有两个 ? 占位符，所以需要两个参数
            /* 因为在 MySQL 种，AND 优先级高于 OR，所以要加上“()”来保证 SQL 语句的正确 */
            addQuery("(p.`name` LIKE ? OR p.brand LIKE ?)", "%" + keyword + "%", "%" + keyword + "%");
        }
    }
}