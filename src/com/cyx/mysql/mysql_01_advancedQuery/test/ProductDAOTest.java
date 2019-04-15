package com.cyx.mysql.mysql_01_advancedQuery.test;

import com.cyx.mysql.mysql_01_advancedQuery.dao.IProductDAO;
import com.cyx.mysql.mysql_01_advancedQuery.dao.impl.ProductDAOImpl;
import com.cyx.mysql.mysql_01_advancedQuery.query.ProductQuery;
import org.junit.Test;

public class ProductDAOTest {

    private IProductDAO productDAO = new ProductDAOImpl();

    @Test
    public void testGetList() {
        ProductQuery query = new ProductQuery();
        query.setType(2);
        System.out.println(productDAO.query(query));
    }

    @Test
    public void testPage() {
        ProductQuery query = new ProductQuery();
        query.setKeyword("可");
        System.out.println(productDAO.query(2, 2, query));
    }
}
