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

    <h3 align="center">添&nbsp;加&nbsp;学&nbsp;生&nbsp;信&nbsp;息</h3> 
    <form action="Student_userServlet?method=7" method="post" >
  <table align="center" style="margin-bottom:2%;" border="1">
	<tr align="center" bgcolor="#EEEEEE" >
	<td >学号:</td><td align="center" width="13%"><input name="unique" type="text"   style="width:99%;" />
	</td><td>姓名:<td align="center" width="11%"><input type="text"   style="width:99%;" />
	</td><td>关键字:</td><td align="center" width="37%"><input type="text"   style="width:99%;" />
	</td><td align="center"><input type="submit" value="&nbsp;搜&nbsp;&nbsp;索&nbsp;" 
	style="width:98%;"></td><td align="center" >
	<span style="float: right;margin:2px 30px 4px 1px;align-content: center;">
	<img src="img/tianjia.png" alt="添加" title="添加"/>&nbsp;<a href="add_onestudent.jsp" target="admin_welcome" style="margin-right: 10px;">添加用户</a></span>
</td>
 </tr> 
  </table>
  </form>
  
<table width="100%" border="1" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
	
	<tr bgcolor="#EEEEEE">
	<td width="5%" align="center" >序号</td>
	
		<td width="10%" align="center" height="35">学号</td>
		<td width="10%" align="center">姓名</td>
		<td width="15%" align="center">密码</td>
		<td width="5%" align="center">性别</td>
		<td width="22%" align="center">身份证号</td>
		<td width="10%" align="center" height="32">手机号</td>
		<td width="15%" align="center">执行操作</td>
	 </tr>
	
	  <c:forEach var="name" items="${sus }" begin="${start }" end="${over }">
	<tr height="35">
	<td class="ordertdclass">${name.ordernum}</td>
	
	<td class="tdclass">${name.unique_id}</td>
	<td class="tdclass">${name.name}</td>
	<td class="tdclass">${name.password}</td>
	<td class="tdclass">${name.sex==1?"男":"女"}</td>
	<td class="tdclass">${name.idcard_number}</td>
	<td class="ordertdclass">${name.phonenumber}</td>
	<td class="tdclass">
	<a href="Student_userServlet?method=2&id=${name.id}" ><img src="img/read.png" alt="查看" title="查看"/>
	</a>&nbsp;&nbsp;
                        <a href="Student_userServlet?method=3&id=${name.id}" ><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                     &nbsp;  &nbsp; 
                     <a href="Student_userServlet?method=6&id=${name.id}" ><img src="img/schu.png" alt="删除" title="删除"/></a>
                        </td>
                        
	</tr>
	
	</c:forEach>  
	
	
</table>
  
           
<hr />	
	<table align="center" style="margin-bottom:2%;" border="1">
	<tr align="center" bgcolor="#EEEEEE" >
	<td align="center">&nbsp;&nbsp;共有<a href="#">${maxPage }</a>页&nbsp;&nbsp;</td><td align="center">
	&nbsp;
	&nbsp;共有<a href="#">${recordCount }</a>条记录&nbsp;&nbsp;</td>
	<td align="center">
	<c:choose>
	   <c:when test="${number>1 }">
	  <a href="Student_userServlet?method=7&i=${number-1}&unique=${unique}">&nbsp;上一页&nbsp;</a></td>
	  </c:when>
	   <c:otherwise>
	      &nbsp;上一页&nbsp;
	  </c:otherwise>
	</c:choose>
	
	</td>
	
	
	<td align="center"><strong style="color:red;">&nbsp;${number }&nbsp;</strong></td>
	
	
	
	<td align="center">
	<c:choose>
	   <c:when test="${number<maxPage }">
	  <a href="Student_userServlet?method=7&unique=${unique}&i=${number+1}
	  ">&nbsp;下一页&nbsp;</a>
	  </c:when>
	   <c:otherwise>
	      &nbsp;下一页&nbsp;
	  </c:otherwise>
	</c:choose>
</td>
	</tr>
	
	</table> 	
  	
		
	</body>

</html>