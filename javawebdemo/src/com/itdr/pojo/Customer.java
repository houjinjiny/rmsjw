package com.itdr.pojo;

public class Customer {
    private Integer id;
    private String cname;
    private String password;
    private String id_number;
    private String iphone;
    private String email;
    private String sex;
    private String address;
    private Integer type;

    public Customer() {
    }

    public Customer(Integer id, String cname, String password, String id_number, String iphone, String email, String sex, String address, Integer type) {
        this.id = id;
        this.cname = cname;
        this.password = password;
        this.id_number = id_number;
        this.iphone = iphone;
        this.email = email;
        this.sex = sex;
        this.address = address;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
