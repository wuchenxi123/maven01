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
	<section class="content">
	<div class="row">
		<div class="col-xs-12">
		<div><h4>市场分析</h4></div>
	   		<div id="bar" style="height:400px;width:800px;float:left"></div>
	   		<div id="line" style="height:400px;width:800px;float:left"></div>
	   		<div id="pie" style="height:400px;width:800px;float:left"></div>
	   	<div id="lie" style="height:400px;width:800px;float:left"></div>
	   	</div>
	 </div>
   	</section>
 
<script type="text/javascript">
var arr1=[];
var arr=[];
var arr2=[];
function csName(){
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
			}	
			
		}       
    
},

})
return arr
};
require.config({
    paths: {
    	echarts: '<%=ctx %>/admin/plugins/echart'
    }
});

// 使用
require(
    [
        'echarts',
        'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加载
        'echarts/chart/line', // 使用柱状图就加载bar模块，按需加载
        'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
    ],
    DrawCharts  
    );
	function DrawCharts(ec) {  
	    FunDraw1(ec);  
	    FunDraw2(ec);  
	  /*   FunDraw3(ec);   */
	}  
    function FunDraw1(ec) {	
        // 基于准备好的dom，初始化echarts图表
        var myChart = ec.init(document.getElementById('bar')); 
        
        var option = {
            tooltip: {
                show: true
            },
            legend: {
                data:['班级收入']
            },
            xAxis : [
                {
                    type : 'category',
                    data :csName()
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    "name":"班级收入",
                    "type":"bar",
                    "data":function(){
                        $.ajax({
                        type : "POST",
                        async : false, //同步执行
                        url : ctx + '/cs_StatisticsIncome.ac',
                        data : {},
                        
                        success : function(data, textStatus, jqXHR) {
                   		if ("success" == textStatus) {
                   			for ( var i = 0; i < data.datas.length; i++) { 				
                   				
                   				arr2.push(parseInt(data.datas[i].sumIncome));   
                   			}	
                   			
                   		}       
                        
                    },
                    
                   })
                   return arr2
                   }()
                }
            ]
        };

        // 为echarts对象加载数据 
        myChart.setOption(option); 
    };
    function FunDraw2(ec) {	
        // 基于准备好的dom，初始化echarts图表
        var myChart = ec.init(document.getElementById('line')); 
        
        var option = {
            tooltip: {
                show: true
            },
            legend: {
                data:['报名人数']
            },
            xAxis : [
                {
                    type : 'category',
                    data : csName()
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    "name":"报名人数",
                    "type":"line",
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
                   				
                   				arr1.push(parseInt(data.datas[i].csPeoplecount));   
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
    };
    function FunDraw3(ec) {	
        // 基于准备好的dom，初始化echarts图表
        var myChart = ec.init(document.getElementById('pie')); 
        
        option = {
        	    title : {
        	        text: '学校学员来源分布',
        	        subtext: '测试数据',
        	        x:'center'
        	    },
        	    tooltip : {
        	        trigger: 'item',
        	        formatter: "{a} <br/>{b} : {c} ({d}%)"
        	    },
        	    legend: {
        	        orient : 'vertical',
        	        x : 'left',
        	        data:['宁乡','株洲','长沙','常德','衡阳']
        	    },
        	    toolbox: {
        	        show : true,
        	        feature : {
        	            mark : {show: true},
        	            dataView : {show: true, readOnly: false},
        	            magicType : {
        	                show: true, 
        	                type: ['pie', 'funnel'],
        	                option: {
        	                    funnel: {
        	                        x: '25%',
        	                        width: '50%',
        	                        funnelAlign: 'left',
        	                        max: 1548
        	                    }
        	                }
        	            },
        	            restore : {show: true},
        	            saveAsImage : {show: true}
        	        }
        	    },
        	    calculable : true,
        	    series : [
        	        {
        	            name:'访问来源',
        	            type:'pie',
        	            radius : '55%',
        	            center: ['50%', '60%'],
        	            data:[
        	                {value:335, name:'宁乡'},
        	                {value:310, name:'株洲'},
        	                {value:234, name:'长沙'},
        	                {value:135, name:'常德'},
        	                {value:1548, name:'衡阳'}
        	            ]
        	        }
        	    ]
        	};
        	                    

        // 为echarts对象加载数据 
        myChart.setOption(option); 
    };
</script>
</body>
</html>