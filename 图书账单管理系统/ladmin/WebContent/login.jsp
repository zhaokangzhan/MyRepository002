<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 图书账单管理系统</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>图书账单管理系统</h1>
        </header>
        <section class="loginCont">
            <form class="loginForm" action="LoginServlet">
                <div class="inputbox">
                    <label for="user">用户名：</label>
                    <input id="user" type="text" name="username" placeholder="请输入用户名" required/>
                </div>
                <div class="inputbox">
                    <label for="mima">密码：</label>
                    <input id="mima" type="password" name="password" placeholder="请输入密码" required/>
                </div>
                
                
                 <div class="inputboxcheck">
                    <label >验证码：</label>
                    <input id="check" type="text" name="check_code" placeholder="请输入验证码" required />
                    <img src="/ladmin/CheckServlet" >
                </div>
                
                
            
                
                <div class="subBtn">              
                     <input type="submit" value="登录" />
                    <input type="reset" value="重置"/>
                    <a href="newregister.jsp" style="background-image: url('login_bg.jpg');"><img src="img/yh.png" alt="注册" title="注册"/></a>
                </div>

            </form>
        </section>
    </section>

</body>
</html>