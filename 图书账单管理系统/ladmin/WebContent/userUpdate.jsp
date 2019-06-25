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
   <title>图书账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <title>图书账单管理系统</title>

    <div class="publicHeaderR">
        <p><span>您好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
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
                    <li id="active"><a href="BookServlet?method=0">账单管理</a></li>
                    <li><a href="SupplierServlet?method=0">供应商管理</a></li>
                    <li><a href="UserServlet?method=1">用户管理</a></li>
                  <li><a href="billView.jsp">文件管理</a></li>
                    <li><a href="LogoutServlet">退出系统</a></li>
                </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="/ladmin/UserServlet?method=5&idd=${ruser.id }" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                
                <div>
                    <label for="userid">用户编号：</label>
                    <input type="text" name="userid" value="${ruser.id }" disabled="true"/>
                    <span >*用户编号不可修改</span>
                </div>
                <div>
                    <label for="username">用户名称：</label>
                    <input type="text" name="username" id="username" value="${ruser.username }"/>
                    <span >*请输入用户名称</span>
                </div>
                <div>
                    <label for="userpassword">用户密码：</label>
                    <input type="text" name="password" id="userpassword" value="${ruser.password }"/>
                    <span>*密码长度必须大于6位小于20位</span>

                </div>
               
              
                <div>
                    <label for="phonenumber">用户电话：</label>
                    <input type="text" name="phonenumber" id="phonenumber" value="${ruser.phonenumber }"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="email">电子邮箱：</label>
                    <input type="text" name="email" id="email" value="${ruser.email }"/>
                    <span>*注意格式@163/129/qq.com</span>
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
</footer>
<script src="js/time.js"></script>

</body>
</html>