<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
  </head>
  <body>
    
<div id="outline" style="border:rosybrown double;margin: 0% 6% 0% 6%;background-color: #D3D4D4;">
	

  	<!--logo部分-->
		

		<!--导航栏-->
		<div class="container" style="margin-top: 5px;">
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
					  
					<a class="navbar-brand" href="index.jsp">《&nbsp;返回首页</a>
				<li>
						
					</div>

					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						
						<ul class="nav navbar-nav">
				<li>
						<li>
								<a href="login.jsp">《&nbsp;返回登录</a>
							</li>
					
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" 
								role="button" aria-haspopup="true" aria-expanded="false">其它注册方式 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									
									<li role="separator" class="divider"></li>
									<li>
										<a href="#">微博</a>
									</li>
									<li role="separator" class="divider"></li>
									<li>
										<a href="#">微信</a>
									</li>
									<li role="separator" class="divider"></li>
									<li>
								  <a href="#">Q&nbsp;Q</a>
							    </li>
							    
							    
								</ul>
							</li>
						</ul>
						
					</div>
				</div>
			</nav>
		</div>
		
		<!--注册-->
	
		<div class="container" style="margin-top: 5px;">
		<form action="/MiddleSchoolWebsite/Student_userServlet?method=8"  method="post" name="form" onSubmit="return check()" >
<table width="270" class="table">
<tr>
  <td><strong>学号:</strong></td><td ><input type="text" name="unique_id"  required placeholder="请输入你的学号"></td></tr>
<tr>
<tr>
  <td><strong>姓名:</strong></td><td><input type="text" name="name" placeholder="请输入你的姓名" required></td></tr>
<tr>
  <td><strong>密码:</strong></td><td><input type="password" name="password" required  placeholder="请输入你的密码"></td></tr>

 <tr height="35"><td width="15%" ><strong>性别:</strong></td><td class="tdclass" width="35%">
  &nbsp;&nbsp; &nbsp;<label ><input type="radio" name="msex" value="1"  />男
                  &nbsp;&nbsp; &nbsp;&nbsp;  <input type="radio" value="0" name="msex" />女</label>
	 
	 </td><td><span >*</span></td></tr>    
 <tr>
  <td><strong>身份号:</strong></td><td><input type="text" name="idcard" required placeholder="请输入你的身份证号"></td></tr> 
<tr>
  <td><strong>目标:</strong></td>
  <td><label for="studyneed"></label>
    <select name="studyneed" id="studyneed">
     <option><strong>请&nbsp;选&nbsp;择&nbsp;个&nbsp;人&nbsp;目&nbsp;标</strong></option>
    <option>2019&nbsp;年&nbsp;6&nbsp;月&nbsp;高&nbsp;考&nbsp;级</option>
    <option>2019&nbsp;年&nbsp;6&nbsp;月&nbsp;中&nbsp;考&nbsp;级</option>
       <option>2020&nbsp;年&nbsp;6&nbsp;月&nbsp;中&nbsp;考&nbsp;级</option>     
        <option>2020&nbsp;年&nbsp;6&nbsp;月&nbsp;中&nbsp;考&nbsp;级</option>
    </select></td></tr>
<tr>
  <td><strong>手机号:</strong></td><td><input type="text" name="phonenumber" ></td></tr>
<tr>    
  <td colspan="2" rowspan="6"><br /> 
   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
  <input name="sub" type="reset" value="&nbsp;清 &nbsp;&nbsp;空&nbsp;">
  
     &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<input name="sub" type="submit" value="&nbsp;注 &nbsp;&nbsp;册&nbsp;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
     <hr/> </td></tr>
</table>
</form>
		</div>
		
		
		
    	
				
			</div>
		</div>
		
    	
	
		<!--友情链接和版权信息-->
		<div class="container" style="margin-top: 10px;">
			<div class="row">
				<div class="" align="center">
					<ul class="list-inline">
						<li><a href="info.html">关于我们</a></li>
						<li><a>联系我们</a></li>
						<li><a>招贤纳士</a></li>
						<li><a>法律声明</a></li>
						<li><a>友情链接</a></li>
						<li><a>支付方式</a></li>
						<li><a>配送方式</a></li>
						<li><a>服务声明</a></li>
						<li><a>广告声明</a></li>
						<li><a>加入我们</a></li>
					</ul>
					<ul class="list-inline">
						<li><p align="center">用户反馈&nbsp;|||&nbsp;客服&nbsp;&nbsp;QQ:3543338298&nbsp;|||&nbsp;
	微信:asdfzhan&nbsp;|||&nbsp;电话号码:14354619562&nbsp;|||&nbsp;其它帮助 &nbsp;&nbsp; 
	 &nbsp;&nbsp;<a href="fabu.php"><strong>后台管理&gt;&gt;<strong></a>	</p></li>
						
					</ul>
					
				</div>
				
				<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
				
				</div>
			</div>
		</div>
		
	

		</div>
	</body>

</html>