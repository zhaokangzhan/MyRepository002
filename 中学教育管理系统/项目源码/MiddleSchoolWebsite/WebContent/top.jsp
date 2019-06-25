<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.domain.TestSelect"%>
<%@ page import="java.util.ArrayList"%>
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
  </head>
  <body>
    

	

  	<!--logo部分-->
		

		<!--导航栏-->
		<div  style="margin-top:3px;">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					    </button>
					  
					<a class="navbar-brand" href="index.jsp" target="_blank">《&nbsp;返回首页</a>
				<li>
						
					</div>

					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						
						<ul class="nav navbar-nav">
				<li>
								<a href="#">客户端</a>
							</li>
							<li>
								<a href="#">学生专区</a>
							</li>
							<li>
								<a href="#">教师专区</a>
							</li>
							<li>
								<a href="#">管理员专区</a>
							</li>
							
							
							
						</ul>
						
						<ul style="float: right;margin-right: 4%;margin-top: 10px;">
						 <li class="dropdown" style="float: left;">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                               <img src="img/touxiang.png" alt="用户头像">
                               <span class="username" style="font-size: 18px;">

          <strong><c:choose>
	   <c:when test="${sessionScope.username!=null }">
	${sessionScope.username }
	  </c:when>
	  <c:otherwise>
	 您未登录，请登录！
	  </c:otherwise>
	</c:choose>		</strong>

</span>
                               <b class="caret"></b>
                           </a>
                           <ul class="dropdown-menu extended logout">
                               <li><a href="#"><i class="icon-user"></i>我的资料</a></li>
                               <li><a href="#"><i class="icon-cog"></i>我的设置</a></li>
                               <li><a href="login.html"><i class="icon-key"></i>退出</a></li>
                           </ul>
                       </li>
						</ul>
					</div>
					
				</div>
				
			</nav>
		</div>
		
		<!--注册-->
	
		
	

	</body>

</html>