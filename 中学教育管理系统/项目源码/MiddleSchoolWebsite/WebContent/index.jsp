<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.web.TestRandomServlet"%>
 <%@ page import="com.domain.NewsInfofabu"%>
 <%@ page import="com.dao.Newsinfofaba_dao"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>中学网</title>
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/bootstrap.min.css" rel="stylesheet" />

<link rel="stylesheet" type="text/css" href="yangshi.css" />

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link href="css/layout.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body >

	<div id="outline"
		style="border: rosybrown double; margin: 0% 3% 0% 3%; background-color: #D3D4D4;">


		<!--logoé¨å-->
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-6">
					<img src="img/logo1.png" />
				</div>
				<div class="col-lg-5 col-md-4 hidden-xs col-sm-6">
					<h4 style="margin-top: 5%;">
						<img src="img/dd_book_no_01.gif" />
						简简单单的中学网(MSW)|||助你轻松过高考</h4>
					</h4>
				</div>



				<div style="padding-top: 13px;">


					<ul class="nav pull-right top-menu">
						<li style="float: left;"><a href="#">公告</a></li>
						<li style="float: left;"><a href="liulang.php">信息</a></li>
						<li class="dropdown" style="float: left;"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <span>在线客服</span>
								<b class="caret"></b>
						</a>
							<ul class="dropdown-menu extended logout">
								<li><a href="#"><i class="icon-user"></i>QQ</a></li>
								<li><a href="#"><i class="icon-cog"></i>微信</a></li>
								<li><a href="login.html"><i class="icon-key"></i>钉钉</a></li>
							</ul></li>
						<li style="float: left;"><a href="#">客户端</a></li>
						<li style="float: left;"><a href="#">购物车</a></li>
						<li style="float: left;"><a href="register.jsp">注册</a></li>
						<li style="float: left;"><a href="login.jsp">登陆</a></li>								
						<li class="dropdown" style="float: left;"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="img/touxiang.png" alt=""> 
								<span class="username">
								
								
	<c:choose>
	   <c:when test="${sessionScope.username!=null }">
	${sessionScope.username }
	  </c:when>
	  <c:otherwise>
	 未登录
	  </c:otherwise>
	</c:choose>														
								</span>
								<b class="caret"></b>
						</a>
							<ul class="dropdown-menu extended logout">
								<li><a href="#"><i class="icon-user"></i>我的资料</a></li>
								<li><a href="#"><i class="icon-cog"></i>我的设置</a></li>
								<li><a href="login.html"><i class="icon-key"></i>退出</a></li>
							</ul></li>
							
						<!-- END USER LOGIN DROPDOWN -->
					</ul>
				</div>
			</div>
		</div>

		<!--å¯¼èªæ -->
		<div class="container" style="margin-top: 5px;">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">首页</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">课堂同步 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="test.html">初一</a></li>
									<li><a href="#">初二</a></li>
									<li><a href="#">初三</a></li>
									<li role="separator" class="divider"></li>
									<li><a href="#">高一</a></li>
									<li><a href="#">高二</a></li>
									<li><a href="#">高三</a></li>
									<li role="separator" class="divider"></li>


								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">随机测试 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">语文</a></li>
									<li><a href="#">数学</a></li>
									<li><a href="#">英语</a></li>
									<li role="separator" class="divider"></li>
									<li><a href="#">化学</a></li>
									<li><a href="TestRandomServlet">物理</a></li>
									<li><a href="#">地理</a></li>
									<li><a href="#">生物</a></li>
									<li role="separator" class="divider"></li>
                                      <li><a href="test.html">基础测试</a></li>
									<li><a href="#">其它</a></li>
								</ul></li>
							<li>
								<a href="#">精选微课</a>
							</li>
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
								<a href="#">考试信息</a>
							</li>
							<li><a href="#"></a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">管理中心  <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="admin.html">教师管理</a></li>
									<li><a href="admin.html">学生管理</a></li>
									<li><a href="admin.html">后台管理</a></li>
									<li role="separator" class="divider"></li>
									<li><a href="admin.html">维护中心</a></li>
									<li><a href="admin.html">系统管理</a></li>				
									<li role="separator" class="divider"></li>
									<li><a href="#">退出</a></li>
								</ul></li>
						</ul>
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="输入关键词搜索">
							</div>
							<button type="submit" class="btn btn-default">搜一搜</button>
						</form>
					</div>
				</div>
			</nav>
		</div>

		<!--è½®æ­å¾-->
		<div class="container" style="margin-top: -10px;">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
					<li data-target="#carousel-example-generic" data-slide-to="4"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="img/1.jpg" alt="...">
						<div class="carousel-caption">...</div>
					</div>
					<div class="item">
						<img src="img/2.jpg" alt="...">
						<div class="carousel-caption">...</div>
					</div>
					<div class="item">
						<img src="img/3.jpg" alt="...">
						<div class="carousel-caption">...</div>
					</div>
					<div class="item">
						<img src="img/4.jpg" alt="...">
						<div class="carousel-caption">...</div>
					</div>
					<div class="item">
						<img src="img/5.jpg" alt="...">
						<div class="carousel-caption">...</div>
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>


			<!--中间-->
	<div class="container">
		<!--左侧菜单开始-->
    <div id="catList" >
        <!--推荐分类-->
        <div class="book_sort">
            <div class="book_sort_bg">推荐分类</div>
            <div class="book_sort_bottom" style="border-bottom:0px;">外语 | 中小学教辅 |高等学教辅|</div>
        </div>
        <!--图书商品分类开始-->
        <div class="book_sort">
            <div class="book_sort_bg"><img src="img/dd_book_cate_icon.gif" alt="图书" /> 图书商品分类</div>
            
            <div class="book_cate">[文艺]</div>
            <div class="book_sort_bottom">文学 | 传记 | 艺术</div>
            <div class="book_cate">[青春]</div>
            <div class="book_sort_bottom">青春文学 | 动漫 | 幽默</div>
            
            
            <div class="book_cate">[教育]</div>
            <div class="book_sort_bottom">教材 | 中小学教辅  </div>
            <div class="book_cate">[其它]</div>
             <div class="book_sort_bottom"> 其它 | 中小学教培训</div>
            <div class="book_cate">[工具书]</div>
           
        </div>
        <!--图书商品分类结束-->
    </div>
    <!--左侧菜单结束-->
    
    
    
<!--中间开始-->



			<div class="container">

				<!--å³ä¾§é¨å1å¼å§-->

				<!--中间滚动图片-->
				<div class="mycart01 ">
					<div class="mycartfirst-b">
						<div class="mycartfirst-b-ml">
							<img src="img/dd_book_cate_icon.gif" alt="图书" />最新消息&nbsp;|&nbsp;点击可查看
						</div>
					</div>

					<div class="mycartleft-b">
						<marquee direction="up">
					
							<div id="box2">
<%
Newsinfofaba_dao indexgetnews_dao=new Newsinfofaba_dao();
NewsInfofabu newsfabuget=indexgetnews_dao.getnewsfrom_table();

if(newsfabuget.getImagepath()!=null&&newsfabuget.getImagepath()!=""){
%>
	<img src="${pageContext.request.contextPath }/<%=newsfabuget.getImagepath() %> " width="100%" height="100%" />
	
<%}else{%>
	
	<img src="img/4.jpg" width="100%" height="100%" />
<%}%>
	
						</div>
						</marquee>
					</div>
					
					
				</div>
				<!--å³ä¾§é¨åç»æ-->

				<!--å³ä¾§é¨å1å¼å§-->

				<!--å³ä¾§é¨åå¼å§-->
				<div class="mycart02">
					<div class="mycartfirst-b">
						
					 <div class="book_sort_bg">公告信息&nbsp;||&nbsp;美文在线
							<img src="img/dd_book_cate_icon.gif" alt="美文" /></div>	
					</div>

   
					<div class="mycartleft-b" style="height: 340px;overflow:scroll;">
			  <marquee direction="up" onmouseover=this.stop() onmouseout=this.start() >		
<% 	if(newsfabuget.getTitle()!=null||newsfabuget.getTitle()!=""||
newsfabuget.getContent()!=null||newsfabuget.getContent()!=""){
%>
	
	<table>
	<tr><strong style="text-align: center;"><h4><%=newsfabuget.getTitle()%></h4></strong></tr>
	<tr>&nbsp;&nbsp;<%=newsfabuget.getContent()%></tr>
	
	</table>
<%}else{%>
	<h1>暂无公告</h1>
<%}%>		
			</marquee>		
					</div>
				
					
				</div>
				<!--å³ä¾§é¨åç»æ-->

				<!--å³ä¾§é¨åå¼å§-->
				
				<!--å³ä¾§é¨åç»æ-->

			</div>




			<div class="clearboth"></div>

 <div class="bottombgright">
    <div id="guessyou" class="">
			<div class="mt">
				<div class="myquess" style="background-color:#FC9; margin:2px 0px 8px 0px; height:27px;"><h3>热销在线书籍&gt;&gt;&nbsp;点击可查看详情并购买&gt;&gt;</h3></div>
			
			</div>
			<div class="list1">
				<div class="spacer"><i></i></div>
				<ul>        
					<li class="fore1">            
						<div class="p-img">
							<a href="#" target="_blank">
								<img data-lazy-img="done" width="130" height="130" title="小双待 智通高配版(3G RAM+32G ROM)标配" src="img/dd_history_4.jpg" class="">
                                
                                
							</a>
						</div>                
						<div class="p-info">                
							<div class="p-name">
								<a href="#" target="_blank" title="小米（MI）双待 智机 金色 全网通高配版(3G RAM+32G ROM)标配">note3 智能 通高配版(3G RAM+ ROM)标配</a></div>
							<div class="p-price" data-lazyload-fn="done"><i>¥</i>98.00</div>            
						</div>        
					</li>        
					<li class="fore2">            
						<div class="p-img">
							<a href="#" target="_blank"><img data-lazy-img="done" width="130" height="130" title="移动合约版 黑色 移动 不含合约计划" src="img/dd_history_4.jpg" class=""></a>
						</div>                
						<div class="p-info">                
							<div class="p-name"><a href="#" target="_blank" title="小 移动合约版 黑色 移动 不含合约计划">移动合约版 黑色 移动不含合约计划</a>
							</div>
							<div class="p-price"><i>¥</i>99.00</div>            
						</div>        
					</li>        
					<li class="fore3">            
						<div class="p-img"><a href="#" target="_blank"><img data-lazy-img="done" width="130" height="130" title="勾勾手 重力方向盘无线遥控具车汽车模型 漂移遥控汽车 可充电 急速游侠 红色" src="img/dd_history_2.jpg" class=""></a>
						</div>                
						<div class="p-info">                
							<div class="p-name"><a href="#" target="_blank" title="手 力方向盘无线遥控车 儿童玩具车模型 漂移遥控汽车 可充电 急速游侠 红色">勾勾手 重力方向盘无线遥控车 儿童游侠 红色</a>
							</div>
							<div class="p-price"><i>¥</i>68.00</div>            
						</div>        
					</li>      
                    <li class="fore4">            
						<div class="p-img">
							<a href="#" target="_blank"><img data-lazy-img="done" width="130" height="130" title="【明星同款 年终清仓】吉普盾NIAN JEE三合一冲锋衣防水防风保暖 男款灰色 M" src="img/dd_history_1.jpg" class=""></a>
						</div>                
						<div class="p-info">                
							<div class="p-name"><a href="#" target="_blank" title="【星同款 终清仓】吉普盾NIAN JEEP男女情侣款两件套三合一冲锋衣防水防风保暖 男款灰色 M">【明星同款 清仓】吉普盾NIAN J情侣款两件防</a>
							</div>
							<div class="p-price"><i>¥</i>28.00</div>            
						</div>        
					</li>        
   	
				</ul>
			</div>
			<!--热门资料-->
		<div class="container" style="margin-top: 10px;">
			<!--上面文字内容-->
			<div class="row">
				<span id="" style="font-size: 30px;padding-left: 33px;">
					热门资料&nbsp;&nbsp;&nbsp;<img src="img/title2.jpg" />
				</span>
			</div>
			<!--图片内容-->
			<div class="row">
				
				<div class="col-md-10 col-sm-10" style="padding-left: 2px;">
					<div class="row">
						<div class="col-md-3 col-sm-3 col-xs-3" align="center">
							<a href="#"><img src="img/dd_history_2.jpg" /></a>
							<p><a href="#"><font color="gray">近代史</font></a></p>
							<p><font color="red">¥37.9</font></p>
						</div>
						<div class="col-md-3 col-sm-2 col-xs-3" align="center">
							<a href="#"><img src="img/dd_history_2.jpg" /></a>
							<p><a href="#"><font color="gray">近代史</font></a></p>
							<p><font color="red">¥38</font></p>
						</div>
						<div class="col-md-3 col-sm-2 col-xs-3" align="center">
							<a href="#"><img src="img/dd_history_2.jpg" /></a>
							<p><a href="#"><font color="gray">近代史</font></a></p>
							<p><font color="red">¥35</font></p>
						</div>
						<div class="col-md-3 col-sm-2 col-xs-3" align="center">
							<a href="#"><img src="img/dd_history_2.jpg" /></a>
							<p><a href="#"><font color="gray">近代史最新</font></a></p>
							<p><font color="red">¥39</font></p>
						</div>
						
						<!--广告图片-->
		<div class="container" style="margin-top: 10px;">
			<div class="row">
				<div class="hidden-md hidden-sm hidden-xs " style="padding-left: 14px;">
					<img src="img/footer.jpg" style="width: 98%;"/>
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
						<li><a>用户反馈</a></li>
						<li><a>客服QQ:3543338298&nbsp;||</a></li>
	                     
	                     	<li><a>微信:asdfzhan</a></li>
	            <li><a>电话号码:14354619562</a></li>
	             <li><a href="fabu.php">&nbsp;<a><strong>后台管理&gt;&gt;<strong></a></li>
						
				</ul>
					
				</div>
				
					</div>
					
				</div>
			</div>
		</div>
				
		
		</div>
    
    </div>
		</div>   
        
         
		</div>
    
    </div>
		</div>   
        
       
	</div>
	
	





	</div>
	</div>



	</div>

	<script language="javascript" type="text/javascript">
		function setTab(name, cursel) {
			cursel_0 = cursel;
			for (var i = 1; i <= links_len; i++) {
				var menu = document.getElementById(name + i);
				var menudiv = document.getElementById("con_" + name + "_" + i);
				if (i == cursel) {
					menu.className = "off";
					menudiv.style.display = "block";
				} else {
					menu.className = "";
					menudiv.style.display = "none";
				}
			}
		}
		function Next() {
			cursel_0++;
			if (cursel_0 > links_len)
				cursel_0 = 1
			setTab(name_0, cursel_0);
		}
		var name_0 = 'one';
		var cursel_0 = 1;
		var ScrollTime = 1000;//å¾ªç¯å¨æï¼æ¯«ç§ï¼
		var links_len, iIntervalId;
		onload = function() {

			//window.location.href = "${pageContext.request.contextPath}/IndexServlet";
			window.open(
							"adv.html",
							"",
							"height=350,width=533,toolbar=0,scrollbars=0,location=3,status=0,menubar=0,resizable=0");

			var links = document.getElementById("tab1").getElementsByTagName(
					'li')
			links_len = links.length;
			for (var i = 0; i < links_len; i++) {
				links[i].onmouseover = function() {
					clearInterval(iIntervalId);
					this.onmouseout = function() {
						iIntervalId = setInterval(Next, ScrollTime);
						;
					}
				}
			}
			document.getElementById("con_" + name_0 + "_" + links_len).parentNode.onmouseover = function() {
				clearInterval(iIntervalId);
				this.onmouseout = function() {
					iIntervalId = setInterval(Next, ScrollTime);
					;
				}
			}
			setTab(name_0, cursel_0);
			iIntervalId = setInterval(Next, ScrollTime);
		}
	</script>
</body>

</html>