<%--
  Created by IntelliJ IDEA.
  User: 张磊
  Date: 2019/1/14
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>选课情况统计图</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/elective/layui/css/layui.css" media="all">
</head>
<body>

<div class="layui-form" style="margin:0.75rem 0 0 0.75rem">
    <div class="layui-inline">
        <label class="layui-form-label">教师姓名：</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" placeholder="请输入教师姓名" id="teacherName">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">学期：</label>
        <div class="layui-input-inline">
            <select name="modules" id="termName">
                <option value="" selected="">请选择学期</option>
                <c:forEach items="${TermList}" var="TermList">
                    <option value="${TermList.termName}">${TermList.termName}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <button type="button" class="layui-btn" id="find"><i class="layui-icon">&#xe615</i></button>
</div>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 700px;height:400px;padding:3rem 0 0 3rem"></div>

<!-- 引入 ECharts 文件 -->
<script src="/elective/js/echarts.js"></script>

<script type="text/javascript" src="/elective/js/jquery_2.2.4.min.js"></script>

<script src="/elective/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use(['form','layer'], function () {
        var form = layui.form;
        var layer = layui.layer;

    })
    $("#find").click(function () {
        $.ajax({
            url:"${pageContext.request.contextPath }/statistics/findElectiveEcharts",
            type:"GET",
            data:{
                teacherName : $("#teacherName").val(),
                termName : $("#termName").val()
            },
            success : function(msg){
                console.log(msg);
                var status = msg.status;
                if(status==200){
                    var cuName = [];
                    var countNum = [];
                    for (i = 0; i < msg.data.length; i++) {
                        cuName.push(msg.data[i].cuName);
                        countNum.push(msg.data[i].countNum);
                    }
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('main'));
                    // 显示标题，图例和空的坐标轴
                    myChart.setOption({
                        title: {
                            text: '选课总人数统计图'

                        },
                        tooltip: {},
                        legend: {
                            data: ['人数']
                        },
                        xAxis: {
                            type: 'category',
                            data: cuName,
                        },
                        yAxis: {
                            type:'value'
                        },
                        series: [{
                            name: '人数',
                            type: 'bar',
                            data: countNum,
                            barMaxWidth : 30
                        }]
                    });
                }else {
                    $("#main").remove();
                    alert("暂无该老师数据");
                }
            },
            error : function(){
                console.log("失败");
            }
        })

    })
</script>
</body>
</html>
