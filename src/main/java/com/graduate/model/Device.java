package com.graduate.model;

import java.util.Date;

public class Device {
    private Long id;

    private String deviceNo;

    private String deviceName;

    private Byte unit;

    private Byte deviceType;

    private Byte isMeasurement;

    private Byte status;

    private Date createTime;

    private Date modifiedTime;

    public Device(Long id, String deviceNo, String deviceName, Byte unit, Byte deviceType, Byte isMeasurement, Byte status, Date createTime, Date modifiedTime) {
        this.id = id;
        this.deviceNo = deviceNo;
        this.deviceName = deviceName;
        this.unit = unit;
        this.deviceType = deviceType;
        this.isMeasurement = isMeasurement;
        this.status = status;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public Device() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Byte getUnit() {
        return unit;
    }

    public void setUnit(Byte unit) {
        this.unit = unit;
    }

    public Byte getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Byte deviceType) {
        this.deviceType = deviceType;
    }

    public Byte getIsMeasurement() {
        return isMeasurement;
    }

    public void setIsMeasurement(Byte isMeasurement) {
        this.isMeasurement = isMeasurement;
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