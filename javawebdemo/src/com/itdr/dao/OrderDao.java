package com.itdr.dao;

import com.itdr.pojo.Order;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    //查询所有商品
    public List<Order> selectAll() {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="SELECT * FROM orders";
        List<Order> query =null;
        try {
            query = qr.query(sql, new BeanListHandler<Order>(Order.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public List<Order> selectByNum(String key) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="SELECT * FROM orders WHERE order_num=?";
        List<Order> query =null;
        try {
            query = qr.query(sql, new BeanListHandler<Order>(Order.class),key);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public List<Order> selectBystate(String keys) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="SELECT * FROM orders WHERE state like ?";
        List<Order> query =null;
        try {
            query = qr.query(sql, new BeanListHandler<Order>(Order.class),keys);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
