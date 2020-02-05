package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.OrderService;
import com.itdr.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backed/order/*")
public class OrderServlet extends HttpServlet {
    private OrderService orderService=new OrderServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestUrl=request.getRequestURI();
        String[] split=requestUrl.split("/");
        switch (split[split.length-1]){
            case "getall":
                getAll(request,response);
                break;
            case "fuzzysearch":
                fuzzySearch(request,response);
                break;
            case "getreturn":
                String key="已退货";
                getSearch(request,response,key);
                break;
            case "getwait":
                String key2="待";
                getSearch(request,response,key2);
                break;
            case "getdelivery":
                String key3="已发货";
                getSearch(request,response,key3);
                break;
        }
    }
    //查询订单
    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode allOrder=orderService.getAll();
        request.setAttribute("olist",allOrder);
        request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request,response);
    }
    //模糊查询
    private void fuzzySearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key=request.getParameter("key");
        ResponseCode allOrder=orderService.selectByNum(key);
        request.setAttribute("olist",allOrder);
        request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request,response);
    }
    //退货订单
    private void getSearch(HttpServletRequest request, HttpServletResponse response, String key) throws ServletException, IOException {
        ResponseCode allOrder=orderService.selectByState(key);
        request.setAttribute("olist",allOrder);
        request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request,response);
    }

}
