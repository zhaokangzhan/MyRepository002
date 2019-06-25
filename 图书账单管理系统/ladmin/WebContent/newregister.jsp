<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ page import="com.web.MySessionListener"%>
       <%@ page import="java.util.ArrayList"%>
          <%@ page import="com.domain.User"%>
   <%@ page import="com.dao.UsersDao"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>图书账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>本页面只供参考，完成注册，成功登陆才可有效使用本系统！</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span> 图书账单管理系统</span> &nbsp;&nbsp;欢迎你！</p>
        <a href="index.jsp">首页</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
           <ul class="list">
                    <li id="active"><a href="#">账单管理</a></li>
                    <li><a href="#">供应商管理</a></li>
                    <li><a href="#">用户管理</a></li>
                    <li><a href="billView">文件管理</a></li>
                    <li><a href="LogoutServlet">退出系统</a></li>
                </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>新用户页面 >> 新用户注册页面</span>
        </div>
        <div class="providerAdd">
            <form action="/ladmin/UserServlet?method=6" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                
                <div>
                    <label for="username">用户名称：</label>
                    <input type="text" name="username" id="username"/>
                    <span >*请输入用户名称</span>
                </div>
                <div>
                    <label for="userpassword">用户密码：</label>
                    <input type="text" name="password" id="userpassword"/>
                    <span>*密码长度必须大于6位小于20位</span>

                </div>
                <div>
                    <label for="userRemi">确认密码：</label>
                    <input type="text" name="userRemi" id="userRemi"/>
                    <span>*请输入确认密码</span>
                </div>
              
                <div>
                    <label for="phonenumber">用户电话：</label>
                    <input type="text" name="phonenumber" id="phonenumber"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="email">电子邮箱：</label>
                    <input type="text" name="email" id="email"/>
                    <span>*注意格式@163/129/qq.com</span>
                </div>
                <div>
                    <label for=" check_code">随机码：</label>
                    <input type="text" name="check_code" id="check_code" placeholder="请输入右边随机字符编码"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="/ladmin/CheckServlet">
                </div>             
                <div>
                    <label >用户类别：</label>
                    <input type="radio" name="userlei"/>管理员
                    <input type="radio" name="userlei"/>经理
                    <input type="radio" name="userlei"/>普通用户
                      <input type="radio" name="userlei"/>超级管理员
                </div>
                
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="submit" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                      
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
<hr />
<p align="center">用户反馈&nbsp;|||&nbsp;客服&nbsp;&nbsp;QQ:3543338298&nbsp;|||&nbsp;微信:asdfzhan&nbsp;|||&nbsp;电话号码:14354619562&nbsp;|||&nbsp;<a href="#" target="_blank">其它帮助</a></p>

<p>更多图书管理：<a href="#" target="_blank">图书管理之家</a></p>
</footer>
<script src="js/time.js"></script>

</body>
</html>