package com.cyx.mysql.mysql_01_advancedQuery.query;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 封装分页查询对象
 */
@Getter
public class PageResult {

    private Integer currentPage = 1;        // 当前页
    private Integer pageSize = 10;          // 每页显示条数

    @Setter
    private List<?> dataList;               // 结果集数据
    private Integer beginIndex;             // 查询起始索引
    private Integer totalCount;             // 结果总数

    private Integer beginPage = 1;          // 首页
    private Integer prevPage;               // 上一页
    private Integer nextPage;               // 下一页
    private Integer totalPage;              // 总页数

    /**
     * 构造器：获取需要查询的分页参数，并计算出查询起始索引（beginIndex）
     *
     * @param currentPage 当前页数
     * @param pageSize 每页显示条数
     */
    public PageResult(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        // 计算查询索引
        beginIndex = (currentPage - 1) * pageSize;
    }

    /**
     * 传入总条数，并计算总页数及其他分页数据
     *
     * @param totalCount 总条数
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        // 计算总页数
        totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        // 计算上一页页数
        prevPage = currentPage > 1 ? currentPage - 1 : currentPage;
        // 计算下一页
        nextPage = currentPage < totalPage ? currentPage + 1 : totalPage;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", dataList=" + dataList +
                ", beginIndex=" + beginIndex +
                ", totalCount=" + totalCount +
                ", beginPage=" + beginPage +
                ", prevPage=" + prevPage +
                ", nextPage=" + nextPage +
                ", totalPage=" + totalPage +
                '}';
    }
}