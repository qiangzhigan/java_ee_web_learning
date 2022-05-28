package cn.gan;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo")
public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取mime文件类型
        ServletContext context = this.getServletContext();
        String filename="a.jpg";
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);
        //域对象：共享数据，范围，共享所有用户的数据
        context.setAttribute("name","ganzhiqiang");
        context.setAttribute("age",12);
        //获取服务器路径
        String realPath = context.getRealPath("/b.txt");  //web目录下资源访问
        File file=new File(realPath);
    }
}
