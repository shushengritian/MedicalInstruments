package com.graduate.model;

import java.math.BigDecimal;
import java.util.Date;

public class Supplies {
    private Long id;

    private String hcNo;

    private String hcName;

    private String manafacturer;

    private Byte hcType;

    private Byte unit;

    private BigDecimal price;

    private Byte status;

    private Date createTime;

    private Date modifiedTime;

    public Supplies(Long id, String hcNo, String hcName, String manafacturer, Byte hcType, Byte unit, BigDecimal price, Byte status, Date createTime, Date modifiedTime) {
        this.id = id;
        this.hcNo = hcNo;
        this.hcName = hcName;
        this.manafacturer = manafacturer;
        this.hcType = hcType;
        this.unit = unit;
        this.price = price;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public Supplies() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.hcName = hcName == null ? null : hcName.trim();
    }

    public String getManafacturer() {
        return manafacturer;
    }

    public void setManafacturer(String manafacturer) {
        this.manafacturer = manafacturer == null ? null : manafacturer.trim();
    }

    public Byte getHcType() {
        return hcType;
    }

    public void setHcType(Byte hcType) {
        this.hcType = hcType;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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