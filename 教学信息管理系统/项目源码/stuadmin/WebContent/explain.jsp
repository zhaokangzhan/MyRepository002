<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试题解释</title>
<link rel="stylesheet" type="text/css"
	href="./themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
function beforeSubmit() {
	var flag=confirm("确认提交");
	/* if (flag=false) {
		return false;
	} */
	var form = document.getElementById("myForm");
	if(flag){
		form.submit();
	}
	
}
</script>
</head>
<body>


<table><tr><td ><font color=red >单选</font>题解释：</td><td>&nbsp;共<font color=red >${sessionScope.total}</font>道题目</td></tr></table> 
<form action="t_checkAnswer.action" name="testform" method="post" 
enctype="multipart/form-data" onsubmit="return beforeSubmit()" id="myForm">

	<c:forEach var="test" items="${sessionScope.list}"  varStatus="go">
		<table border="0" width=95%>
			<tr>
				<td style="height: 45px;">${go.count }、${test.test_question}</td>
			</tr>
			
			 <tr>
				<td>答案：<span style="color: red;font-size:15px;">${test.test_answer}</span></td>
			</tr>
		 <tr>
				<td>解释：${test.test_explain}</td>
			</tr>
			
		</table>
	<hr />
	</c:forEach>

	
	
	</form>
</body>
</html>