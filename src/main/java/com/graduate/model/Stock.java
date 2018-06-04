package com.graduate.model;

import java.util.Date;

public class Stock {
    private Long id;

    private String no;

    private Integer stock;

    private Date createTime;

    private Date modifiedTime;

    public Stock(Long id, String no, Integer stock, Date createTime, Date modifiedTime) {
        this.id = id;
        this.no = no;
        this.stock = stock;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public Stock() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}