package edu.cninfo.basic.vo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -5809782578272943999L;
    private String userName;
    private String password;
    private String sex;
    private int age;

    public String show() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String userName, String password, String sex, int age) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}