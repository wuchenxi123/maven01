<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
		String ctx = request.getContextPath();
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 <script src="<%=ctx %>/admin/plugins/echart/echarts.js"></script>
</head>
<body>

</body>
<div><h4>市场分析</h4></div>
   <div id="bar" style="height:400px;width:800px;float:left"></div>
<!--    <div id="line" style="height:400px;width:800px;float:left"></div>
   <div id="pie" style="height:400px;width:800px;float:left"></div>
   <div id="lie" style="height:400px;width:800px;float:right"></div> -->
<script type="text/javascript"> 
var arr1=[];
var arr=[];
// 路径配置
require.config({
    paths: {
        echarts: '<%=ctx %>/admin/plugins/echart'
    }
});

// 使用
require(	
    [
        'echarts',
        'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
    ],
    function (ec) {

        // 基于准备好的dom，初始化echarts图表
        var myChart = ec.init(document.getElementById('bar')); 
        var option = {
            tooltip: {
                show: true
            },
            legend: {
                data:['销量']
            },
            xAxis : [
                {
                    type : 'category',
                    data :function(){
                        var arr=[];
                        $.ajax({
                        type : "POST",
                        async : false, //同步执行
                        url : ctx + '/cs_StatisticsIncome.ac',
                        data : {},
                        
                        success : function(data, textStatus, jqXHR) {
                   		if ("success" == textStatus) {
                   			for ( var i = 0; i < data.datas.length; i++) { 				
                   				arr.push(data.datas[i].csName);      
                   				arr1.push(parseInt(data.datas[i].sumIncome));   
                   			}	
                   			
                   		}       
                        
                    },
                    
                   })
                   return arr
                   }()
                },
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    "name":"销量",
                    "type":"bar",
                    "data":function(){
                        var arr=[];
                        $.ajax({
                        type : "POST",
                        async : false, //同步执行
                        url : ctx + '/cs_StatisticsIncome.ac',
                        data : {},
                        
                        success : function(data, textStatus, jqXHR) {
                   		if ("success" == textStatus) {
                   			for ( var i = 0; i < data.datas.length; i++) { 				
                   				arr.push(data.datas[i].csName);      
                   				arr1.push(parseInt(data.datas[i].sumIncome));   
                   			}	
                   			
                   		}       
                        
                    },
                    
                   })
                   return arr1
                   }()
                }
            ]
        };

        // 为echarts对象加载数据 
        myChart.setOption(option); 
    }
);
</script>
</html>