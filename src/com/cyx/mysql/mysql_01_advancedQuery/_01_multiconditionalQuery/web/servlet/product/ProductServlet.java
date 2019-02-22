package com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.web.servlet.product;

import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.dao.IProductDAO;
import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.dao.IProductTypeDAO;
import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.dao.impl.ProductDAOImpl;
import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.dao.impl.ProductTypeDAOImpl;
import com.cyx.mysql.mysql_01_advancedQuery._01_multiconditionalQuery.query.ProductQuery;
import com.cyx.mysql.utils.RequestUtil.RequestParameter2QueryObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mysql/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 3736300805114735596L;

    private IProductDAO productDAO;
    private IProductTypeDAO productTypeDAO;

    @Override
    public void init() {
        productDAO = new ProductDAOImpl();
        productTypeDAO = new ProductTypeDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");

        // 将请求参数转换为 Query 对象
        try {
            ProductQuery query = RequestParameter2QueryObject.RequestParameter2QueryObject(req, ProductQuery.class);

            req.setAttribute("query", query);
            req.setAttribute("productTypes", productTypeDAO.getAll());
            req.setAttribute("products", productDAO.query(query));
            req.getRequestDispatcher("/WEB-INF/views/product/productList.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}