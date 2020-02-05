package com.itdr.pojo;

import java.util.Date;

public class Order {
   private Integer id;
   private String order_num;
   private String cname;
   private String c_iphon;
   private String pname;
   private Double price;
   private Integer pnum;
   private Double sum;
   private String times;
   private String state;

    public Order() {
    }

    public Order(Integer id, String order_num, String cname, String c_iphon, String pname, Double price, Integer pnum, Double sum, String times, String state) {
        this.id = id;
        this.order_num = order_num;
        this.cname = cname;
        this.c_iphon = c_iphon;
        this.pname = pname;
        this.price = price;
        this.pnum = pnum;
        this.sum = sum;
        this.times = times;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getC_iphon() {
        return c_iphon;
    }

    public void setC_iphon(String c_iphon) {
        this.c_iphon = c_iphon;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
