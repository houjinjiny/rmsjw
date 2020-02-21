package com.itdr.service;

import com.itdr.common.ResponseCode;

public interface OrderService {
    ResponseCode getAll();

    ResponseCode selectByNum(String key);

    ResponseCode selectByState(String key);

    int getNum1();

    int getNum2();

    int getNum3();

    int getNum4();

    int getNum5();

    int getNum6();

    ResponseCode getHuo();

    ResponseCode daifah();

    ResponseCode daisk();

    ResponseCode daifsh();

    ResponseCode daifk();
}
