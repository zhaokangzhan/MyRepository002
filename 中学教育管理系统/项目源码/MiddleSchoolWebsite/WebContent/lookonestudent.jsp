﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.web.TestRandomServlet"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>中学网</title>
    <!-- Bootstrap -->
  <link href="css/bootstrap.css" rel="stylesheet"/>
		<link href="css/bootstrap.min.css" rel="stylesheet"/>
		<script type="text/javascript" src="js/jquery-1.11.3.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<style type="text/css">
		.ordertdclass{
		hover:red;
		}
		.tdclass{
		text-align: center;
		}
		</style>
  </head>
  <body>
    
<div id="outline" style="border:rosybrown double;margin: 0% 1% 0% 1%;background-color: #D3D4D4;" >
	
	
    <h2 align="center">学&nbsp;生&nbsp;具&nbsp;体&nbsp;信&nbsp;息</h2>

  
<table width="100%" border="1" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
	
	
	
	  <c:forEach var="name" items="${onestudent }" >
<tr height="35"><td width="10%" align="center">学号：</td><td class="tdclass">${name.unique_id}</td></tr>
<tr height="35"><td width="10%" align="center">姓名：</td><td class="tdclass">${name.name}</td></tr>
<tr height="35"><td width="10%" align="center">密码：</td><td class="tdclass">${name.password}</td></tr>
<tr height="35"><td width="10%" align="center">性别：</td><td class="tdclass">${name.sex==1?"男":"女"}</td></tr>
<tr height="35"><td width="10%" align="center">身份证号：</td><td class="tdclass">${name.idcard_number}</td></tr>
<tr height="35"><td width="10%" align="center">联系手机号：</td><td class="tdclass">${name.phonenumber}</td></tr>
		
	
	</c:forEach>  
	
	
</table>
  
           
<hr />	
	<table align="center" style="margin-bottom:2%;" border="1">
	<tr align="center" bgcolor="#EEEEEE" >
	<td align="center"><a href="Student_userServlet?method=1" target="admin_welcome">&nbsp;返回管理&nbsp;</a></td>
	<td align="center">
	<a href="#">
	     其它帮助&nbsp;
	</a>
	</td>
	
	<td align="center">	
	
	</td>
	
	  

	</tr>
	
	</table> 	
		
	</body>

</html>