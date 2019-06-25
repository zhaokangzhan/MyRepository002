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
        <h1>图书管理账单管理系统</h1>
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
                <span>用户管理页面</span>
            </div>
            <div class="search">
                <span>用户名：</span>
                <input type="text" placeholder="请输入用户名"/>
                <input type="button" value="查询"/>
                 <a href="#">查看日志</a>
                <a href="userAdd.jsp">添加用户</a>
              
     </div>
            <!--用户-->
            <table  class="providerTable" cellpadding="0" cellspacing="0" id="exportToExcel">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>                   
                    <th width="10%">密&nbsp;&nbsp;&nbsp;码</th>
                    <th width="10%">联系方式</th>
                    <th width="10%">电子邮箱</th>
                    <th width="30%">操&nbsp;&nbsp;作</th>
                </tr>
               
             
                <c:forEach var="name" items="${allusers }" begin="${start }" end="${over }">
	<tr >
	<td>${name.id}</td>
	<td>${name.username}</td>
	<td>${name.password}</td>
	<td>${name.phonenumber}</td>
	<td>${name.email}</td>
	<td>
	<a href="#" class="removeUser"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="UserServlet?method=4&id=${name.id}" ><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="UserServlet?method=3&id=${name.id }" ><img src="img/schu.png" alt="删除" title="删除"/></a>
                        </td>
	</tr>
	</c:forEach>  
                
            </table>
     <p></p>
	<table align="center" class="myselect">
	<tr align="center">
	<td align="center">共有${maxPage }页&nbsp;</td><td align="center">共有${recordCount }条记录&nbsp;</td>
	<td align="center">当前为${number }第页&nbsp;</td>
	<td align="center">	
	<c:choose>
	   <c:when test="${number>1 }">
	  <a href="UserServlet?method=1&i=${number-1}">上一页</a>&nbsp;</td>
	  </c:when>
	   <c:otherwise>
	      上一页&nbsp;
	  </c:otherwise>
	</c:choose>
	</td>
	<td>
	<c:choose>
	   <c:when test="${number<maxPage }">
	  <a href="UserServlet?method=1&i=${number+1}">下一页</a>&nbsp;</td>
	  </c:when>
	   <c:otherwise>
	      下一页&nbsp;
	  </c:otherwise>
	</c:choose>

	</tr>
	
	</table> 
        </div>
    </section>
  
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要查看该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>