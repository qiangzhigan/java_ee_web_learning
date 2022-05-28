# Javaweb

## web 相关概念

- 软件架构

​			c/s:客户端、服务器端

​			b/s：浏览器、服务器端--》通过域名访问，客户端0维护

- 资源分类

  ![image-20220524052655059](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205240526607.png)

  静态资源：所有用户看到的，得到的结果是一样的,静态资源可以被浏览器直接解析

  * 如：html,css,javascript

  动态资源：用户不同，访问到的结果因用户不一样，动态资源需要绚烂后转换成静态资源，在返回给浏览器

  * servlet/jsp,php

- 网络通信三要素

​		ip:服务器的ip的地址，电子设备在网上的唯一标识

​		端口：服务器上的软件，应用程序（0-65536，不要占用1024之内）

​		传输协议：规定数据通信的规则，数据传输的规则，tcp安全协议，udp非安全协议

## tomcat web服务器软件

定义：**==服务器安装了服务器软件的计算机==**

服务器软件：接受用户的请求、处理请求、做出响应

web服务器软件：用户通过浏览器实现访问这些web项目

javaee:java 企业版，java 语言在企业级开发中使用的技术规范总和

------

### tomcat 安装、配置、启动

#### 一、目录结构

![image-20220524055013543](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205240550058.png)

* bin: 可执行文件

​		.sh:linux  .exe:win

* conf:配置文件
* :ear:lib: 依赖jar包
* webapps:存放web项目的
* logs:日志文件
* temps:临时文件
* work:运行时环境



启动程序：startup.bat  startuo.sh

#### 二、项目部署

1. 直接将项目放入到webapps下面

   项目的访问路劲：虚拟目录

2. 将多个项目打包成.war包部署到webapps，自动解压缩。之后删除直接删除war包

   

### 将tomcat集成到idea中

![image-20220524195452983](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205241954735.png)

## servlet

概念：server applet：运行在服务端的小程序

servlet就是一个接口，定义了java类被tomcat识别,定义的类实现servlet接口

:smile: :cat: :heart: 

🎆🥼🥽🦺🕶👓👔👕🛒🎡🧧🎃🎊💂‍♀️💂‍♂️👷‍♀️👷‍♂️✝☸💦💖🖤💙💚💛🧡❤

1. 实现一个servlet的实现类，在service方法中实现方法

​		![image-20220524201940331](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205242019156.png)

1. 在web中配置类与路劲的映射关系

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <!--    配置servlet-->
    <servlet>
        <servlet-name>demo01</servlet-name>
        <servlet-class>cn.gan.day1</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>demo01</servlet-name>
        <url-pattern>/demo01</url-pattern>
    </servlet-mapping>
</web-app>
~~~

注意：@webservlet("/url")---servlet3.0直接通过注解的方式弄个映射关系

![image-20220524211530516](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205242115493.png)

### servlet 的执行原理

* 当服务器接受到客户端浏览器的请求后，会解析请求url路径，获取访问的servlet的资源路径
* 查找web.xml文件，是否有对应的<url-pattern>标签体内容
* 如果有，则找到对应的<servlet-class>全类名
* tomcat会将字节码文件加载进内存，并且创建其对象
* 调用方法

### servlet的生命周期

---

servlet创建时init只执行一次，单列模式

servlet销毁时destory只执行一次：只有服务器正常关闭时才执行destory

会出现线程安全问题：尽量不要在servlet中定义成员变量，或者不修改成员变量

### servlet 体系结构

genericServlet 抽象类

httpServlet 抽象类--帮我们处理好方式处理

![image-20220525103636326](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205251036209.png)

* 定义类继承httpservlet

* 复写doGet,doPost方法

  ![image-20220525104030990](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205251040295.png)

### servlet相关配置

1. urlpatterns:访问路径；路径的定义规则/*最后匹配

## HTTP

概念：超文本传输协议（hyper text transfer protocol）

定义了客户端、服务器端通信时发送数据的格式

特点：基于tcp/ip的高级协议

​			默认端口号：80

​			基于请求、响应模型

​			无状态：每次请求之间相互独立，不能交互数据

---

### 规定的数据格式

***请求消息数据格式***（request）

1.请求行

请求方式 请求url 请求协议、版本

get  /login.html http1.1

2.请求头

请求头： 值，值

**user-agent:**浏览器告诉服务器，访问使用的浏览器版本信息

​	解决浏览器的兼容性问题，不一样的浏览器显示不一样的代码

**referer:**告诉服务器，当前请求从哪里来到哪里去，防盗链，统计人数

**connection:keep-alive**(连接可以被复用)

3.请求空行

空行：分割请求头和请求体

4.请求体

get 方式没有请求体的，post 中有请求参数

get:请求参数在请求行中（url)之后；请求的url长度是有限制的；不安全

post:请求参数在请求体中；请求的url长度是没有限制的；安全

## Request

定义：请求消息数据

### request原理

tomcat服务器会创建request和response对象，request对象中封装请求消息数据。

并将这两个对象传递给service方法，并且调用service方法。

通过response对象设置响应消息数据。

服务器在给浏览器做出响应之前，会从response对象中设置的响应消息体中数据放入响应体中

<font color='green'>org.apache.catalina.connector.RequestFacade@62ad0f4e</font>

request 的功能：

1获取请求消息数据

1. 获取请求行

​		![image-20220525162109755](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205251621741.png)

1. 获取请求头

~~~java
  String ip=req.getRemoteAddr();
        //获取请求头的所有名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value=req.getHeader(name);
            System.out.println(value);
        }
~~~



1. 获取请求体

   * 请求体：只有post才有请求体

   * 步骤：

     1、获取流对象

     ~~~java
     BufferedReader reader = req.getReader();//字符流
     ServletInputStream inputStream = req.getInputStream();//字节流，所有数据类型
     ~~~

     2、再从流对象中拿数据

2其他功能

* 获取请求参数通用方式

  getParameter(String name):根据参数名称获取参数值

   String[] getParameterValues(String):根据参数名称获取参数值的数组

  getParameterNames():获取所有参数名称

    Map<String,String[]> getParameterMap():所有键值对

  请求参数常见问题

  ![image-20220528162921116](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205281629497.png)

* request --中文乱码（**post**）==其中get方式不会乱码==

--如何解决

~~~java
//再根据参数获取值之前，设置流的字符集
 req.setCharacterEncoding("UTF-8");
~~~

### request 请求与转发

定义：一种在服务器中内部资源跳转的方式

步骤：

  1. 通过request对象获取请求转发器对象

     首先创建页面

     ![image-20220526083450237](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205260834467.png)

     表单提交到ServletDemo03中

     ![image-20220526083745507](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205260837330.png)

     对于资源ServletDemo03，进行了请求与转发，转发到ServletDemo04

     ![image-20220526084216749](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205260842600.png)

     注意：此时浏览器仍然显示的是ServletDemo03的url地址，getRequestDispatcher()是服务器内部资源转发

     #### 问题：⭐多次请求转发到不同页面报错的问题

     ![image-20220526091518353](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205260915484.png)

     报错地方

     ![image-20220526091614648](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205260916492.png)

     首先排除之后的不能执行的事务（除**request response**之外）

     ![image-20220526091850658](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205260918153.png)

     结果正常：

     ![image-20220526091948846](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205260919357.png)

     ![image-20220526093404360](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205260934828.png)

     resp能够被打印，正常同理req也能被打印

     ![image-20220526093914200](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205260939605.png)

     请求转发，只需要一个req和resp，多个资源的请求转发会报错

  2. 特点：

### request 数据共享

产生背景：解决需求---tomcat资源内部共享数据

* 域对象：一个有作用范围的对象，可以在范围内共享数据
* request域：**==一次请求的范围，一般用于请求转发的多个资源中共享数据==**
* 方法：
  * setAttribute(String name,Object obj):存储数据
  * getAttribute(String name);//返回的是object
  * removeAttribute(String name):通过键值对移除对象

## Response

响应消息：服务器端发送给客户端的数据

* 数据格式：

​        

|          |                                    |
| :------: | :--------------------------------: |
|  响应行  |  HTTP/2.0 200 OK（协议，状态，ok)  |
|  响应头  | 设计内容如何展示：头的名称：头的值 |
| 响应空行 |             分隔头和体             |
|  响应体  |            响应html页面            |

**状态码**：告诉客户端浏览器本次请求和响应的一个状态

<font color='blue'>分类：</font>

1. 1xx:服务器接受客户端消息，但没有接受完成，等待一段时间后，发送1XX
2. 2XX:成功 代表200 
3. 3xx：重定向。代表：302重定向，304（访问本地缓存）

![重定向](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205261114542.png)



1. 4XX：客户端错误，客户端请求路径错误，没有对应的资源（404）；405：请求方式没有对应的方法
2. 5XX:服务端错误，服务器端异常

### response 重定向

**response设置**

使用步骤：1. 获取输出流

   					2. 使用输出流，打印到客户端浏览器中

案列：1. 完成重定向

   2. 服务器输出字符数据到浏览器

   3. 服务器输出字节数据到浏览器

      *验证码小案例

重定向代码：

~~~java
@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo01被访问到了");
        resp.setStatus(302);
        resp.setHeader("location","/java_ee_web_learning_war_exploded/responseDemo02");//从根路径开始
    }
}
//重定向之后代码
@WebServlet("/responseDemo02")
public class ResponseDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo02被访问到了");
    }
}

~~~

**或者使用**

~~~java
resp.sendRedirect("/java_ee_web_learning_war_exploded/responseDemo02");
~~~

***重定向的特点***：两次请求；地址栏发生改变；转发可以访问其他服务器的资源--》不能使用request共享数据

**路径的写法**：

 * 路径的分类：相对路径和绝对路径
 * 绝对路径：可以使用路径可以确定唯一资源，以斜杠路径开头/项目名称/资源

​	规则：/开头  给服务器内部使用不需要加虚拟目录 给浏览器使用需要加虚拟目录

 * 相对路径：相对位置的关系，不以斜杠开头，./:表示当前路径

   列如：./response=response(./可以省略不写)

   ../上一级下有哪个

**服务器输出数据**

1.获取输出流

2.输出数据

![image-20220526185010812](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205261850779.png)

![image-20220526185049892](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205261850874.png)

~~~java
@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo02被访问到了");
        //获取字符输出流
        resp.setCharacterEncoding("utf-8");
        //告诉浏览器设置编码
        resp.setHeader("content-type","text/html;charset=utf-8");
        //提供了简单的形式设置编码
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write("你好 response");

    }
~~~

输出字节数据：

![image-20220526191113857](https://raw.githubusercontent.com/qiangzhigan/PicGo/main/img/202205261911783.png)

### response验证码

验证码设计：图片

防止恶意表单注册

随机生成一张图片

~~~java
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
//验证码图片生成器
~~~

### servletContext

概念：代表整个web应用，可以和程序的容器来通信，和服务器进行通信

功能：

 * 获取MIME类型

   mime:在互联网通信过程中定义的一种文件数据类型

   ​		大类型、小类型     text/html     image/jpeg

   ​	getMimeType(String file);

 * 域对象：共享数据

 * 获取文件的真实路径

获取servletContext对象：request.getServletContext();this.getServletContext();//true

~~~java

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

~~~

## cookie&session

会话技术 ：客户端和服务器之间的资源进行会话（一次会话中包括多次请求和响应）

功能：在一次范围之内数据共享（解决http 无响应一次连接请求的数据共享）

### cookie(客户端会话技术，将数据存放在客户端)

cookie使用的步骤：

​		1.创建cookie对象，绑定数据

​		2.发送cookie对象

​		3.获取数据

注意：是一次浏览器和服务器端的会话连接，关闭连接请求或者关闭服务器则会话连接发生中断；更换其他浏览器或者服务器，会进行不同的会话连接

~~~java
@WebServlet("/CookieDemo02")
public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取cookie
        Cookie[]cookies=req.getCookies();
        if(cookies!=null){
            for(Cookie c:cookies){
                String name=c.getName();
                String value=c.getValue();
                System.out.println(name+":"+value);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
~~~

~~~java
WebServlet("/CookieDemo01")
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie对象
        Cookie c=new Cookie("msg","hello");
        //发送Cookie
        resp.addCookie(c);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
~~~

**会话技术cookie_原理分析实现**

浏览器接受服务器端的响应：set-cookie:msg=hello（类似于map中的键值对）

之后浏览器存储set-cookie中的内容，之后的请求会有一个请求头cookie:msg=hello请求过去

**cookie细节性处理**

	1. 可以创建多个cookie对象
	1. cookie的保存时间：默认：浏览器关闭时cookie信息销毁
	1. 持久化存储

​			setMaxAge(int seconds):正数：将cookie存放在硬盘中设置存活时间

​														：0：删除cookie

​														：负数默认浏览器关闭时cookie销毁

更改后持久后发生了cookie时间发生了改变

 1. cookie能否存中文

    在tomcat8之后支持中文数据

 2. cookie获取范围多大

    同一个服务器中不同项目默认情况下不能共享数据信息：解决方法：c.setPath("/"）代表可以共享

    不同的tomcat服务器间cookie共享问题

    * setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享
    * setDomain(".baidu.com")那么贴吧和新闻可以共享（**分布式数据共享**）

### session 服务端数据共享

同cookie，但一般session一个项目只有一个

req.getSession();

服务器如何确保session是一个：

seesion是依赖于cookie的，第一次获取session，没有cookie会在内存中创建一个新的Session对象

jsessionid=9877889

**session  细节**:

客户端关闭后，两次获取session是否同一个----不同一个

客户端不关闭，服务端关闭，两次session是一个吗------不相同，但是确保数据不丢失

引发的问题：服务器重启--数据丢失--

​		session的钝化：

​			在服务器正常关闭之前，将session对象系列到硬盘上；重启之后会反序列化

session默认失效时间：30分钟,session.invalided()//自动杀除

## Filter 过滤器

*  生活中的过滤器🌭：拦截请求，完成一下特殊功能

* 登人验证；同一编码设置；敏感字符设置

* 过滤器快速入门

  定义一个类、实现接口filter

  复写方法

  拦截路劲

  生命流程：先初始化filter 再初始化servlet类，先销毁serclvlet,再销毁filter

多个过滤器执行顺序：按照字符名称大小，小的先执行

