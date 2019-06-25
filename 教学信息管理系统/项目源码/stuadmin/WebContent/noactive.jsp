<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提示</title>
<link rel="stylesheet" type="text/css"
	href="./themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./locale/easyui-lang-zh_CN.js"></script>
  <style type="text/css">   
       
        .center-in-center{   
            position: absolute;   
            top: 30%;   
            left: 30%;   
        }   
    </style> 
     <script type="text/javascript">
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
<div id="winCheck" class="easyui-panel" title="登录失败提示"
		style="width: 380px; height: 300px;background: url('img/rbg1.jpg')"
		data-options="style:{position:'absolute'}">
<div style="margin-bottom:20px;margin-top: 35px">
				<h3 align="center">登录失败,账号未激活，或已被停用</h3>
		</div>
		
	<div style="margin-bottom:19px" align="center">
		<a  href="login.jsp" > <span><font size="2" ><<————重新登录</font></span></a>
		</div>		
		<div style="margin-bottom: 19px" align="center">
			<a href="register.jsp" > <span><font
					size="2">未注册，前往注册————>></font></span></a>
		</div>
	<div style="margin-bottom: 10px" align="center">
			<a href="#" > <span><font
					size="2">联系管理员————>></font></span></a>
		</div>
	</div>
</body>
</html>