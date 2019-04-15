package com.cyx.mysql.mysql_01_advancedQuery.dao.impl;

import com.cyx.mysql.mysql_01_advancedQuery.dao.IProductDAO;
import com.cyx.mysql.mysql_01_advancedQuery.domain.Product;
import com.cyx.mysql.mysql_01_advancedQuery.query.PageResult;
import com.cyx.mysql.mysql_01_advancedQuery.query.ProductQuery;
import com.cyx.mysql.utils.JDBCUtil.handler.IResultSetHandler;
import com.cyx.mysql.utils.JDBCUtil.handler.impl.BeanListHandler;
import com.cyx.mysql.utils.JDBCUtil.template.JDBCTemplate;

import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

public class ProductDAOImpl implements IProductDAO {

    @Override
    public List<Product> query(ProductQuery query) {
        String sql = "SELECT p.id, p.product_type_id productTypeId, p.`name`, p.brand, p.purchasing_price purchasingPrice, " +
                "p.original_price originalPrice, p.current_price currentPrice FROM product p";

        /* 这里注意，集合 parameters 需要转换成数组，不然会将整个集合当成一个参数传入 */
        return JDBCTemplate.query(sql + query.getQuery(), new BeanListHandler<>(Product.class), query.getParameters().toArray());
    }

    @Override
    public PageResult query(Integer currentPage, Integer pageSize, ProductQuery query) {
        // 传入分页参数，创建分页对象
        PageResult page = new PageResult(currentPage, pageSize);
        // 查询条件 SQL
        String conditionsSql = query.getQuery();

        // 查询总数 SQL
        String countSql = "SELECT COUNT(p.id) FROM product p" + conditionsSql;
        // 查询出总数并放入分页对象
        page.setTotalCount(Objects.requireNonNull(JDBCTemplate.query(countSql, new IResultSetHandler<Long>() {
            @Override
            public Long handle(ResultSet set) throws Exception {
                if (set.next()) {
                    return set.getLong(1);
                }
                return 0L;
            }
        }, query.getParameters().toArray())).intValue());


        // 查询结果集 SQL
        String dataSql = "SELECT p.id, p.product_type_id productTypeId, p.`name`, p.brand, p.purchasing_price purchasingPrice, " +
                "p.original_price originalPrice, p.current_price currentPrice FROM product p" +
                conditionsSql + " LIMIT ?, ?";
        // 添加分页参数至参数集合
        List params = query.getParameters();
        params.add(page.getBeginIndex());
        params.add(pageSize);
        // 查询出结果集防止分页对象
        page.setDataList(JDBCTemplate.query(dataSql, new BeanListHandler<>(Product.class), params.toArray()));

        return page;
    }
}