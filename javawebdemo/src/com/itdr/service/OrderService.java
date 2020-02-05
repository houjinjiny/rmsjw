package com.itdr.service;

import com.itdr.common.ResponseCode;

public interface OrderService {
    ResponseCode getAll();

    ResponseCode selectByNum(String key);

    ResponseCode selectByState(String key);
}
