<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>选课情况统计</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="/elective/layui/css/layui.css" media="all">
	</head>

	<body>
	
			<div class="layui-form" style="margin:0.75rem 0 0 20rem">
				<div class="layui-input-inline">
					<select name="modules" id="termName">
						<option value="" selected="">请选择学期</option>
						<c:forEach items="${TermList}" var="TermList">
							<option value="${TermList.termName}">${TermList.termName}</option>
						</c:forEach>

					</select>
				</div>
				<button type="button" class="layui-btn" id="find"><i class="layui-icon">&#xe615</i></button>
			</div>
	
		<!--柱状图 -->
		<div class="layui-btn-group demoTable" style="margin-top:0.75rem">
			<button type="button" class="layui-btn" id="getEcharts">选课情况柱状图</button>
		</div>

		<table class="layui-hide" id="test"></table>

		<script type="text/javascript" src="/elective/js/jquery_2.2.4.min.js"></script>
		<script src="/elective/layui/layui.js" charset="utf-8"></script>

		<!--
	作者：704816820@qq.com
	时间：2019-01-09
	描述：操作
-->
		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit">详情</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">停课</a>
		</script>

		<script>
		
			layui.use(['form', 'table'], function() {
				var form = layui.form;
				var table = layui.table;
				$("#find").click(function(){
					table.render({
						elem: '#test',
						width: 1050,
						where :{
							college : "1",
							termName : $("#termName").val()
						},
						url: "${pageContext.request.contextPath }/statistics/findElective",
						cols: [
							[{field: 'id',width: 100,title: '课程编号',align: 'center',sort: true}
							, {field: 'cuName',width: 200,title: '课程名称',align: 'center'}
							, {field: 'teacherName',width: 100,title: '任课教师',align: 'center'}
							, {field: 'classHour',width: 60,title: '学时',align: 'center'}
							, {field: 'credit',width: 60,title: '学分',align: 'center'}
							, {field: 'classTime',width: 180,title: '上课时间',align: 'center'}
							, {field: 'place',width: 100,title: '上课地点',align: 'center'}
							, {field: 'countNum',width: 100,title: '已选人数',align: 'center'	}
							, {title: '操作',toolbar: '#barDemo',width: 140,align: 'center'}]
						],
						done:function(msg){
							console.log(msg)
						},
						page: true
					});
				})
				

				//监听行工具事件
				table.on('tool(test)', function(obj) {
					var data = obj.data;
					//console.log(obj)
					if(obj.event === 'del') {
						layer.confirm('真的删除行么', function(index) {
							obj.del();
							layer.close(index);
						});
					} else if(obj.event === 'edit') {
						layer.alert('编辑行：<br>' + JSON.stringify(data))
					}
				});
			});
		
			
		</script>

	</body>

</html>