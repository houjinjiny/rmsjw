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

    @Override
    public int getNum1() {
        String keys="%待发货%";
        List<Order> orders = orderDao.selectBystate(keys);
        int i=orders.size();
        return i;
    }

    @Override
    public int getNum2() {
        String keys="%待收款%";
        List<Order> orders = orderDao.selectBystate(keys);
        int i=orders.size();
        return i;
    }

    @Override
    public int getNum3() {
        String keys="%待收货%";
        List<Order> orders = orderDao.selectBystate(keys);
        int i=orders.size();
        return i;
    }

    @Override
    public int getNum4() {
        String keys="%待付款%";
        List<Order> orders = orderDao.selectBystate(keys);
        int i=orders.size();
        return i;
    }

    @Override
    public int getNum5() {
        List<Order> orderlist=orderDao.selectAll();
        int i=orderlist.size();
        return i;
    }

    @Override
    public int getNum6() {
        String keys="%已%";
        List<Order> orders = orderDao.selectBystate(keys);
        int i=orders.size();
        return i;
    }

    @Override
    public ResponseCode getHuo() {
        String keys="%货%";
        List<Order> orders = orderDao.selectBystate(keys);
        return ResponseCode.toSuccess(orders);
    }

    @Override
    public ResponseCode daifah() {
        String keys="%待发货%";
        List<Order> orders = orderDao.selectBystate(keys);
        return ResponseCode.toSuccess(orders);
    }

    @Override
    public ResponseCode daisk() {
        String keys="%待收款%";
        List<Order> orders = orderDao.selectBystate(keys);
        return ResponseCode.toSuccess(orders);
    }

    @Override
    public ResponseCode daifsh() {
        String keys="%待收货%";
        List<Order> orders = orderDao.selectBystate(keys);
        return ResponseCode.toSuccess(orders);
    }

    @Override
    public ResponseCode daifk() {
        String keys="%待付款%";
        List<Order> orders = orderDao.selectBystate(keys);
        return ResponseCode.toSuccess(orders);
    }

}
