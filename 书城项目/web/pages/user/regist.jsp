<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>天庭会员注册页面</title>

    <%--  静态包含 base标签 css 样式，JQuery文件  --%>
    <%@ include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        //页面完成之后
        $(function () {

            $(function(){
                $("#username").blur(function(){
                    //1. 获取用户名
                    var username = this.value;

                    $.getJSON("http://localhost:8080/book/UserServlet","action=ajaxExistsUsername&username=" + username,function (data){

                        if(data.existsUsername){
                            $("span.errorMsg").text("用户名已存在");
                        }else{
                            $("span.errorMsg").text("用户名可用");
                        }
                    });


                })
            });

            //给验证码的图片绑定的单击事件
            $("#code_img").click(function(){
                //在事件响应时的function函数中有一个this对象。这个this对象，是当前正在响应事件的dom对象
                //src属性表示验证码img标签的图片路径。它可读，可写
                this.src = "${basePath}Kaptcha.jpg?d=" + new Date();
            });


            //给注册绑定单击事件
            $("#sub_btn").click(function () {
                //验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                //1.获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2.创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3.使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4.提示用户结果
                    $("span.errorMsg").text("用户名不合法！");
                    return false;
                }


                //验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                var passwordText = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;
                if (!passwordPatt.test(passwordText)) {
                    $("span.errorMsg").text("密码不合法");
                    return false;
                }
                //验证确认密码；和密码相同、
                var passwordcheck = $("#repwd").val();
                if (passwordText != passwordcheck) {
                    $("span.errorMsg").text("两次密码输入不一致");
                    return false;
                }
                //邮箱确认：xxxxx@xxx.com
                //1. 获取邮箱里的内容
                var emailText = $("#email").val();
                //2. 创建正则表达式对象
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //3. 使用test方法验证是否合法
                if (!emailPatt.test(emailText)) {
                    //4. 提示用户
                    $("span.errorMsg").text("邮箱不合法");
                    return false;
                }

                //验证码：现在只需要验证用户已输入，因为还没讲到服务器，验证码生成。
                var checkCode = $("#code").val();

                //去掉验证码的前后空格
                checkCode = $.trim(checkCode);

                if (checkCode == null || checkCode == "") {
                    $("span.errorMsg").text("验证码不能为空");
                    return false;
                }

                $("span.errorMsg").text("");
            });
        });


    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册天庭会员</h1>
                    <span class="errorMsg">
<%--                        <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="UserServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
<%--                               value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
                               value="${requestScope.username}"
                        />
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
<%--                               value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"--%>
                                value="${requestScope.email}"
                               name="email" id="email"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 120px;" name="code" id="code"/>
                        <img id="code_img" alt="" src="Kaptcha.jpg" style="float: right; margin-right: 40px;width:110px;height:30px;">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%--静态包含页脚内容--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>