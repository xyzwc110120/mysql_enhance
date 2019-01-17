package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.web.servlet.product;

import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.dao.IProductDAO;
import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.dao.impl.ProductDAOImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mysql/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 3736300805114735596L;

    private IProductDAO productDAO;

    @Override
    public void init() {
        productDAO = new ProductDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
    }
}
