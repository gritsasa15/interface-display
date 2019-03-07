package com.bba.chart.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("app_info")
public class AppInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private int id;

    private String compassId;

    private String appName;

    private String appPlant;

    private String appDesc;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompassId() {
        return compassId;
    }

    public void setCompassId(String compassId) {
        this.compassId = compassId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPlant() {
        return appPlant;
    }

    public void setAppPlant(String appPlant) {
        this.appPlant = appPlant;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
