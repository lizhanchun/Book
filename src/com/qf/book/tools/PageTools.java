package com.qf.book.tools;

import java.util.List;

/**
 * 分页工具类
 *
 * @author MrLi
 * @version 1.0 2021/1/27 17:47
 */
public class PageTools<T> {
    /**
     * 当前页码
     */
    private Integer currPage;
    /**
     * 总记录数
     */
    private Integer totalCount;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 每页记录条数
     */
    private Integer numPage;
    /**
     * 每页起始页数
     */
    private Integer startPage;

    /**
     * 查询出来的记录结果
     * @return
     */
    private List<T> list;

    /**
     * 获得当前页码
     * @return
     */
    public Integer getCurrPage() {
        return currPage;
    }

    /**
     * 设置当前页码
     * @param currPage
     */
    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    /**
     * 获得总记录数
     * @return
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总记录数
     * @param totalCount
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获得当前页记录数
     * @return
     */
    public Integer getTotalPage() {
        return totalPage;
    }

    /**
     * 设置当前页记录条数
     * @param totalPage
     */
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 获得每页展示的条数
     * @return
     */
    public Integer getNumPage() {
        return numPage;
    }

    /**
     * 设置每页展示的条数
     * @param numPage
     */
    public void setNumPage(Integer numPage) {
        this.numPage = numPage;
    }

    /**
     * 获得起始页数
     * @return
     */
    public Integer getStartPage() {
        return startPage;
    }

    /**
     * 设置起始页数
     * @param startPage
     */
    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    /**
     * 获得分页后结果
     * @return
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置分页后的结果
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageTools{" +
                "currPage=" + currPage +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", numPage=" + numPage +
                ", startPage=" + startPage +
                ", list=" + list +
                '}';
    }
}
