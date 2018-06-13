package com.graduate.model;

import java.util.Date;

public class User {
    private Long id;

    private String userName;

    private String loginAccount;

    private String password;

    private Byte userType;

    private Byte status;

    private String mobile;

    private String email;

    private Long department;

    private Date createTime;

    private Date modifiedTime;

    public User(Long id, String userName, String loginAccount, String password, Byte userType, Byte status, String mobile, String email, Long department, Date createTime, Date modifiedTime) {
        this.id = id;
        this.userName = userName;
        this.loginAccount = loginAccount;
        this.password = password;
        this.userType = userType;
        this.status = status;
        this.mobile = mobile;
        this.email = email;
        this.department = department;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
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