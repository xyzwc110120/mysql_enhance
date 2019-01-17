package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.dao;

import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.domain.Product;
import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.query.ProductQuery;

import java.util.List;

public interface IProductDAO {

    /**
     * 获取商品列表
     *
     * @param query 条件参数对象
     */
    List<Product> query(ProductQuery query);
}
