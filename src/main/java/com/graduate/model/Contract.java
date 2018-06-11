package com.graduate.model;

import java.util.Date;

public class Contract {
    private Long id;

    private String cNo;

    private String cName;

    private Byte cType;

    private String partyB;

    private String bContacts;

    private String phone;

    private Date signedDate;

    private Date endDate;

    private String content;

    private Date createTime;

    private Date modifiedTime;

    public Contract(Long id, String cNo, String cName, Byte cType, String partyB, String bContacts, String phone, Date signedDate, Date endDate, String content, Date createTime, Date modifiedTime) {
        this.id = id;
        this.cNo = cNo;
        this.cName = cName;
        this.cType = cType;
        this.partyB = partyB;
        this.bContacts = bContacts;
        this.phone = phone;
        this.signedDate = signedDate;
        this.endDate = endDate;
        this.content = content;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public Contract() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcNo() {
        return cNo;
    }

    public void setcNo(String cNo) {
        this.cNo = cNo == null ? null : cNo.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Byte getcType() {
        return cType;
    }

    public void setcType(Byte cType) {
        this.cType = cType;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB == null ? null : partyB.trim();
    }

    public String getbContacts() {
        return bContacts;
    }

    public void setbContacts(String bContacts) {
        this.bContacts = bContacts == null ? null : bContacts.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(Date signedDate) {
        this.signedDate = signedDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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