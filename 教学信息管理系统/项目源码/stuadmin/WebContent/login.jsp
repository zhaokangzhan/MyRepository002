<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" type="text/css"
	href="./themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$.extend($.fn.validatebox.defaults.rules, {
		confirmPass : {
			validator : function(value, param) {
				var pass = $(param[0]).passwordbox('getValue');
				return value == pass;
			},
			message : '两次密码需要一致.'
		}
	})

	$(function() {

		$("#activeselect").bind("change", function() {
			//设置input输入框可用（初始化是不可用）
			//$("#upactid").attr("disabled",false); 
			//bianhao是<option>标签中自定义的属性，是为了获取后台传过来的值
			//var bianhao = $(this).find("option:selected").value; 
			var bianhao = $(this).children('option:selected').val();
			//向input输入框中赋值
			$("#upactid").val(bianhao);
		});

		$('#checkbtn').bind('click', function() {
			//alert("checkbtn执行了");
			check();

		});

	});

	function check() {
		var getr = confirm("确认登录");		
		if (getr == true) {
			var form = document.getElementById('formCheck');
			//再次修改input内容

			form.submit();
			
			
		}
			
	}		
	//清空输入框
	function clearvalue() {
		$(":input", ".easyui-window").not(":button", ":reset", "hidden",
				"submit").val("").removeAttr("checked").removeAttr("selected");

	}
	
	//panel居中
	     $(function ()
        {
            SetCenter();
            window.onresize = function ()
            {
                setTimeout(function () { SetCenter(); }, 100);
            }
        });
 
        function SetCenter()
        {
            var top = ($(window).height() - $('#winCheck').height() - 2) / 2;  // 边框宽度为2
            var left = ($(window).width() - $('#winCheck').width() - 2) / 2;
 
            if (top < 0) top = 0;
            if (left < 0) left = 0;
 
            $('#winCheck').panel('move', { left: left, top: top });  // 可以省略 move 方法
        }
	
</script>
</head>
<body style="background-color:#8DEEEE">

	<!-- 登录-->
	<div id="winCheck" class="easyui-panel" title="用户登录，请正确输入信息"
		style="width: 410px; height: 340px;background: url('img/rbg1.jpg')"
		data-options="style:{position:'absolute'}">

		<form id="formCheck" method="post" 
		style="margin-left: 2%" action="${pageContext.request.contextPath}/u_check.action">


			<h2 align="center">用户登录</h2>

			<div style="margin-bottom: 10px">
				<input class="easyui-textbox" name="user_id"
					style="width: 90%; height: 40px; padding: 12px"
					data-options="prompt:'请输入账号（学号）',iconCls:'icon-man',iconWidth:38">
			</div>
			<div style="margin-bottom: 20px">
				<input class="easyui-textbox" name="user_password" type="password"
					style="width: 90%; height: 40px; padding: 12px"
					data-options="prompt:'请输入密码',iconCls:'icon-lock',iconWidth:38">
			</div>
			<div style="margin-bottom: 20px">
				&nbsp;&nbsp;<span>记住密码</span><input type="checkbox" checked="checked"> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
				角色：
			
				学生
				<input type="radio" value="学生" name="user_role" checked="checked" >
				&nbsp;&nbsp;&nbsp;&nbsp;教师
				<input type="radio" value="教师" name="user_role"  >
				&nbsp;&nbsp;&nbsp;&nbsp;教务员
				<input type="radio" value="教务员" name="user_role"  >
				
			</div>
			<div style="margin-bottom: 38px">
			&nbsp;
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cut'"
					onclick="clearvalue()" style="width: 38%; height: 32px">清除数据</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				 <a id="checkbtn" href="#"
					class="easyui-linkbutton" iconCls="icon-ok"
					style="width: 38%; height: 32px">确认登录</a>
				
			</div>
		</form>
		<div style="margin-bottom: 5px">
			<a href="register.jsp" style="margin-left: 6%;"> <span><font
					size="2"><<———未注册，前往注册</font></span></a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a  href="adminlogin.jsp" > <span><font size="2" >后台管理登录———>></font></span></a>
		</div>	
	</div>
	
	
</body>
</html>