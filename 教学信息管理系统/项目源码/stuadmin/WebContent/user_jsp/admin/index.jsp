<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生测试管理系统</title>
<link rel="stylesheet" type="text/css"
	href="../../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../themes/icon.css">
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../locale/easyui-lang-zh_CN.js"></script>
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
				+ "' style='width:100%;height:100%;border:0;'>数据返回成功啦</iframe>";
	}
</script>
</head>

<body>

	<div style="margin: 5px 0;"></div>
	<div class="easyui-layout" style="width: 100%; height: 600px;">
		<div data-options="region:'north'" style="height: 50px">


			<h2 style="margin-left: 20%">
				学生信息后台管理中心 <span style="margin-left: 20%" ><img alt="头像图片" src="../../img/touxiang.png">登录管理员:${sessionScope.user.user_name}（账号：${sessionScope.user.user_id}）
				</span>
			</h2>


		</div>


		<div data-options="region:'west',split:true" title="系统菜单"
			style="width: 180px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="人员管理" data-options="selected:true,iconCls:'icon-save'"
					style="padding: 10px;">

					<div id="">
						<%-- 	<a href="${pageContext.request.contextPath}/admin_student.action"
							class="menuleft">学生管理</a> --%>
						<a href="student.jsp" class="menuleft">学生管理</a>
					</div>
					<div id="">

						<a href="teacher.jsp" class="menuleft">教师管理</a>
					</div>
					<div id="">
						<a href="dean.jsp" class="menuleft">教务员管理</a>
					</div>
					<div id="">
						<a href="user.jsp" class="menuleft">所有用户</a>
					</div>
					<div id="">
						<a href="#" title="暂未同步联系人信息">联系人管理</a>
					</div>
					
					
  
				</div>
				<div title="权限管理" data-options="iconCls:'icon-save'"
					style="padding: 10px;">
					<div id="role_admin">
						<a href="authority.jsp" class="menuleft">权限管理</a>
					</div>
					<div id="">
						<a href="#">其它管理</a>
					</div>
				</div>

				<div title="试题管理" data-options="iconCls:'icon-search'"
					style="padding: 10px;">
					<div id="role_admin">
						<a href="test.jsp" class="menuleft">试题管理</a>
					</div>

				</div>				
				<div title="年级管理" data-options="iconCls:'icon-save'"
					style="padding: 10px;">
					<div id="role_admin">
						<a>权限管理</a>
					</div>
					
				</div>
	<div title="人员统计分析" data-options="iconCls:'icon-search'"
					style="padding: 10px;">
					<div id="role_admin">
						<a href="person_charts.jsp" class="menuleft">数量比例</a>
					</div>
					<div id="role_admin">
						<a href="dpersons_charts.html" class="menuleft">详细比例信息</a>
					</div>
				</div>
				<div title="成绩统计分析" data-options="iconCls:'icon-search'"
					style="padding: 10px;">
					<div id="">
						<a href="score_charts.action" class="menuleft">学生成绩分析</a>
					</div>
				</div>

				<div title="拜访记录管理" data-options="iconCls:'icon-help'"
					style="padding: 10px;">
					<a href="#" class="menuA">拜访记录列表</a>
				</div>

				<div title="系统管理" data-options="iconCls:'icon-ok'"
					style="padding: 10px">

					<div id="">
						<a href="#">更新</a>
					</div>

				</div>

				<div title="其它管理" data-options="iconCls:'icon-add'"
					style="padding: 10px">

					<div id="">
						<a href="#">更多管理</a>

					</div>
					<div id="">
						<a href="#">more admin</a>
					</div>
				</div>
			</div>
		</div>
		<div
			data-options="region:'center',title:'详细信息',iconCls:'icon-ok',fit:true">
			<div id="tt" class="easyui-tabs" data-options="fit:true">
				<div title="欢迎" data-options="iconCls:'icon-reload',closable:true"
					style="padding: 20px; display: none;">
					<span style="margin: 200px, 20px, 200px, 250px">
						<h1>学生信息后台管理中心欢迎您！</h1>
					</span> <br> <br> <br>  <a
						href="${pageContext.request.contextPath}/user_test.jsp"> <span><font
							size="2">用户测试中心———>></font></span></a>
							
							<br> <br>
							<br> <br>
							<hr>
						<h2>系统提示！</h2>
					<marquee direction="up"  onmouseover="stop()" onmouseout="start()" scrollamount="2">		

<p>系统运行正常......</p>

<p>暂无其它提示......</p>

			</marquee>	
							
				</div>
				
				

					
					
			</div>
		</div>

		<div
			data-options="region:'east',split:true,hideCollapsedContent:false,collapsed:true"
			title="温馨提示" style="width: 100px;"></div>
		<div data-options="region:'south',split:true" style="height: 5px;"></div>
	</div>
</body>

</html>
</body>

</html>