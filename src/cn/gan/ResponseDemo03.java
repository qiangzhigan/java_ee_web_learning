package cn.gan;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo03")
public class ResponseDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo03被访问到了");
        //获取字符输出流
        resp.setCharacterEncoding("utf-8");
        //告诉浏览器设置编码
        resp.setHeader("content-type","text/html;charset=utf-8");
        //提供了简单的形式设置编码
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write("你好 response");
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write("你好".getBytes());
        System.out.println(req.getServletContext().getAttribute("age"));

    }
}
