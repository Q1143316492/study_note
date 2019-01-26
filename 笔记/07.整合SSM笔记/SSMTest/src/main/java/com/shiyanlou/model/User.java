package com.shiyanlou.model;

public class User {
    private Integer id;       // 用户 id
    private String username;  // 用户名
    private String password;  // 密码
    private String sex;       // 性别
    private Integer age;      // 年龄

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // 重写了 toString 方法，方便后面的测试
    public String toString() {
        return "id:" + id + ",username:" + username + ",password:" + password
                + ",sex:" + sex + ",age:" + age;

    }
}