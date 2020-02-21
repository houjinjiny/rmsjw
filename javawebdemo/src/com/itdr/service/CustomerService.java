package com.itdr.service;

import com.itdr.common.ResponseCode;

public interface CustomerService {
    ResponseCode getAllCustomer();

    ResponseCode selectByidnamber(String key);

    ResponseCode getAllNormalCustomer();

    ResponseCode getAllGoldCustomer();

    ResponseCode upType(String i,String num);

    ResponseCode downType(String i, String num);

    int getC1();

    int getC2();
}
