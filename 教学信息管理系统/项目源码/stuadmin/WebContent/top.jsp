<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <title>中学网</title>
<link rel="stylesheet" type="text/css"
	href="./themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
  </head>
  <body>
    

	

  	<!--logo部分-->
		

		
				
							
						
					
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                               <img src="img/touxiang.png" alt="用户头像">
                               <span class="username" style="font-size: 18px;">

          <strong><c:choose>
	   <c:when test="${sessionScope.username!=null }">
	${sessionScope.username }
	  </c:when>
	  <c:otherwise>
	 您未登录，请登录！
	  </c:otherwise>
	</c:choose>		</strong>

</span>
                               <b class="caret"></b>
                           </a>
                    

	

	</body>

</html>