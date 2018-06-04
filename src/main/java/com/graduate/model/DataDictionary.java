package com.graduate.model;

/**
 * 数据自定表
 * @author xiyouquedongxing
 * @date 2018/5/26 23:22
 *
 */
public class DataDictionary {
    /**主键*/
    private Integer id;

    /**列名*/
    private String columnName;

    /**参数值*/
    private String insideValue;

    /**参数名称*/
    private String exteriorValue;

    /**备注*/
    private String demo;

    /**创建时间*/
    private String createTime;

    /**最后一次修改时间*/
    private String modifiedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getInsideValue() {
        return insideValue;
    }

    public void setInsideValue(String insideValue) {
        this.insideValue = insideValue;
    }

    public String getExteriorValue() {
        return exteriorValue;
    }

    public void setExteriorValue(String exteriorValue) {
        this.exteriorValue = exteriorValue;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
