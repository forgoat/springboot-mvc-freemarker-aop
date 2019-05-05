package com.demo4.entity;

public class UserLog {
    private Integer id;
    private String action;
    private String username;
    private String time;

    public UserLog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", username='" + username + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
