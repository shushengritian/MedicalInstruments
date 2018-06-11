package com.graduate.model;

import java.math.BigDecimal;
import java.util.Date;

public class AccessStock {
    private Long id;

    private String singleNo;

    private Byte sType;

    private String hcNo;

    private String hcName;

    private Byte unit;

    private BigDecimal price;

    private Integer number;

    private BigDecimal amount;

    private String validDate;

    private Byte inOrOut;

    private Date createTime;

    private Date modifiedTime;

    public AccessStock(Long id, String singleNo, Byte sType, String hcNo, String hcName, Byte unit, BigDecimal price, Integer number, BigDecimal amount, String validDate, Byte inOrOut, Date createTime, Date modifiedTime) {
        this.id = id;
        this.singleNo = singleNo;
        this.sType = sType;
        this.hcNo = hcNo;
        this.hcName = hcName;
        this.unit = unit;
        this.price = price;
        this.number = number;
        this.amount = amount;
        this.validDate = validDate;
        this.inOrOut = inOrOut;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public AccessStock() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSingleNo() {
        return singleNo;
    }

    public void setSingleNo(String singleNo) {
        this.singleNo = singleNo == null ? null : singleNo.trim();
    }

    public Byte getsType() {
        return sType;
    }

    public void setsType(Byte sType) {
        this.sType = sType;
    }

    public String getHcNo() {
        return hcNo;
    }

    public void setHcNo(String hcNo) {
        this.hcNo = hcNo == null ? null : hcNo.trim();
    }

    public String getHcName() {
        return hcName;
    }

    public void setHcName(String hcName) {
        this.hcName = hcName;
    }

    public Byte getUnit() {
        return unit;
    }

    public void setUnit(Byte unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate == null ? null : validDate.trim();
    }

    public Byte getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(Byte inOrOut) {
        this.inOrOut = inOrOut;
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