package cn.gan;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/ServletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //tring staus=req.
        System.out.println(req);
        //获取请求方式
        String method = req.getMethod();
        //获取虚拟目录
        String contextPath = req.getContextPath();
        //获取servlet路劲
        String servletPath = req.getServletPath();
        //获取get方式的请求参数
        String queryString = req.getQueryString();
        //获取url
        StringBuffer requestURL = req.getRequestURL();
        //获取协议
        String protocol=req.getProtocol();
        //获取客户机ip
        String ip=req.getRemoteAddr();
        //获取请求头的所有名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value=req.getHeader(name);
            System.out.println(value);
        }
        BufferedReader reader = req.getReader();
        ServletInputStream inputStream = req.getInputStream();


        System.out.println("doget....");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost....");
    }
}
