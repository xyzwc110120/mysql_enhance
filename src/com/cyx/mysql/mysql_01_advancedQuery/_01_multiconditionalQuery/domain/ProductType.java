package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductType {

    private Integer id;            // 商品类型id
    private String name;        // 商品类型名称

    public ProductType() {
    }
}
