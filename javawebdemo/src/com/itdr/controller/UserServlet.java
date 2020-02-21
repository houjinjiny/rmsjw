package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/backed/user/*")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    private UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");

        switch (split[split.length - 1]){
            case "login":
                login(request,response);
                break;
            case "getmsg":
                getMsg(request,response);
                break;
            case "changemesg":
                changemesg(request,response);
                break;
        }
    }



    //管理员登录
    private void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ResponseCode<Users> login = userService.login(username, password);
        if(login.getData()!=null){
            //登陆成功，保存用户信息
            HttpSession session=request.getSession();
            Users data=login.getData();
            session.setAttribute("us",data);
//            request.setAttribute("user",login);
            OrderServlet orderServlet=new OrderServlet();
            orderServlet.getNum(request,response);
        }else {
            request.getRequestDispatcher("/WEB-INF/noaccess.jsp").forward(request,response);
        }

    }
    //获取管理员信息
    private void getMsg(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/myself.jsp").forward(request,response);
    }
    private void changemesg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        Users u= (Users) session.getAttribute("us");
        String passO = request.getParameter("passO");
        String passN = request.getParameter("passN");
        ResponseCode i=userService.changemesg(u.getUsername(),passO,passN);
        response.getWriter().write(i.getData().toString());
    }
}
