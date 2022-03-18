package com.ljp.hospital.entity;

import java.util.List;

public class Result {
    String msg;
    List<User> users;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Result() {
    }

    public Result(String msg, List<User> users) {
        this.msg = msg;
        this.users = users;
    }
}
