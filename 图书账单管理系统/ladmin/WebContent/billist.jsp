<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.util.ArrayList"%>
   <%@ page import="com.domain.Book"%>
   <%@ page import="com.dao.BooksDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>图书账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
  
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>图书账单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>当前用户:</span><span style="color: #fff21b"> ${sessionScope.suser }</span> , 欢迎你！</p>
            <a href="index.jsp">首页</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
<!--主体内容-->
    <section class="publicMian ">
        <div class="left">
            <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
            <nav>
               <ul class="list">
                    <li id="active"><a href="BookServlet?method=0">账单管理</a></li>
                 <li><a href="SupplierServlet?method=0">供应商管理</a></li>
                    <li><a href="UserServlet?method=1">用户管理</a></li>
                      <li><a href="billView.jsp">文件管理</a></li>
                    <li><a href="LogoutServlet">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>账单管理页面</span>
            </div>
            <div class="search">
            
            <form id="form1" action="/ladmin/BookServlet?method=5" method="post">	
 <table  >
 <tr> <span>商品名称：</span>
                <input type="text" name="bookname" placeholder="请输入书籍的名称"/>
                
                <span>出版社：</span>
                <select name="print" >
                    <option value="">--请选择--</option>
                    <option value="">新华出版社</option>
                    <option value="">天津出版社</option>
                </select>

                <span>是否付款：</span>
                <select name="name="tip"">
                    <option value="">--请选择--</option>
                    <option value="">已付款</option>
                    <option value="">未付款</option>
                </select>

             &nbsp; &nbsp;
                <input type="submit" value="查询"  style="width:120px;height:31px"/>  <a href="billAdd.jsp">添加订单</a></tr>
</table>
</form>
           </div>
           
        
            
         <%ArrayList<Book> bookstore=(ArrayList<Book>)BooksDao.getInstance().selectallbooks();%>
            <!--账单表格 样式和供应商公用-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">图书编码</th>
                    <th width="10%">图书标签</th>
                     <th width="20%">图书名称</th>
                    <th width="20%">作者</th>
                    <th width="10%">出版社</th>
                    <th width="10%">账单金额</th>
                    <th width="10%">是否付款</th>
                   
                    <th width="30%">操作</th>
                </tr>
             
                
                <c:forEach var="name" items="${bookstore }" begin="${start }" end="${over }">
	<tr>
	<td>${name.id}</td>
	<td>${name.bookid}</td>
	<td>${name.bookname}</td>
	<td>${name.author}</td>
	<td>${name.print}</td>
	<td>${name.price}</td>
	<td>${name.tip}</td>
	<td>
	 <a href="billView.jsp"><img src="img/read.png" alt="查看" title="查看"/></a>
	<a href="BookServlet?method=1&id=${name.id}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>&nbsp;
	<a href="BookServlet?method=3&id=${name.id}"><img src="img/schu.png" alt="删除" title="删除"/></a></td>
	</tr>
	</c:forEach>  
                
            </table>
            
           <p></p>
	<table align="center" class="myselect">
	<tr align="center">
	<td align="center">共有${maxPage }页&nbsp;</td><td align="center">共有${recordCount }条记录&nbsp;</td>
	<td align="center">当前为${number }第页&nbsp;</td>
	<td align="center">	
	<c:choose>
	   <c:when test="${number>1 }">
	  <a href="BookServlet?method=0&i=${number-1}">上一页</a>&nbsp;</td>
	  </c:when>
	   <c:otherwise>
	      上一页&nbsp;
	  </c:otherwise>
	</c:choose>
	</td>
	<td>
	<c:choose>
	   <c:when test="${number<maxPage }">
	  <a href="BookServlet?method=0&i=${number+1}">下一页</a>&nbsp;</td>
	  </c:when>
	   <c:otherwise>
	      下一页&nbsp;
	  </c:otherwise>
	</c:choose>

	</tr>
	</table> 
        </div>
    </section>



    <footer class="footer">
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>