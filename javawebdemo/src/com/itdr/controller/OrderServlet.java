package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.OrderService;
import com.itdr.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            case "gethuo":
                getHuo(request,response);
                break;
            case "daifh":
                daifah(request,response);
                break;
            case "daisk":
                daisk(request,response);
                break;
            case "daish":
                daish(request,response);
                break;
            case "daifk":
                daifk(request,response);
                break;


        }
    }



    //发货
    private void getHuo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode allOrder=orderService.getHuo();
        request.setAttribute("olist",allOrder);
        request.getRequestDispatcher("/WEB-INF/huowu.jsp").forward(request,response);
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
    //数量
    public void getNum(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //待发货
        int i1=orderService.getNum1();
        //待收款
        int i2=orderService.getNum2();
        //待收货
        int i3=orderService.getNum3();
        //待付款
        int i4=orderService.getNum4();
        //全部订单
        int i5=orderService.getNum5();
        //已完成订单
        int i6=orderService.getNum6();
        session.setAttribute("i1",i1);
        session.setAttribute("i2",i2);
        session.setAttribute("i3",i3);
        session.setAttribute("i4",i4);
        session.setAttribute("i5",i5);
        session.setAttribute("i6",i6);
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
    }
    // 待发货
    private void daifah(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode allOrder=orderService.daifah();
        request.setAttribute("olist",allOrder);
        request.getRequestDispatcher("/WEB-INF/huowu.jsp").forward(request,response);
    }
    //代收款
    private void daisk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode allOrder=orderService.daisk();
        request.setAttribute("olist",allOrder);
        request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request,response);
    }
    // 待收货
    private void daish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode allOrder=orderService.daifsh();
        request.setAttribute("olist",allOrder);
        request.getRequestDispatcher("/WEB-INF/huowu.jsp").forward(request,response);
    }
    // 待收货
    private void daifk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode allOrder=orderService.daifk();
        request.setAttribute("olist",allOrder);
        request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request,response);
    }
}
