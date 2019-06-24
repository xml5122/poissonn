package com.poissonn.vo;

import java.io.Serializable;

public class PageVo implements Serializable {


    private static final long serialVersionUID = -2053833685557620072L;

    private int pageSize;//每页大小

    private int currentPage;//当前页数

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}
