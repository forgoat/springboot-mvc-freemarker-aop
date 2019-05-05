package com.demo4.entity;

public class Alumni {
    private Integer id;
    private String name;
    private String gender;
    private String birthday;
    private String enrollmentYear;
    private String graduatedYear;
    private String workingArea;
    private String position;
    private String smartphone;
    private String email;
    private String wechat;

    public Alumni() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getGraduatedYear() {
        return graduatedYear;
    }

    public void setGraduatedYear(String graduatedYear) {
        this.graduatedYear = graduatedYear;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(String smartphone) {
        this.smartphone = smartphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Override
    public String toString() {
        return "Alumni{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", enrollmentYear='" + enrollmentYear + '\'' +
                ", graduatedYear='" + graduatedYear + '\'' +
                ", workingArea='" + workingArea + '\'' +
                ", position=" +position  + '\'' +
                ", smartphone='" + smartphone + '\'' +
                ", email='" + email + '\'' +
                ", wechat='" + wechat + '\'' +
                '}';
    }
}
