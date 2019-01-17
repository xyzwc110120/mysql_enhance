package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.dao.impl;

import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.dao.IProductDAO;
import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.domain.Product;
import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.query.ProductQuery;
import com.cyx.mysql.utils.JDBCUtil.handler.impl.BeanListHandler;
import com.cyx.mysql.utils.JDBCUtil.template.JDBCTemplate;

import java.util.List;

public class ProductDAOImpl implements IProductDAO {
    @Override
    public List<Product> query(ProductQuery query) {
        String sql = "SELECT p.id, p.product_type_id productTypeId, p.`name`, p.brand, p.purchasing_price purchasingPrice, " +
                "p.original_price originalPrice, p.current_price currentPrice FROM product p";

        /* 这里注意，集合 parameters 需要转换成数组，不然会将整个集合当成一个参数传入 */
        return JDBCTemplate.query(sql + query.getQuery(), new BeanListHandler<>(Product.class), query.getParameters().toArray());
    }
}