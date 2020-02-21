package com.itdr.service.impl;

import com.itdr.common.ResponseCode;
import com.itdr.dao.CustomerDao;
import com.itdr.pojo.Customer;
import com.itdr.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao=new CustomerDao();
    @Override
    public ResponseCode getAllCustomer() {
        List<Customer> customerlist=customerDao.getAllCustomer();
        return ResponseCode.toSuccess(customerlist);
    }

    @Override
    public ResponseCode selectByidnamber(String key) {
        //非空判断
        if(key==null||"".equals(key)){
            return ResponseCode.toDefeated("参数非法！");
        }
        List<Customer> customer=customerDao.selectByidnamber(key);
        return ResponseCode.toSuccess(customer);
    }

    @Override
    public ResponseCode getAllNormalCustomer() {
        List<Customer> customerlist=customerDao.getAllNormalCustomer();
        return ResponseCode.toSuccess(customerlist);
    }

    @Override
    public ResponseCode getAllGoldCustomer() {
        List<Customer> customerlist=customerDao.getAllGoldCustomer();
        return ResponseCode.toSuccess(customerlist);
    }

    @Override
    public ResponseCode upType(String i,String num) {
        int a=Integer.parseInt(i);
        int b=Integer.parseInt(num);
        int i2=customerDao.upType(a,b);
        return ResponseCode.toSuccess(i2);
    }

    @Override
    public ResponseCode downType(String i, String num) {
        int a=Integer.parseInt(i);
        int b=Integer.parseInt(num);
        int i2=customerDao.downType(a,b);
        return ResponseCode.toSuccess(i2);
    }

    @Override
    public int getC1() {
        List<Customer> customerlist=customerDao.getAllNormalCustomer();
        int i=customerlist.size();
        System.out.println(i);
        return i;
    }

    @Override
    public int getC2() {
        List<Customer> customerlist=customerDao.getAllGoldCustomer();
        int i=customerlist.size();
        System.out.println(i);
        return i;
    }
}
