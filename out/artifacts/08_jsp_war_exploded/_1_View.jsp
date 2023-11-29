<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/12
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page%>--%>
<%@page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         errorPage="/_1_View_Test.jsp"

         language="java" %>

<%-- errorPage表示错误后自动跳转去的路径
    这个路径一般都是以斜杠打头，它表示请求地址为http://ip:port/工程路径/
    映射到代码的web目录
--%>


<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>我为天帝，自当镇杀世间一切敌</h3>
<%--

 <%
     int x = 10 / 0;
 %>

--%>
<%--声明脚本--------------------------------------------------------------------------------------------%>
<%--  1.声明类属性  --%>
<%!
    private Integer id;
    private String name;
    private static Map<String, Object> map;
%>


<%-- 2.声明static静态代码块 --%>
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");
    }
%>

<%-- 3.声明类方法 --%>
<%!
    public void test1() {
        System.out.println("在jsp中声明方法");
    }

    public int test2() {
        return 0211;
    }

%>
<%-- 4.声明内部类 --%>
<%!
    public static class A {
        private int id = 1001;
        private String age = "16";
    }
%>


<%--表达式脚本--------------------------------------------------------------------------------------------%>

<%=16 %><br/>
<%=16.6 %><br/>
<%="我为天帝" %><br/>
<%="嗨嗨嗨" %><br/>
<%=map %><br/>

<%=test2()%>

<%--代码脚本--------------------------------------------------------------------------------------------%>

<%
    for (int i = 0; i <= 10; i++) {
        System.out.println(i);
    }
%>

<%
    String username = request.getParameter("username");
    System.out.println("用户名请求的参数值是：" + username);
%>

<%
    for (int i = 0; i < 10; i++) {
%>
<%= "组合i= " + i
%><br>
<%
    }
%>

<%
    int i = 1;
    if (i == 2) {
%>
    <h1> 仙王临九天</h1>

<%
    } else if (i == 1) {
%>
    <h3>海上升明月</h3>

<%
    }
%>


</body>
</html>
<%--
jsp头部的page命令（jsp的page指令可以修改jsp页面中一些重要的属性，或者行为）

    1.language属性        表示jsp翻译后都是什么语言文件。暂时只支持java
    2.contentype属性      表示jsp返回的数据类型是什么。也是源码中response.setContentType()参数值
    3.pageEncoding属性    表示当前jsp页面文件本身的字符集
    4.import属性          跟java源代码一样。用于导包，导类。
    -------------------------以下两个属性是给out输出流使用-----------------------------------------------
    5.autoFlush属性       设置当out输出流缓冲区满了以后，是否自动刷新缓冲区。默认值是true。
    6.buffer属性          设置out缓冲区的大小。默认是8kb
    （缓冲溢出错误：缓冲区满了之后不能自动刷新，就会自动报错）
    -------------------------以下两个属性是给out输出流使用-----------------------------------------------
    7.errorPage属性       设置当jsp页面运行出错时，自动跳转去的错误页面路径
    8.isErroePage属性     设置当前jsp页面是否是错误信息页面。默认是false，如果是true可以获取异常信息
                          （会在源文件中添加一条属性，并给该属性赋错误信息的值）
    9.session属性          设置访问当前jsp页面，是否会创建HttpSession对象。默认是true。
    10.extends属性         设置js翻译出来的java类默认继承谁。


jsp中的常用脚本

1.声明脚本：声明脚本的格式是：<%! 声明java代码 %>  （极少使用）
    作用：可以给jsp翻译出来的java类定义属性和方法甚至是静态代码块，内部类等

    声明属性
    声明static代码块
    声明类方法
    声明内部类

2.表达式脚本 （常用）
    表达式脚本的格式是：<%=表达式 %>
    表达式脚本的作用是：在jsp页面上输出数据。

   表达式脚本的特点：
        1.所有的表达式脚本都会被翻译到_jspService()方法中
        2.表达式脚本都会被翻译成为out.print()输出到页面上
        3.由于表达式脚本翻译的内容都在_jspService()方法中，所以_jspService()方法中的对象都可以直接使用。
        4.表达式脚本中的表达式不能以分号结束

    练习：
        1. 输出整型
        2. 输出浮点型
        3. 输出字符串
        4. 输出对象

3. 代码脚本
    代码脚本的格式是：
    <%
        java语句
    %>
    作用是：可以在jsp页面中，编写我们自己需要的功能（写的是java语句）
    特点：1.代码脚本翻译之后都在_jspService方法中
          2.代码脚本由于翻译到_jspService()方法中，所以在_jspService()方法中的现有对象都可以直接使用。
          3.还可以由多个代码脚本块组合成一个完整的java语句
          4.代码脚本还可以和表达式脚本一起组合使用，在jsp页面上输出数据

    练习：
        1.代码脚本——if语句
        2.代码脚本——for循环语句
        3.翻译后java文件中_jspServce方法内的代码都可以写



--%>

