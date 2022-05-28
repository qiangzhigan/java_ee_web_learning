package cn.gan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/ServletDemo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String line=null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        BufferedReader br = req.getReader();
//        String line=null;
//        while((line=br.readLine())!=null){
//            System.out.println(line);
//        }
        req.setCharacterEncoding("UTF-8");
        System.out.println(req);
        String username=req.getParameter("username");
        System.out.println(username);
        String username1=req.getParameter("username");
        System.out.println(username1);
    }
}
