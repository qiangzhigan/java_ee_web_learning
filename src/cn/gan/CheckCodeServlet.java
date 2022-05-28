package cn.gan;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1.创建一个对象，在内存中代表一个图片
        int width=100;
        int height=50;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        Graphics g=image.getGraphics();//画笔对象
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,height);//填充颜色
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);//画边框
        g.drawString("A",20,25);//画数字
        g.setColor(Color.GREEN);
        g.drawLine(1,1,2,30);//画干扰线
        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
