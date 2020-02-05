package com.itdr.dao;

import com.itdr.pojo.Customer;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CustomerDao {
    public List<Customer> getAllCustomer() {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="SELECT id,cname,id_number,iphone,email,sex,address,type FROM customer";
        List<Customer> query =null;
        try {
            query = qr.query(sql, new BeanListHandler<Customer>(Customer.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public List<Customer> selectByidnamber(String key) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="SELECT id,cname,id_number,iphone,email,sex,address,type FROM customer WHERE id_number=?";
        List<Customer> query =null;
        try {
            query = qr.query(sql, new BeanListHandler<>(Customer.class), key);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public List<Customer> getAllNormalCustomer() {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="SELECT id,cname,id_number,iphone,email,sex,address,type FROM customer WHERE type BETWEEN 0 AND 4  ";
        List<Customer> query =null;
        try {
            query = qr.query(sql, new BeanListHandler<>(Customer.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public List<Customer> getAllGoldCustomer() {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="SELECT id,cname,id_number,iphone,email,sex,address,type FROM customer WHERE type>=5";
        List<Customer> query =null;
        try {
            query = qr.query(sql, new BeanListHandler<>(Customer.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public int upType(int a,int b) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="UPDATE customer SET type=? WHERE id_number=?";
        int query =0;
        try {
            query=qr.update(sql,(b+1),a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public int downType(int a, int b) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="UPDATE customer SET type=? WHERE id_number=?";
        int query =0;
        try {
            query=qr.update(sql,(b-1),a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
