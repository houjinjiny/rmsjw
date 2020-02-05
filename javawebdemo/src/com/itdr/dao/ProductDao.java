package com.itdr.dao;

import com.itdr.pojo.Product;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    public List<Product> selectAll() {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());

        String sql = "select id,pname,price,pnum,type,create_time,update_time from product";

        List<Product> query = null;
        try {
            query = qr.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public Product selectById(int i) {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());

        String sql = "select id,pname,price,pnum,type,create_time,update_time from product where id=?";

        Product query = null;
        try {
            query = qr.query(sql, new BeanHandler<Product>(Product.class),i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public int updateById(int i) {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());

        String sql = "update product set type=1 where id=? ";

        int query = 0;
        try {
            query = qr.update(sql,i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
    public int updateByIdup(int i) {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());

        String sql = "update product set type=0 where id=? ";

        int query = 0;
        try {
            query = qr.update(sql,i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
    public List<Product> selectByKey(String keyWord) {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());

        String sql = "select id,pname,price,pnum,type,create_time,update_time from product where pname like ?";

        List<Product> query = null;
        try {
            query = qr.query(sql, new BeanListHandler<Product>(Product.class),keyWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }


    public Product selectByPname(String pname) {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());

        String sql = "select id,pname,price,pnum,type,create_time,update_time from product where pname=?";

        Product query = null;
        try {
            query = qr.query(sql, new BeanHandler<Product>(Product.class),  pname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
    //添加商品
    public int insertinto(String pname, Double prices, Integer i) {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());

        String sql = "INSERT INTO product VALUES(null,?,?,?,0,now(),now())";

        int query = 0;
        try {
            query = qr.update(sql,pname,prices,i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
