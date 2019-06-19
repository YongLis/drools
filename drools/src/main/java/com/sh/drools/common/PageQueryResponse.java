package com.sh.drools.common;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Auther: liyong
 * @Date:2019/6/18 16:43
 * @Desc: the description of class
 */
public class PageQueryResponse<T> extends BaseResponse {
    private static final long serialVersionUID = 3042532986025696330L;
    private PagedResult<T> pagedResult;

    public PageQueryResponse() {
    }

    public PagedResult<T> getPagedResult() {
        return this.pagedResult;
    }

    public void setPagedResult(PagedResult<T> pagedResult) {
        this.pagedResult = pagedResult;
    }

    public String toString() {
        return (new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).toString();
    }
}