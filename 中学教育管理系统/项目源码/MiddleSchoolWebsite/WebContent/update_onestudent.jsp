<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.web.TestRandomServlet"%>
 <%@ page import="com.domain.student_User"%>
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
		<style type="text/css">
		.ordertdclass{
		hover:red;
		}
		.tdclass{
		text-align: center;
		}
		</style>
  </head>
  <body>
    
<div id="outline" style="border:rosybrown double;margin: 0% 1% 0% 1%;background-color: #D3D4D4;" >
	
	
    <h2 align="center">学&nbsp;生&nbsp;具&nbsp;体&nbsp;信&nbsp;息</h2>

   <form action="/MiddleSchoolWebsite/Student_userServlet?method=4&upid=${onestudent.id}&unique_id=${onestudent.unique_id}" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
    <table width="75%" border="1" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
	
	<tr height="35"><td width="15%" align="center">用户学号：</td><td class="tdclass" width="45%">
	 <input type="text" name="unique_id" value="${onestudent.unique_id}" disabled="true" style="width:98%;" />
	 </td><td><span >*用户编号不可修改</span></td></tr>    
	 
	<tr height="35"><td width="15%" align="center">用户名称：</td><td class="tdclass" width="35%">
	 <input type="text" name="name" value="${onestudent.name}"  style="width:98%;" required/>
	 </td><td><span >*请输入用户名称</span></td></tr>    
          
    <tr height="35"><td width="15%" align="center">用户密码：</td><td class="tdclass" width="35%">
	 <input type="text" name="password" value="${onestudent.password}"  style="width:98%;" required/>
	 </td><td><span >*密码长度必须大于6位小于20位</span></td></tr>    
     
  <tr height="35"><td width="15%" align="center">用户性别：</td><td class="tdclass" width="35%">
	 
	 <input type="radio" name="msex" value="1" checked="checked" />${onestudent.sex=='1'?"男":"女" }
                  &nbsp;&nbsp;  <input type="radio" value="0" name="msex" />${onestudent.sex=='1'?"女":"男" }
	 </td><td><span >*</span></td></tr>    
                              
                
    <tr height="35"><td width="15%" align="center">身份证号：</td><td class="tdclass" width="35%">
	 <input type="text" name="idcard" value="${onestudent.idcard_number }"  style="width:98%;" required/>
	 </td><td><span >*注意身份证号位数</span></td></tr>    
    
    <tr height="35"><td width="15%" align="center">手机号：</td><td class="tdclass" width="35%">
	 <input type="text" name="phonenumber" value="${onestudent.phonenumber }"  style="width:98%;" required/>
	 </td><td><span >*注意手机号位数</span></td></tr>    
                  
       <tr height="35"><td width="15%" align="center">添加权限：</td><td class="tdclass" width="35%">
	 <input type="radio" name="userlei"/>管理员
                    <input type="radio" name="userlei"/>经理
                    <input type="radio" name="userlei"/>普通用户
                      <input type="radio" name="userlei"/>超级管理员
	 </td><td><span >*说明添加权限原因</span></td></tr>   
	          
     <tr height="35"><td width="15%" align="center">修改备注：</td><td class="tdclass" width="35%">
	 <input type="text" name="userid" value="填写修改人邮箱"  style="width:98%;" />
	 </td><td><span >*注意格式@163/129/qq.com</span></td></tr>    
                            
          
                 
     <tr height="35"><td width="15%" align="center">操作选项：</td><td class="tdclass" width="35%">
	  <input type="reset" value="清空内容" />&nbsp;&nbsp;&nbsp;<input type="submit" value="确认提交" />
	 </td><td><span >*修改完即可点击提交</span></td></tr>    
                               
               
                
                      
</table>  
            </form>

           
<hr />	
	
		
	</body>

</html>