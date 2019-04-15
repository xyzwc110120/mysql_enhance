package com.cyx.mysql.mysql_01_advancedQuery.dao;

import com.cyx.mysql.mysql_01_advancedQuery.domain.Product;
import com.cyx.mysql.mysql_01_advancedQuery.query.PageResult;
import com.cyx.mysql.mysql_01_advancedQuery.query.ProductQuery;

import java.util.List;

public interface IProductDAO {

    /**
     * 获取商品列表
     *
     * @param query 条件参数对象
     */
    List<Product> query(ProductQuery query);

    /**
     * 分页查询
     *
     * @param currentPage 当前页
     * @param pageSize 每页条数
     * @param query 条件参数对象
     */
    PageResult query(Integer currentPage, Integer pageSize, ProductQuery query);
}
