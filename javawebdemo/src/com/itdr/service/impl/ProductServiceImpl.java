package com.itdr.service.impl;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Product;
import com.itdr.service.ProductService;
import com.sun.deploy.util.StringUtils;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDao();

    @Override
    public ResponseCode getAllProduct() {
        List<Product> productList = productDao.selectAll();
        return ResponseCode.toSuccess(productList);
    }

    @Override
    public ResponseCode toType(String id) {
        //非空判断
        if(id==null||"".equals(id)){
            return ResponseCode.toDefeated("参数非法！");
        }
        int i = Integer.parseInt(id);
        Product p=productDao.selectById(i);
        if(p==null){
            return ResponseCode.toDefeated("商品不存在！");
        }
        int i2=productDao.updateById(i);
        if(i2<0){
            return ResponseCode.toDefeated("下架失败！");
        }
        return ResponseCode.toSuccess(i2);
    }

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

}
