package com.cykj.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Wjhsmart on 2017/7/24.
 */
public class User {
    private int id;
    private String name;
    @JSONField(format="yyyy-MM-dd HH:mm")
    private Date createdTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
