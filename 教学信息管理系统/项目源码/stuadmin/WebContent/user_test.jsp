<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试中心</title>
<link rel="stylesheet" type="text/css"
	href="./themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./locale/easyui-lang-zh_CN.js"></script>
<style type="text/css">
.menuleft {
	text-decoration: none;
}
</style>
<script type="text/javascript">
	$(function() {
		$(".menuleft").click(function() {
			var mlc = this.innerHTML;
			var url = this.href;
			//alert(mlc + url);
			//createTabs(mlc);
			createTabs(mlc, url);
			// 超链接不跳转
			return false;

		});
	});

	function createTabs(mlc, url) {
		var flag = $('#tt').tabs('exists', mlc);

		if (flag) {
			$('#tt').tabs('select', mlc);

		} else {
			$('#tt').tabs('add', {
				title : mlc,
				content : createUrl(url),
				closable : true,
				tools : [ {
					iconCls : 'icon-mini-refresh',
					handler : function() {
						alert('refresh');
					}
				} ]

			});

		}

	}

	function createUrl(url) {
		return "<iframe src='" + url
				+ "' style='width:92%;height:92%;border:0;'>数据返回成功啦</iframe>";
	}
</script>
</head>

<body>

	<div style="margin: 5px 0;"></div>
	<div class="easyui-layout" style="width: 100%; height: 600px;">
		<div data-options="region:'north',split:true" style="height: 50px">	
		<h2 style="margin-left: 20%">学生测试服务中心
			
			<span style="margin-left: 20%"><img alt="头像图片" src="./img/touxiang.png">登录用户:${sessionScope.user.user_name}（账号：${sessionScope.user.user_id}）
			</span> 
		</h2>	
		</div>


		<div data-options="region:'west',split:true" title="试题分类"
			style="width: 100px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="个人中心" data-options="selected:true,iconCls:'icon-save'"
					style="padding: 10px;">

					<div id="">
						<%-- 	<a href="${pageContext.request.contextPath}/admin_student.action"
							class="menuleft">学生管理</a> --%>
						<a href="t_testList.action" class="menuleft">学生测试</a>					
					</div>					
					<div id="">
							<a href="testscore.jsp" class="menuleft">测试成绩</a>
					</div>
					<div id="">						
						<a href="explain.jsp" class="menuleft">答案解释</a>
					</div>
				<div id="">
						<a href="#"  title="暂未同步联系人信息">联系人管理</a>
					</div>
				</div>
				<div title="小学" data-options="iconCls:'icon-save'"   style="padding: 10px;">
					<div id="role_admin">
						<a >权限管理</a>
					</div>
					<div id="">
						<a href="#"  title="暂未同步联系人信息">联系人管理</a>
					</div>
				</div>

				<div title="初中" data-options="iconCls:'icon-search'"  style="padding: 10px;">
					<div id="role_admin">
						<a >人员数量</a>
					</div>
					<div id="">					
						<a href="t_testList.action" class="menuleft">学生测试</a>					
					</div>					
					<div id="">
							<a href="testscore.jsp" class="menuleft">测试成绩</a>
					</div>
					<div id="">						
						<a href="explain.jsp" class="menuleft">答案解释</a>
					</div>
				<div id="">
						<a href="#"  title="暂未同步联系人信息">联系人管理</a>
					</div>
				</div>
				
				
				<div title="高中" data-options="iconCls:'icon-help'">
					<a href="#" class="menuA">拜访记录列表</a>
				</div>
				
				<div title="课外知识" data-options="iconCls:'icon-ok'"  style="padding: 10px">

					<div id="">
						<a href="#" >更新</a>
					</div>

				</div>
		
				<div title="其它" data-options="iconCls:'icon-add'" style="padding: 10px">

					<div id="">
					<a href="#" >更多管理</a>
					
					</div>
                 <div id="">					
						<a href="#" >more admin</a>
					</div>
				</div>
			</div>
		</div>
		<div
			data-options="region:'center',title:'详细信息',iconCls:'icon-ok',fit:true">
			<div id="tt" class="easyui-tabs" data-options="fit:true">
				<div  title="测试向导" data-options="iconCls:'icon-reload',closable:true"
					style="padding: 20px; display: none;">
					
					<br>				
						<br>				
						<br>				
						<br>	
				<span>	<a class="menuleft" href="t_testList.action" >进行测试</a>———>></span>
					
					<br>				
						<br>				
						<br>				
						<br>				
					<a  href="login.jsp" > <span><font size="2" >登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录———>></font></span></a>
				
					
					<br>				
						<br>				
						<br>				
						<br>				
					<a  href="adminlogin.jsp" > <span><font size="2" >后台管理———>></font></span></a>
						
					<br> <br>
							<br> <br>
							<hr>
						<h2>公告提示！</h2>
					<marquee direction="up"  onmouseover="stop()" onmouseout="start()" scrollamount="2">		
<p>暂时没有作业.....</p>

<p>暂时没有测试......</p>

			</marquee>	
					</div>
					
				
			</div>
		
		</div>

		
	</div>
</body>

</html>
</body>

</html>