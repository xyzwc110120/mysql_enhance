package com.cyx.mysql.mysql_01_advancedQuery.dao.impl;


import com.cyx.mysql.mysql_01_advancedQuery.dao.IProductTypeDAO;
import com.cyx.mysql.mysql_01_advancedQuery.domain.ProductType;
import com.cyx.mysql.utils.JDBCUtil.handler.impl.BeanListHandler;
import com.cyx.mysql.utils.JDBCUtil.template.JDBCTemplate;

import java.util.List;

public class ProductTypeDAOImpl implements IProductTypeDAO {

    @Override
    public List<ProductType> getAll() {
        String sql = "SELECT pt.id, pt.`name` FROM product_type pt";
        return JDBCTemplate.query(sql, new BeanListHandler<>(ProductType.class));
    }
}
