<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>测试成绩统计分析</title>

<style type="text/css">
</style>
</head>
<body>
	<script src="../../code/highcharts.js"></script>
	<script src="../../code/modules/data.js"></script>
	<script src="../../code/modules/exporting.js"></script>
	<script src="../../code/modules/export-data.js"></script>
<div id="winCheck" class="easyui-panel" 
		style="width: 900px; height: 300px"
		data-options="style:{position:'absolute'}">	
	
	<div id="container"
		style="min-width: 200px; height: 400px; margin: 0 auto">
		<table id="datatable" style="display: hidden">
		<thead>
			<tr>
				<th></th>
				<th>各分数段人数(单位：个/人)</th>
				 
			</tr>			
		</thead>
		<tbody align="center">
			<tr>
				<th>0~49：${sessionScope.dscore[0] }</th>
				<td>${sessionScope.dscore[0] }</td>
				<%-- <td>${sessionScope.dscore[4] }</td>   --%>
			</tr>
			<tr>
				<th>50~59：${sessionScope.dscore[1] }</th>
				<td>${sessionScope.dscore[1] }</td>
				<!--  <td>4</td> -->
			</tr><tr>
				<th>60~69：${sessionScope.dscore[2] }</th>
				<td>${sessionScope.dscore[2] }</td>
				<!--  <td>4</td> -->
			</tr><tr>
				<th>70~79：${sessionScope.dscore[3] }</th>
				<td>${sessionScope.dscore[3] }</td>
				<!--  <td>4</td> -->
			</tr>
			<tr>
				<th>80~89：${sessionScope.dscore[4] }</th>
				<td>${sessionScope.dscore[4] }</td>
				<!--  <td>4</td> -->
			</tr>
			<tr>
				<th>90~100：${sessionScope.dscore[5] }</th>
				<td>${sessionScope.dscore[5] }</td>
				<!--  <td>4</td> -->
			</tr>
		<tr>
				<th>其它情况：${sessionScope.dscore[6] }</th>
				<td>${sessionScope.dscore[6] }</td>
				<!--  <td>4</td> -->
			</tr>
		</tbody>
	</table></div>

	

</div>
	<script type="text/javascript">
	
	
Highcharts.chart('container', {
    data: {
        table: 'datatable'
    },credits: {
    	enabled: false     //不显示LOGO
    },
    chart: {
        type: 'column'
    },
    title: {
        text: '学生测试成绩统计分析'
    },
    yAxis: {
    	min:0,
    	tickIterval:15,
    	max:90,
        allowDecimals: false,
        title: {
            text: '人数'
        }
    },
    tooltip: {
        formatter: function () {
            return '<b>' + this.series.name + '</b><br/>' +
            this.point.name.toLowerCase()  ;
        }
    }
   
});
		</script>
</body>
</html>
