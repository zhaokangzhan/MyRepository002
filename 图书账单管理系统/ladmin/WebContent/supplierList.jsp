<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%@ page import="java.util.ArrayList"%>
           <%@ page import="com.domain.Supplier"%>
             <%@ page import="com.dao.SuppliersDao"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <h1>图书管理账单管理系统</h1>
       
        
    
    </header>
<% ArrayList<Supplier> suppliers=SuppliersDao.getInstance().selectallSuppliers();
 
if(suppliers==null) {
	suppliers=new ArrayList<Supplier>();
}
int recordCount=suppliers.size();//记录条数
int maxPage=recordCount;//页数
int number;   //第几页
if(maxPage%6==0) {
	maxPage=maxPage/6;
}else {
	maxPage=maxPage/6+1;
}

if(request.getParameter("i")==null) {
	number=1;
}else {
	number=Integer.parseInt(request.getParameter("i"));
}

int start=(number-1)*6;
int over=number*6-1;
if(recordCount<=over) {
	over=recordCount;	
}
request.setAttribute("start", start);
request.setAttribute("over", over);
request.setAttribute("number", number);
request.setAttribute("maxPage", maxPage);
request.setAttribute("recordCount", recordCount);
request.setAttribute("suppliers", suppliers);
        
    %>  
<!--主体内容-->
    <section class="publicMian ">
        
        <div >
           
            <div class="search">
                
               
              <a href="index.jsp">返回首页</a>
                 <a href="#">查看日志</a>
                 
              
                  <a href="SupplierServlet?method=0">显示全部</a>
              
     </div>
            <!--用户-->
            <table  class="providerTable" cellpadding="0" cellspacing="0" id="exportToExcel">
                <tr class="firstTr">
                    <th width="12%">供应商编码</th>
                    <th width="15%">供应商名称</th>                   
                    <th width="15%">供应商证书</th>
                     <th width="15%">供应商电话</th>               
                    <th width="15%">电子邮箱</th>
                    <th width="15%">供应商地址</th>
                      <th width="13%">操作</th>
                </tr>
               
             
                <c:forEach var="name" items="${suppliers }" begin="${start }" end="${over }">
	<tr >
	<td>${name.id}</td>
	<td>${name.suppliername}</td>
	<td>${name.suppliercertificate}</td>
	<td>${name.supplierpnumber}</td>
	<td>${name.supplieremail}</td>
	<td>${name.supplieraddress}</td>

	<td>
	<a href="#" class="removeUser"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="#" ><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="#" ><img src="img/schu.png" alt="删除" title="删除"/></a>
                        </td>
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
	  <a href="SupplierServlet?method=0&i=${number-1}">上一页</a>&nbsp;</td>
	  </c:when>
	   <c:otherwise>
	      上一页&nbsp;
	      
	  </c:otherwise>
	</c:choose>
	</td>
	<td>
	<c:choose>
	   <c:when test="${number<maxPage }">
	  <a href="SupplierServlet?method=0&i=${number+1}">下一页</a>&nbsp;</td>
	  </c:when>
	   <c:otherwise>
	      下一页&nbsp;
	  </c:otherwise>
	</c:choose>
 
	</tr>
	
	</table> 
	 <p></p>
    <div align="center">
  <%  
        String exportToExcel = request.getParameter("exportToExcel");  
        if (exportToExcel != null  
                && exportToExcel.toString().equalsIgnoreCase("YES")) {  
            response.setContentType("application/vnd.ms-excel");  
            response.setHeader("Content-Disposition", "inline; filename="  
                    + "supplierlist.xls");  
        }  
    %>  
  
   <%  
        if (exportToExcel == null) {  
    %>  
  <a href="supplierList.jsp?exportToExcel=YES">以Excel形式导出数据</a>
 
    <%  
        }  
    %>   </div>
    
    <div align="center">
    <p></p>
     。。。。。。。。。。。。。。。。。。。。。。。。
    <br />
    
    </div>
    
        </div>
    </section>
   
    

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>