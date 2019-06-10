package com.pojo;

import com.pojo.other.BasePojo;

public class Task extends BasePojo {
    public long id;
    public String name;
    public String content;
    public String create_time;
    public int creator;
    public int executor;
    public String start_time;
    public String finish_time;
    public int state;
//    public int pagNum;
//    public int pagSize;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public int getExecutor() {
        return executor;
    }

    public void setExecutor(int executor) {
        this.executor = executor;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

//    public int getPagNum() {
//        return pagNum;
//    }
//
//    public void setPagNum(int pagNum) {
//        this.pagNum = pagNum;
//    }
//
//    public int getPagSize() {
//        return pagSize;
//    }
//
//    public void setPagSize(int pagSize) {
//        this.pagSize = pagSize;
//    }
}
