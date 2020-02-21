package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public Users selectByUserNameAndPassword(String username,String password){
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());

        String sql = "select * from users where username=? and password=?";

        Users u = null;
        try {
            u = qr.query(sql, new BeanHandler<Users>(Users.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public int updateBypass(String username, String passO, String passN) {
        QueryRunner qr = new QueryRunner(C3P0Util.getCom());

        String sql = "update users set password=? where username=? and password=?";
        int update=0;
        try {
            update = qr.update(sql, passN, username, passO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
