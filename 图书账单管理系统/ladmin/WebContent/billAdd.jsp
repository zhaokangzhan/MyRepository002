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
        <p><span>您好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
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
            <span>账单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
            <form method="post" action="/ladmin/BookServlet?method=4">
                <!--div的class 为error是验证错误，ok是验证成功-->
               
                 <div>
                    <label for="billlabel">图书标签：</label>
                    <input type="text" name="bookid" required/>
                    <span >*请输入图书标签</span>
                </div>
                <div>
                    <label for="billName">商品名称：</label>
                    <input type="text" name="bookname" required/>
                    <span >*请输入图书名称</span>
                </div>
                <div>
                    <label for="billCom">作者：</label>
                    <input type="text" name="author" required/>
                    <span>*请输入作者名称</span>

                </div>
               <div>
                    <label >供应商：</label>
                    <select name="print" >
                        <option value="">--请选择相应的出版社--</option>
                        <option value="新华出版社">新华出版社</option>
                        <option value="天津出版社">天津出版社</option>

                    </select>
                    <span>*请选择出版社</span>
                </div>
                <div>
                    <label for="money">金额：</label>
                    <input type="text" name="price" required/>
                    <span>*请输入大于0的正自然数，小数点后保留2位</span>
                </div>
               
                <div>
                    <label >是否付款：</label>
                    <input type="radio"  name="tip" checked value="已付款"/>未付款
                    <input type="radio" name="tip" value="未付款"/>已付款
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.html">返回</a>-->
                   
                     <a href="BookServlet?method=0">返&nbsp;回</a>
                     &nbsp;  
                      <input type="submit" value="保存" />
                     
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>