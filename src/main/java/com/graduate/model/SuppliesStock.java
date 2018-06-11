package com.graduate.model;

import java.math.BigDecimal;

/**
 * @author xiyouquedongxing
 * @date 2018/6/11 22:11
 */
public class SuppliesStock {

    private String hcNo;

    private String hcName;

    private Byte unit;

    private BigDecimal price;

    private Integer stock;

    public SuppliesStock(String hcNo, String hcName, Byte unit, BigDecimal price, Integer stock) {
        this.hcNo = hcNo;
        this.hcName = hcName;
        this.unit = unit;
        this.price = price;
        this.stock = stock;
    }

    public SuppliesStock() {
        super();
    }

    public String getHcNo() {
        return hcNo;
    }

    public void setHcNo(String hcNo) {
        this.hcNo = hcNo;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
