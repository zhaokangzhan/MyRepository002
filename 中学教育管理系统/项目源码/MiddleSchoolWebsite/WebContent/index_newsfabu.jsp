<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.web.TestRandomServlet"%>
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

    <h3 align="center">添&nbsp;加&nbsp;首&nbsp;页&nbsp;信&nbsp;息</h3> 
   
  

  <form action="${pageContext.request.contextPath}/ImagefabuServlet" enctype="multipart/form-data" method="post">
<table width="100%" border="1" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">	
	<tr bgcolor="#EEEEEE">	
		<td width="17%" align="center">信息标题</td>		
		<td width="35%" align="center" >信息内容</td>
		<td width="26%" align="center">图片上传</td>	
	 </tr>	
	<tr height="35">
	<td ><input type="text" name="title"  style="width:98%;" required/></td>
	<td ><textarea name="content" rows="15" cols="85%"></textarea></td>
	<td ><input type="file" name="newsinfofabu" style="width:98%;margin-left: 8px;" /></td>            
	</tr>	
	<tr height="20px">	
	<td colspan="3"><input type="reset"  style="margin-left:32%;margin-top:4px;margin-bottom:5px" value="清空信息" />
	<input type="submit"  style="margin-left:10%;" value="提交信息" /></td>  	       
	</tr>
</table>
  </form>
           
<hr />	
	
		
	</body>

</html>