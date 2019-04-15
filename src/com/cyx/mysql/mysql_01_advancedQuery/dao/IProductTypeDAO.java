package com.cyx.mysql.mysql_01_advancedQuery.dao;


import com.cyx.mysql.mysql_01_advancedQuery.domain.ProductType;

import java.util.List;

public interface IProductTypeDAO {

    /**
     * 获取所有商品类型列表
     */
    List<ProductType> getAll();
}
