package com.graduate.model;

import java.util.Date;

public class Department {
    private Long id;

    private String number;

    private String name;

    private String landline;

    private Byte status;

    private Date createTime;

    private Date modifiedTime;

    public Department(Long id, String number, String name, String landline, Byte status, Date createTime, Date modifiedTime) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.landline = landline;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public Department() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline == null ? null : landline.trim();
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