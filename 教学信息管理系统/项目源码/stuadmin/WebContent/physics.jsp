<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试页面</title>
<link rel="stylesheet" type="text/css"
	href="./themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
/*  function beforeSubmit() {
	var flag=confirm("确认提交");
	 if (flag=false) {
		return false;
	} 
	var form = document.getElementById("myForm");
	if(flag){
		form.submit();
	}
	
} */
 
$(function() {

	$('#checkbtn').bind('click', function() {
		//alert("checkbtn执行了");
		check();

	});

});

function check() {
	var getr = confirm("确认提交");		
	if (getr == true) {
		var form = document.getElementById('formCheck');
		//再次修改input内容
		form.submit();		
		
	}		
}		
		

//清空输入框
function clearvalue() {
	var getr = confirm("确认清空选项吗？ 清空之后所有选项为空");		
	 if (getr == true) {
	$(":input").not(":button", ":reset", "hidden",
			"submit").val("").removeAttr("checked").removeAttr("selected");
	} 
}

</script>
</head>
<body>
<table><tr><td ><font color=red >单选</font>题：</td><td>&nbsp;共<font color=red >${sessionScope.total}</font>道题目</td></tr></table> 
<form action="t_checkAnswer.action" name="testform" method="post" 
enctype="multipart/form-data"  id="formCheck">

	<c:forEach var="test" items="${sessionScope.list}"  varStatus="go">
		<table border="0" width=95%>
			<tr>
				<td style="height: 45px;">${go.count }、${test.test_question}</td>
			</tr>
			 <tr style="display: none;">
				<td><input type="radio"
				type="radio" name="${go.count }" value="无" style="margin-left: 15px;" checked="checked">默认的隐藏选项</td>
			</tr>
			 <tr>
				<td><input
				type="radio" name="${go.count }" value="A" style="margin-left: 15px;">A：${test.test_select_a}</td>
			</tr>
			<tr>
				<td> <input
				type="radio" name="${go.count }" value="B" style="margin-left: 15px;">B：${test.test_select_b}</td>
			</tr>
			<tr>
				<td><input
				type="radio" name="${go.count }" value="C" style="margin-left: 15px;">C：${test.test_select_c}</td>
			</tr>
			<tr>
				<td> <input
				type="radio" name="${go.count }" value="D" style="margin-left: 15px;">D：${test.test_select_d}</td>
			</tr>
			
		</table>
	<hr />
	</c:forEach>
	<p></p>
 <!-- <input  type="reset" value="清 &nbsp;空&nbsp;选&nbsp;项"  style="width: 300px;height: 40px">
  
     &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
     <input type="button"  value="确&nbsp;认&nbsp;提 &nbsp;交" onclick="beforeSubmit()"  style="width: 300px;height: 40px">  
      &nbsp; &nbsp; -->
      
      <div style="margin-bottom: 30px">
			&nbsp;
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cut'"
					onclick="clearvalue()" style="width: 37%; height: 32px">清除选项</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				 <a id="checkbtn" href="#"
					class="easyui-linkbutton" iconCls="icon-ok"
					style="width: 37%; height: 32px">确认提交</a>
				
			</div>
      <hr/> 
	
	
	
	</form>
</body>
</html>