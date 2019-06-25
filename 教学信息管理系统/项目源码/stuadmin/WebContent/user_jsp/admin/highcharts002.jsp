<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>人员数量分析</title>

		<style type="text/css">

		</style>
	</head>
	<body>
<script src="../../code/highcharts.js"></script>
<script src="../../code/modules/exporting.js"></script>
<script src="../../code/modules/export-data.js"></script>
<script src="../../locale/easyui-lang-zh_CN.js"></script>
<div id="container" style="min-width: 210px; height: 300px; max-width: 400px; margin: 0 auto"></div>

		<script type="text/javascript">
		
		
		
		
		
// Radialize the colors
Highcharts.setOptions({
    colors: Highcharts.map(Highcharts.getOptions().colors, function (color) {
        return {
            radialGradient: {
                cx: 0.5,
                cy: 0.3,
                r: 0.7
            },
            stops: [
                [0, color],
                [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
            ]
        };
    })
});

// Build the chart
Highcharts.chart('container', {
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    },
    title: {
        text: '人员信息分析图形'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                },
                connectorColor: 'silver'
            }
        }
    },
    series: [{
        name: 'Share',
        data: [
            { name: '学生', y: getCounts() },
            { name: '成绩', y: 11.84 },
            { name: 'Firefox', y: 10.85 },
            { name: 'Edge', y: 4.67 },
            { name: 'Safari', y: 4.18 },
            { name: 'Other', y: 7.05 }
        ]
    }]
});

// Apply the theme
var highchartsOptions = Highcharts.setOptions(Highcharts.theme);

//汉化图表菜单
Highcharts.setOptions({
    lang: {
        contextButtonTitle: "图表菜单",
        printChart: "打印图片",
        downloadJPEG: "下载JPEG 图片",
        downloadPDF: "下载PDF文档",
        downloadPNG: "下载PNG 图片",
        downloadSVG: "下载SVG 矢量图",
        exportButtonTitle: "导出图片"
    }
});


 function getCounts() {
	  
	 return 3;
	  
	
} 
   	
	  	$.ajax({
	  		 url:'tea_findcounts.action'
	  		 })
	  		 .done(function(response){
	  		 console.log("success"+JSON.stringify(response));
	  		 var products = JSON.stringify(response);
	  		 //这里能打印出json数据，但是上面的var products好像并不能被th中的editor使用data:products这样接受
	  		 alert(products);
	  		 })
	  		 .fail(function(){
	  		 console.log("error")
	  		 });
	 
	
		</script>
	</body>
</html>
