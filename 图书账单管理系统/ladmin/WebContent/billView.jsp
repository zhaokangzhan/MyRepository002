<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="java.net.URLEncoder"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>图书账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <style type="text/css">  
<!--  
#input1{border:1px solid #0000FF}  
#btn1{width:70px;height:21px;font-size:12px;padding-top:3px;border-left:1px solid #FFFFFF;border-top:1px solid #FFFFFF;border-

right:1px solid #666666;border-bottom:1px solid #666666}  
//-->  

</style> 
</head>
<body>
<!--头部-->
<header class="publicHeader">
   <title>图书账单管理系统</title>

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
                    <li id="active"><a href="#">账单管理</a></li>
                    <li><a href="SupplierServlet?method=0">供应商管理</a></li>
                    <li><a href="#">用户管理</a></li>
                   <li><a href="billView.jsp">文件管理</a></li>
                    <li><a href="LogoutServlet">退出系统</a></li>
                </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>信息管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
          
           
           
              
            <form action="UploadServlet" method="post" 
      enctype="multipart/form-data">
      
      
 		  <p><strong>上传者
 				<input type="text" name="name" /></strong><span>1</span></p>
 				
 				
					   <p><strong>上传文件
 				<input type="file" onchange='PreviewImage(this)' /></strong><span>2</span>
 	
 				</p>
 	
 			
 				
 		 <div  id="imgPreview" style='width:150px; height:200px;'> 
    <img src=""/> 
   </div> 
 		
 			 <p><input type="submit" value="上传" />
 	
 			 <a href="/ladmin/DownloadServlet?filename=<%=URLEncoder.encode("zhao.jpg", "utf-8")%>">文件下载 </a>
 				 </p> 
 	</form>
 	 
          
          
        </div>
       
    </div>
</section>
<footer class="footer">
</footer>
<script> 
   function PreviewImage(imgFile) 
   { 
    var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;      
    if(!pattern.test(imgFile.value)) 
    { 
     alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");  
     imgFile.focus(); 
    } 
    else 
    { 
     var path; 
     if(document.all)//IE 
     { 
      imgFile.select(); 
      path = document.selection.createRange().text; 
      document.getElementById("imgPreview").innerHTML=""; 
      document.getElementById("imgPreview").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\"" + path + "\")";//使用滤镜效果 
     } 
     else//FF 
     { 
      path = URL.createObjectURL(imgFile.files[0]);
      document.getElementById("imgPreview").innerHTML = "<img src='"+path+"'/>"; 
     } 
    } 
   } 
  </script> 
<script src="js/time.js"></script>
<script type="text/javascript">
/*
**1.直接在上面的htnl中写和在下面写时一样的效果
**2.input1文本框可以是有背景图片的
**3.btn1即浏览按钮可以是图片

  $('#myfile').die('change').live('change',function(){
          $('#input1').val($(this).val());
         })
   
  $('#btn1').die('click').live('click',function(){
       $('#myfile').click();
       $('#input1').val($('#myfile').val());
      })
  */

</script>
</body>
</html>