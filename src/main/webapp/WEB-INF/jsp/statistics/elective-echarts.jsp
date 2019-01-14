<%--
  Created by IntelliJ IDEA.
  User: 张磊
  Date: 2019/1/14
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课统计图表</title>
    <!-- 引入 ECharts 文件 -->
    <script src="/elective/js/echarts.js"></script>
    <script type="text/javascript" src="/elective/js/jquery_2.2.4.min.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '选课人数统计图表'
        },
        tooltip: {},
        legend: {
            data:['人数']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '人数',
            type: 'bar',
            data: []
        }]
    };

    // 异步加载数据
    $.get('${pageContext.request.contextPath }/statistics/findElective').done(function (data) {
        // 填入数据
        myChart.setOption({
            xAxis: {
                data: data.cuName
            },
            series: [{
                // 根据名字对应到相应的系列
                name: '人数',
                data: data.countNum
            }]
        });
    });
</script>
</body>
</html>
