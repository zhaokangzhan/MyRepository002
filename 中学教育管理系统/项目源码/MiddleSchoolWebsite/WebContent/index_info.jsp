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
		<script type="text/javascript">
		function fileType(obj){
		    var fileType=obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();//获得文件后缀名
		    if(fileType != '.gif' && fileType != '.png' && fileType != '.jpg' && fileType != '.jpeg'){
		        $(obj).tips({
		            side:3,
		            msg:'请上传图片格式的文件',
		            bg:'#AE81FF',
		            time:3
		        });
		        $(obj).val('');
		    }else{
		         var reader = new FileReader();
		         reader.readAsDataURL(obj.files[0]);
		         reader.onload = function (e) { 
		            $("#img").attr("src",this.result);
		         }
		         $("#tu").show();
		    }
		}
		</script>
  </head>
  <body>
    
<div id="outline" style="border:rosybrown double;margin: 0% 1% 0% 1%;background-color: #D3D4D4;" >

    <h3 align="center">添&nbsp;加&nbsp;首&nbsp;页&nbsp;信&nbsp;息</h3> 
   
  <table align="center" style="margin-bottom:2%;" border="0">
	<tr align="center" bgcolor="#EEEEEE" >
	<td >信息标题:</td><td align="center" width="13%"><input  type="text"   style="width:99%;" />
	</td><td>关键字:</td><td align="center" width="45%"><input type="text"   style="width:99%;" />
	</td><td align="center"><input type="submit" value="&nbsp;搜&nbsp;&nbsp;索&nbsp;" 
	style="width:98%;"></td><td align="center" >
	<span style="float: right;margin:2px 30px 4px 1px;align-content: center;">
	<a href="index_info.jsp" 
	target="admin_welcome" style="margin-right: 10px;"><img src="img/tianjia.png" alt="添加" title="添加" />&nbsp;</a><a href="index_info.jsp" 
	target="admin_welcome" style="margin-right: 10px;">添加信息</a></span>
</td>
 </tr> 
  </table>

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
	<td >
	
	
	    <span id="tu" <c:if test="${pd == null || pd.CACHET == '' || pd.CACHET == null}">style="display: none;"</c:if>>
            <img id="img" src="uploadFiles/carousel/${pd.CACHET}" width="210"/>
       </span>
         <input type="button" class="update" id="yyzz" value="浏览上传图片" onclick="$('#YYZZFBSMJ').click();">
         <input type="file"  name="newsinfofabu" id="YYZZFBSMJ" style="display: none;" onchange="fileType(this)">
	
	
	
	</td>            
	</tr>	
	<tr height="20px">	
	<td colspan="3"><input type="reset"  style="margin-left:32%;margin-top:4px;margin-bottom:5px" value="清空信息" />
	<input type="submit"  style="margin-left:10%;" value="提交信息" />
	
            
	</td>  	       
	</tr>
</table>
  </form>
           
<hr />	
	
		
	</body>

</html>