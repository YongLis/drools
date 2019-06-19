package com.sh.drools.common;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: liyong
 * @Date:2019/6/18 16:43
 * @Desc: the description of class
 */
public class PagedResult<T> implements Serializable {
    private List<T> dataList;
    private long pageNumber;
    private long pageSize;
    private long total;
    private long pages;

    public PagedResult() {
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public long getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return this.pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public String toString() {
        return "PagedResult{, pageNumber=" + this.pageNumber + ", pageSize=" + this.pageSize + ", total=" + this.total + ", pages=" + this.pages + '}';
    }
}