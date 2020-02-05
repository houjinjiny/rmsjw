package com.itdr.service.impl;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Product;
import com.itdr.service.ProductService;
import com.sun.deploy.util.StringUtils;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDao();
    //查询全部
    @Override
    public ResponseCode getAllProduct() {
        List<Product> productList = productDao.selectAll();
        return ResponseCode.toSuccess(productList);
    }
    //下架
    @Override
    public ResponseCode toType(String id) {
        //非空判断
        if(id==null||"".equals(id)){
            return ResponseCode.toDefeated("参数非法！");
        }
        int i = Integer.parseInt(id);
        Product p=productDao.selectById(i);
        //查询商品是否存在
        if(p==null){
            return ResponseCode.toDefeated("商品不存在！");
        }
        int i2=productDao.updateById(i);
        if(i2<0){
            return ResponseCode.toDefeated("下架失败！");
        }
        return ResponseCode.toSuccess(i2);
    }
    //模糊查询
    @Override
    public ResponseCode fuzzySearch(String key) {
        //非空判断
        if(com.mysql.jdbc.StringUtils.isNullOrEmpty(key)){
            return ResponseCode.toDefeated("参数非法！");
        }
        String keyWord="%"+key+"%";
        List<Product> plist=productDao.selectByKey(keyWord);
        return ResponseCode.toSuccess(plist);
    }
//上架
    @Override
    public ResponseCode upType(String id) {
        //非空判断
        if(id==null||"".equals(id)){
            return ResponseCode.toDefeated("参数非法！");
        }
        int i = Integer.parseInt(id);
        Product p=productDao.selectById(i);
        //查询商品是否存在
        if(p==null){
            return ResponseCode.toDefeated("商品不存在！");
        }
        int i2=productDao.updateByIdup(i);
        if(i2<0){
            return ResponseCode.toDefeated("上架失败！");
        }
        return ResponseCode.toSuccess(i2);
    }
    //添加商品
    @Override
    public ResponseCode addProduct(String pname, String price, String pnum) {
        //非空判断
        if(pname==null||"".equals(pname)){
            return ResponseCode.toDefeated("参数非法！");
        }
        if(price==null||"".equals(price)){
            return ResponseCode.toDefeated("参数非法！");
        }
        if(pnum==null||"".equals(pnum)){
            return ResponseCode.toDefeated("参数非法！");
        }
        //判断商品是否已经存在
        Product p=productDao.selectByPname(pname);
        //查询商品是否存在
        if(p!=null){
            return ResponseCode.toDefeated("商品已存在！");
        }
        Double prices=Double.parseDouble(price);
        Integer i=Integer.parseInt(pnum);
        int i2=productDao.insertinto(pname,prices,i);
        return ResponseCode.toSuccess(i2);
    }

}
