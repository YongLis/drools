package com.sh.drools.common;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: liyong
 * @Date:2019/6/19 10:48
 * @Desc: the description of class
 */
public class PageQueryRequest<T> implements Serializable {
    private T t;
    private int pageNumber;
    private int pageSize;

    public int getPageNumber() {
        return pageNumber;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
