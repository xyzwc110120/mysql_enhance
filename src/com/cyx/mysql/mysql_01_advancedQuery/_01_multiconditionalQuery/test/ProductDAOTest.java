package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.test;

import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.dao.IProductDAO;
import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.dao.impl.ProductDAOImpl;
import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.query.ProductQuery;
import org.junit.Test;

public class ProductDAOTest {

    private IProductDAO productDAO = new ProductDAOImpl();

    @Test
    public void testGetList() {
        ProductQuery query = new ProductQuery();
        query.setType(2);
        System.out.println(productDAO.query(query));
    }
}
