<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
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
		$("#tactiveselect").bind("change", function() {
			//设置input输入框可用（初始化是不可用）
			//$("#upactid").attr("disabled",false); 
			//bianhao是<option>标签中自定义的属性，是为了获取后台传过来的值
			//var bianhao = $(this).find("option:selected").value; 
			var bianhao = $(this).children('option:selected').val();
			//向input输入框中赋值
			$("#tupactid").val(bianhao);
		});
		$("#activeselect").bind("change", function() {
			//设置input输入框可用（初始化是不可用）
			//$("#upactid").attr("disabled",false); 
			//bianhao是<option>标签中自定义的属性，是为了获取后台传过来的值
			//var bianhao = $(this).find("option:selected").value; 
			var bianhao = $(this).children('option:selected').val();
			//向input输入框中赋值
			$("#upactid").val(bianhao);
		});

		/* $(window).resize(function() {
			fitCoulms();
		});
		 */

		$('#winUpdate').window({
			onBeforeClose : function() {
				$("#dg").datagrid("reload");
			}
		});

		 
		/*  $('#toRegister').bind('click', function() {
			 $("#winCheck").window("close");
			 $("#winAdd").window("open");

			}); */
		 $('#index_toRegister').bind('click', function() {
			 $("#winCheck").window("close");
			 $("#winAdd").window("open");

			});
		 
		 $('#index_toLogin').bind('click', function() {			 
			 $("#winAdd").window("close");
			 $("#winCheck").window("open");
			

			});
		 
		$('#addbtn').bind('click', function() {

			save();

		});

	});

	
	function save() {

		var getr = confirm("确认提交")
		if (getr == true) {

			// 提交数据到Action
			var form = document.getElementById('formAdd');
			//再次修改input内容

			form.submit();
			
			/* 
			$('#formAdd').form('submit', {
				url : "u_save.action",
				success : function(data) {
					// data是字符串类型
					// "alert('')"
					var jsonData = eval("(" + data + ")");
					$.messager.show({
						title : '提示消息',
						msg : jsonData.msg,
						timeout : 3000,
						showType : 'slide'
					});
					window.location.href="${pageContext.request.contextPath}/jsp/test/user_test.jsp";
					
					// 关闭窗口
					$("#winAdd").window("close");
					// 表格重新加载
					$("#dg").datagrid("reload");
				}
			}); */

		}

	}

	//清空输入框
	function clearvalue() {
		$(":input", ".easyui-window").not(":button", ":reset", "hidden",
				"submit").val("").removeAttr("checked").removeAttr("selected");

	}

	//更新
	function edit(id) {
		// alert(id);

		$("#winUpdate").window("open");

		$('#formUpdate').form('load', "u_edit.action?id=" + id);

	}
	function update() {
		$('#formUpdate').form({
			url : "u_update.action",
			success : function(data) {
				var jsonData = eval("(" + data + ")");
				$.messager.show({
					title : '提示消息',
					msg : jsonData.msg,
					timeout : 3000,
					showType : 'slide'
				});
				// 关闭窗口:
				$("#winUpdate").window("close");
				// 重新加载数据:
				$("#dg").datagrid("reload");
			}
		});
		// submit the form    
		$('#formUpdate').submit();

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
            var top = ($(window).height() - $('#winAdd').height() - 2) / 2;  // 边框宽度为2
            var left = ($(window).width() - $('#winAdd').width() - 2) / 2;
 
            if (top < 0) top = 0;
            if (left < 0) left = 0;
 
            $('#winAdd').panel('move', { left: left, top: top });  // 可以省略 move 方法
        }
	
	
</script>
</head>
<body style="background-color:#8DEEEE">
<!-- 注册表单 -->
	<div id="winAdd" class="easyui-panel" title="用户注册，请正确填写个人信息"
		style="width: 470px; height: 595px;background: url('img/rbg1.jpg')" 
		data-options="style:{position:'absolute'}">	
		<form id="formAdd" method="post" style="margin-left: 2%" action="${pageContext.request.contextPath}/u_register.action">		
			<div style="margin-bottom: 3px;margin-top: 5px" >
			角色(请选择您的角色，此角色将成为您日后登录本系统的角色和权限)
			</div>
			<div style="margin-bottom: 3px;margin-top: 5px" >
				<!-- <input class="easyui-textbox" name="user_role" label="角色（）"
					labelPosition="top" prompt="请输入角色" iconWidth="28"
					style="width: 80%; height: 50px; padding: 10px"> -->
					
					学生
				<input type="radio" value="学生" name="user_role" checked="checked" >
				&nbsp;&nbsp;&nbsp;&nbsp;教师
				<input type="radio" value="教师" name="user_role"  >
				&nbsp;&nbsp;&nbsp;&nbsp;教务员
				<input type="radio" value="教务员" name="user_role"  >
				管理员
				<input type="radio" value="管理员" name="user_role" >
			</div>
			<div style="margin-bottom: 3px">
				<input class="easyui-textbox" name="user_id" label="账号（）"
					labelPosition="top" prompt="请输入账号" style="width: 80%; height: 50px">
			</div>
			<div style="margin-bottom: 3px">
				<input class="easyui-textbox" name="user_name" label="用户名（）"
					labelPosition="top" prompt="请输入用户名"
					style="width: 80%; height: 50px">
			</div>
			<div style="margin-bottom: 3px">
				<input id="pass" class="easyui-passwordbox" 
					label="密码" labelPosition="top" prompt="请输入密码" iconWidth="28"
					style="width: 80%; height: 50px; padding: 10px">
			</div>
			<div style="margin-bottom: 3px">
				<input id="checkpass" class="easyui-passwordbox" name="user_password" 
				label="再次输入密码" labelPosition="top"
					prompt="请再次输入密码" iconWidth="28"
					validType="confirmPass['#pass']"
					style="width: 80%; height: 50px; padding: 10px">
			</div>
			<div style="margin-bottom: 3px">
				<input class="easyui-textbox" name="user_idcard" label="身份证号"
					labelPosition="top" prompt="请输入身份证号" iconWidth="28"
					style="width: 80%; height: 50px; padding: 10px;">
			</div>
			<div style="margin-bottom: 3px">
				<input class="easyui-textbox" name="user_phonenumber" label="手机号"
					labelPosition="top" prompt="请输入手机号" iconWidth="28"
					style="width: 80%; height: 50px; padding: 10px">
			</div>
			
			<div style="margin-bottom: 3px">
				<input class="easyui-textbox" name="user_email" label="邮箱（注意邮箱格式）"
					labelPosition="top"
					data-options="prompt:'请输入邮箱',validType:'email'"
					style="width: 80%; height: 50px">
			</div>
			<span >激活状态</span>
			<div style="margin-bottom: 3px">
				<INPUT class=textbox style="WIDTH: 60px; height: 25px" maxLength=50
					name="user_active" id="tupactid"><select
					style="WIDTH: 120px; height: 25px" id="tactiveselect" class=textbox>
					<option value="未选择" selected="selected">----选择----</option>
					<option value="是">----已激活----</option>
					<option value="否">----未激活----</option>
					<option value="其它">----其它----</option>
				</select> 提示：（激活=是，未激活=否，其它=其它）
			</div>
<span >&nbsp;</span>
			<div style="margin-bottom: 18px">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cut'"
					onclick="clearvalue()" style="width: 35%; height: 32px">清除数据</a> 
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a id="addbtn"
					href="#" class="easyui-linkbutton" iconCls="icon-save"
					style="width: 35%; height: 32px">确认提交</a>
			</div>
<div style="margin-bottom:6px" >
		<a  href="login.jsp" style="margin-left: 2%;"> <span><font size="2" >已注册，用户登录———>></font></span></a>
		
		<a  href="adminlogin.jsp" style="margin-left: 5%;"> <span><font size="2" >已注册，后台管理登录———>></font></span></a>
		
		</div>

		</form>
	</div>
</body>
</html>