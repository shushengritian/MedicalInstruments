package com.graduate.model;

import java.util.Date;

public class Vendor {
    private Long id;

    private String vNo;

    private String vName;

    private String oibc;

    private String salesman;

    private String phone;

    private Byte vType;

    private Byte status;

    private Date createTime;

    private Date modifiedTime;

    public Vendor(Long id, String vNo, String vName, String oibc, String salesman, String phone, Byte vType, Byte status, Date createTime, Date modifiedTime) {
        this.id = id;
        this.vNo = vNo;
        this.vName = vName;
        this.oibc = oibc;
        this.salesman = salesman;
        this.phone = phone;
        this.vType = vType;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public Vendor() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getvNo() {
        return vNo;
    }

    public void setvNo(String vNo) {
        this.vNo = vNo == null ? null : vNo.trim();
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName == null ? null : vName.trim();
    }

    public String getOibc() {
        return oibc;
    }

    public void setOibc(String oibc) {
        this.oibc = oibc == null ? null : oibc.trim();
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman == null ? null : salesman.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Byte getvType() {
        return vType;
    }

    public void setvType(Byte vType) {
        this.vType = vType;
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