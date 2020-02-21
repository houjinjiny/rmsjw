package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.CustomerService;
import com.itdr.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/backed/customer/*")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService=new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");
        switch (split[split.length-1]){
            case "getAll":
                getAllCustomer(request,response);
                break;
            case "fuzzysearch":
                fuzzySearch(request,response);
                break;
            case "getnormal":
                getNormal(request,response);
                break;
            case "getgold":
                getGold(request,response);
                break;
            case "uptype":
                upType(request,response);
                break;
            case "downtype":
                downType(request,response);
                break;
        }

    }

    //查询所有的用户
    private void getAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode allCustomer=customerService.getAllCustomer();
        request.setAttribute("customerlist",allCustomer);
        getNum(request,response);
    }
    //根据用户身份证号查询
    private void fuzzySearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key=request.getParameter("key");
        ResponseCode allCustomer=customerService.selectByidnamber(key);
        request.setAttribute("customerlist",allCustomer);
        request.getRequestDispatcher("/WEB-INF/customer.jsp").forward(request,response);
    }
    //查询普通用户
    private void getNormal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ResponseCode allCustomer=customerService.getAllNormalCustomer();
    request.setAttribute("customerlist",allCustomer);
    getNum(request,response);
}
    //查找会员
    private void getGold(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ResponseCode allCustomer=customerService.getAllGoldCustomer();
    request.setAttribute("customerlist",allCustomer);
    getNum(request,response);
}
    //升级
    private void upType(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String i=request.getParameter("key");
        String num=request.getParameter("ty");
        ResponseCode i2=customerService.upType(i,num);
        response.getWriter().write(i2.getData().toString());
}
    //降级
    private void downType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String i=request.getParameter("key");
        String num=request.getParameter("ty");
        ResponseCode i2=customerService.downType(i,num);
        response.getWriter().write(i2.getData().toString());
    }
    //数量
    public void getNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int c1=customerService.getC1();
        int c2=customerService.getC2();
        session.setAttribute("c1",c1);
        session.setAttribute("c2",c2);
        request.getRequestDispatcher("/WEB-INF/customer.jsp").forward(request,response);
    }
}
