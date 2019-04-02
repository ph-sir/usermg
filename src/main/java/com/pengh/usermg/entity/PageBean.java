package com.pengh.usermg.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author PENGHUI
 * @date create on 2019/3/27
 */
@Getter
@Setter
public class PageBean<T> {

    /**
     * 当前页
     */
    private Integer currentPage = 1;

    /**
     * 每页显示的总条数
     */
    private Integer pageSize = 1;

    /**
     * 总条数
     */
    private Integer totalNum;

    /**
     * 是否有下一页
     */
    private Integer isMore;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 开始索引
     */
    private Integer startIndex;

    /**
     * 分页结果
     */
    private List<T> data;

    public PageBean() {
        super();
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (totalNum + pageSize - 1) / pageSize;
        this.startIndex = (this.currentPage - 1) * this.pageSize;
        this.isMore = this.currentPage >= this.totalPage ? 0 : 1;
    }
}
