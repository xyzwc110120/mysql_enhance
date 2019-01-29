package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.query;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

// 封装了商品分类的查询条件
@Getter@Setter
public class ProductTypeQuery extends QueryObject {

    private Integer id;
    private String name;

    /**
     * 自定义查询条件
     */
    public void customizedQuery() {
        if (id != null) {
            addQuery("pt.id = ?", id);
        }
        if (StringUtils.isNotBlank(name)) {
            addQuery("pt.`name` LIKE ?", "%" + name + "%");
        }
    }
}