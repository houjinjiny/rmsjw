package com.itdr.service.impl;

import com.itdr.common.ResponseCode;
import com.itdr.dao.OrderDao;
import com.itdr.pojo.Order;
import com.itdr.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao=new OrderDao();
    @Override
    public ResponseCode getAll() {
        List<Order> orderlist=orderDao.selectAll();
        return ResponseCode.toSuccess(orderlist);
    }

    @Override
    public ResponseCode selectByNum(String key) {
        //非空判断
        if(key==null||"".equals(key)){
            return ResponseCode.toDefeated("参数非法！");
        }
        List<Order> orders=orderDao.selectByNum(key);
        return ResponseCode.toSuccess(orders);
    }

    @Override
    public ResponseCode selectByState(String key) {
        //非空判断
        if(key==null||"".equals(key)){
            return ResponseCode.toDefeated("参数非法！");
        }
        String keys="%"+key+"%";
        List<Order> orders=orderDao.selectBystate(keys);
        return ResponseCode.toSuccess(orders);
    }
}
