<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成绩</title>
    <!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="./themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./locale/easyui-lang-zh_CN.js"></script>
  </head>
  <body>
    
<div id="outline" style="border:rosybrown double;margin: 0% 6% 0% 0%;background-color: #C6E2FF;" >
	

	
		<div style="margin: 2% 1% 2% 0%;">
			
		<div class="center">

<c:choose>
<c:when test="${sessionScope.valueStringList==null||sessionScope.valueStringList==''}">
请先测试
</c:when>
<c:otherwise>

<%-- <p> --------您的选项为:
<c:forEach var="valueStringList" items="${sessionScope.valueStringList}"  varStatus="go">
${go.count}.
${valueStringList}
</c:forEach></p>  --%>

<p> --------测试用户:${sessionScope.user.user_name}（账号：${sessionScope.user.user_id}）
<p> --------正确答案为:
<c:forEach var="valueStringList" items="${sessionScope.listanswer}"  varStatus="go">
${go.count}.
${valueStringList}
</c:forEach>
</p> 
 <p >--------测试得分为：<span style="color: red;font-size:25px;"><strong>${sessionScope.testscore}</strong></span>
&nbsp;&nbsp;&nbsp;&nbsp;</p>
 <hr/>  
  
<p >--------重新测试： <span><a href="t_testList.action">点击重新测试&nbsp;》》</a></span></p>
 
  <hr/>  
 <p>--------查看解释：<a href="explain.jsp">点击查看解释&nbsp;》》</a></p>
 

	
 
    <hr/> 
</c:otherwise>
</c:choose>

	
 

	</body>

</html>