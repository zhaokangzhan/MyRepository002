<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ page import="com.web.MySessionListener"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ page import="filter.NumberListener"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>图书账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>图书账单管理系统</h1>


    <div class="publicHeaderR">
    
        <p>
        当前访问本网站流量:<span style="color: #fff21b"><%=request.getAttribute("num") %></span>
         &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
        在线人数:<span style="color: #fff21b"><%=MySessionListener.num %></span>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<span>当前用户:</span><span style="color: #fff21b"> ${sessionScope.suser }</span> , 欢迎你！</p>
        &nbsp;&nbsp;<a href="LogoutServlet">退&nbsp;出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->

<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
             <ul class="list">
                    <li id="active"><a href="BookServlet?method=0">账单管理</a></li>
                    <li><a href="SupplierServlet?method=0">供应商管理</a></li>
                    <li><a href="UserServlet?method=1">用户管理</a></li>
                    <li><a href="billView.jsp">文件管理</a></li>
                    <li><a href="LogoutServlet">退出系统</a></li>
                </ul>
        </nav>
    </div>
    <div class="right">
        <img class="wColck" src="img/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>Admin</h2>
            <p>欢迎来到图书管理系统，您已登录，现可操作本系统!</p>
			<span id="hours"></span>
        </div>
    </div>
</section>
<footer class="footer">
<hr />
<p align="center">用户反馈&nbsp;|||&nbsp;客服&nbsp;&nbsp;QQ:3543338298&nbsp;|||&nbsp;微信:asdfzhan&nbsp;|||&nbsp;电话号码:14354619562&nbsp;|||&nbsp;<a href="#" target="_blank">其它帮助</a></p>

<p>更多图书管理：<a href="#" target="_blank">图书管理之家</a></p>
</footer>
<script src="js/time.js"></script>
<div style="text-align:center;">

</div>
</body>
</html>