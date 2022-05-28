package cn.gan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDemo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo03被访问到了");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("ServletDemo04");
        requestDispatcher.forward(req,resp);
        System.out.println(req);
//        RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("ServletDemo05");
//        requestDispatcher1.forward(req,resp);
        System.out.println(req.getParameter("username")+"====");
        System.out.println(resp);

    }
}
