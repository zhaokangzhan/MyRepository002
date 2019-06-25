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
    
<div id="outline" style="border:rosybrown double;margin: 0% 6% 0% 6%;background-color: #D3D4D4;" >
	

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
								<a href="#">客户端</a>
							</li>
							<li>
								<a href="#">学生专区</a>
							</li>
							<li>
								<a href="#">教师专区</a>
							</li>
							
							
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">管理中心 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									
									<li role="separator" class="divider"></li>
									<li>
										<a href="#">维护中心</a>
									</li>
									<li role="separator" class="divider"></li>
									<li>
										<a href="#">系统管理</a>
									</li>
									<li>
								  <a href="#">退出</a>
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
		<div style="margin: 5% 15% 10% 0%;">
			
		<div class="center">
  <form id="form1" name="form1" method="post" action="/MiddleSchoolWebsite/Student_userServlet?method=9" onSubmit="return check()">
    <table id="table" width="240" height="130" border="0">
      <tr>
        <td width="44"><strong>姓名:</strong></td>
        <td>
        <input type="text" name="username" id="username"  width="180" height="22" 
        placeholder="请输入你的姓名" required/></td>
      </tr>
      <tr>
        <td><strong>密码:</strong></td>
        <td><input type="text" name="password" id="password"  width="180" height="22" 
        placeholder="请输入你的密码" required/></td>
      </tr>
      <tr>
        <td colspan="2"><strong>类型:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong><label>
            <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_0" />
            <strong>用户</strong>
        </label>
          <strong>&nbsp;&nbsp;
          </strong>
          <label>
              <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_1" />
            <strong>            管理员</strong></label>
          
        </td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" 
        onClick="window.location.href='register.jsp'" name="adduser" id="adduser" value="注&nbsp;册"  />
        

        &nbsp;<input type="reset" value="清&nbsp;空">&nbsp;
        <input type="submit" name="denglu" id="denglu" value="登&nbsp;陆" /></td>
      </tr>
    </table>
  </form>

<hr />

<div class="forgetpw"><u>忘记密码？
</u>&nbsp;&nbsp;&nbsp;<u>帮助中心？
</u></div>
</div>
		</div>
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