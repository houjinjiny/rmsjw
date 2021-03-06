package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Product;
import com.itdr.pojo.Users;
import com.itdr.service.ProductService;
import com.itdr.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/backed/product/*")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    private ProductService productService = new ProductServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");

        switch (split[split.length - 1]){
            case "getall":
                getAllProduct(request,response);
                break;
            case "totype":
                toType(request,response);
                break;
            case "uptype":
                upType(request,response);
                break;
            case "fuzzysearch":
                fuzzySearch(request,response);
                break;
            case "addproduct":
                addProduct(request,response);
                break;
        }
    }

    //获取所有商品数据
    private void getAllProduct(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        ResponseCode allProduct = productService.getAllProduct();
        request.setAttribute("plist",allProduct);
        request.getRequestDispatcher("/WEB-INF/plist.jsp").forward(request,response);
    }
    //商品下架
    private void toType(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String id=request.getParameter("id");
        ResponseCode allProduct = productService.toType(id);
        response.getWriter().write(allProduct.getData().toString());
    }
    //商品上架
    private void upType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        ResponseCode allproduct=productService.upType(id);
        response.getWriter().write(allproduct.getData().toString());
    }
    //模糊查询
    private void fuzzySearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key=request.getParameter("key");
        ResponseCode allProduct=productService.fuzzySearch(key);
        request.setAttribute("plist",allProduct);
        request.getRequestDispatcher("/WEB-INF/plist.jsp").forward(request,response);
    }
    //添加
    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pname=request.getParameter("pname");
        String price=request.getParameter("price");
        String pnum=request.getParameter("pnum");
        ResponseCode allproduct=productService.addProduct(pname,price,pnum);
        ResponseCode allProduct = productService.getAllProduct();
        request.setAttribute("plist",allProduct);
        request.getRequestDispatcher("/WEB-INF/plist.jsp").forward(request,response);
    }
}
