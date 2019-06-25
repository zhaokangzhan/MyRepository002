<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>人员数量分析</title>
	<link rel="stylesheet" type="text/css"
	href="../../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../../themes/icon.css">
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/template-web.js"></script>
<script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../locale/easyui-lang-zh_CN.js"></script>
<script src="../../code/highcharts.js"></script>
<script src="../../code/modules/exporting.js"></script>
<script src="../../code/modules/export-data.js"></script>
	</head>
	<body>
	

<div id="container" style="min-width: 210px; height: 300px; max-width: 400px; margin: 30px 20px"></div>

		<script type="text/javascript">
		
		
		$(function(){
			   $.ajax({
			  		url:"per_personCounts.action",
			  		type:"get",
			  		tataType:"json",
			  		success:function(num){
			  			console.log(num);
			  			var jnum=JSON.parse( num );
			  			console.log("jnum="+jnum);
			  			console.log("jnum[0]="+jnum[0]);
			  			console.log("jnum[1]="+jnum[1]);
			  			var stu=parseInt(jnum[0]);
			  			var tea=parseInt(jnum[1]);
			  			var dean=parseInt(jnum[2]);
			  			var user=parseInt(jnum[3]);
			  			var other=parseInt(jnum[4]);
			  			
			  			 console.log("parseInt(jnum[0])="+parseInt(jnum[0]));  
			  				getcounts(stu,tea,dean,user,other);
			
			  			
			  		}
			  	})	

		   })
		


 function getcounts(stu,tea,dean,user,other) {
		
	  	
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
			        name: '占比',
			        data: [
			            { name: '教师', y: tea },
			            { name: '学生', y: stu },
			            { name: '教务员', y: dean },
			            { name: '一般用户', y: user },
			            { name: '其它', y: other },
			           
			        ]
			    }]
			});

	
} 
   	
   		/* $.ajax({
	  		 url:'tea_findcounts.action'
	  		 })
	  		 .done(function(response){
	  		 console.log("success"+JSON.stringify(response));
	  		 var products = JSON.stringify(response);
	  		 //这里能打印出json数据，但是上面的var products好像并不能被th中的editor使用data:products这样接受
	  		  alert(products);
	  		 alert(products);
	  		 })
	  		 .fail(function(){
	  		 console.log("error")
	  		 }); */
   
				
				
	
		</script>
	</body>
</html>
