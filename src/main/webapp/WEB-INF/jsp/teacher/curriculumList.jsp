<%--
  User: 闫亮
  Date: 2019/1/15
  Time: 08:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>专业管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/elective/layui/css/layui.css"  media="all">
    <script type="text/javascript" src="${pageContext.request.contextPath}/elective/js/jquery_2.2.4.min.js" ></script>
</head>

<body>
	<div style="padding: 20px;">
		<form class="layui-form" action="">
			 <div class="layui-form-item">
			 	<!-- 学期筛选条件 
				 <label class="layui-form-label" style="text-align:left; width:40px; padding-left:0px;">学期</label>
				 <div class="layui-input-inline">
				   	<select name="term" id="term" lay-filter="term">
				      	<option value="" selected="">请选择学期</option>
				        <c:forEach items="${termName}" var="source">
				  			<option value="${source}">${source}</option>	
						</c:forEach>
				   </select>
				</div>-->
				<!-- 学期筛选条件 -->
				<label class="layui-form-label" style="text-align:left; width:40px; padding-left:0px;">状态</label>
				 <div class="layui-input-inline"><!-- layui-input-inline layui-input-block-->
				   	<select name="status" id="status" lay-filter="status">
				      	<option value="" selected="">请选择状态</option>
				        <option value="0">未提交</option>
				        <option value="1">待审核</option>
				        <option value="2">已核准</option>
				        <option value="3">被驳回</option>
				   </select>
				</div>
				<!-- 搜索 -->
				<div class="layui-input-inline"><!-- layui-input-inline layui-input-block-->
					<button type="button" class="layui-btn" id="search" data-type="reload" >搜索</button>
				</div>
			</div>
		</form>
		
		
		
		
		<button class="layui-btn" lay-submit="" id="add" name="add" lay-filter="add" onclink="add()">申请课程</button>
		  
	    <table id="application" lay-filter="application"></table>
	    
		<!--  <script type="text/html" id="barDemo">
        	<a class="layui-btn layui-btn-xs" lay-event="edit">查看详情</a>
        	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">打印名单</a>
    	</script>-->
    	<!-- 模板引擎文档 - layui.laytpl -->
    	<!--根据状态标志动态生成操作方法    0未提交  1待审核  2已核准  3被驳回 -->
	    <script type="text/html" id="barDemo">
        	{{# if (d.status == 0) { }}
        		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit">编辑详情</a>
        		<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="show">查看详情</a>
        	{{# } else if (d.status == 1) { }}
        		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="cancel">撤销申请</a>
				<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="show">查看详情</a>
			{{# } else if (d.status == 2) { }}
        		<a class="layui-btn layui-btn-xs" lay-event="print">打印名单</a>
				<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="show">查看详情</a>
			{{# } else if (d.status == 3) { }}
				<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit">编辑详情</a>
        		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="account">查看原因</a>
        	{{# } }}
    	</script>
    	<!--根据状态标志动态生成状态    0未提交  1待审核  2已核准  3被驳回 -->
    	
    	
	</div>
</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/elective/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use(['table','layer'], function(){
			  var table = layui.table;
			  var layer = layui.layer;
			  
			  table.render({
			    elem: '#application'//指定原始 table 容器的选择器或 DOM，方法渲染方式必填
			    ,id:'idTest'
			    ,url:'selectCurriculumPage?teacherId=<%= session.getAttribute("teacherWorknumber") %>&termName=<%= session.getAttribute("newName") %>' //异步数据接口相关参数。其中 url 参数为必填项
			    ,cols: [[//设置表头。值是一个二维数组。方法渲染方式必填
			    	//field	设定字段名。字段名的设定非常重要，且是表格数据列的唯一标识
			    	//type normal（常规列，无需设定） checkbox（复选框列） radio（单选框列） numbers（序号列）space（空列）
			    	//sort  是否允许排序（默认：false）。如果设置 true，则在对应的表头显示排序
			    	//fixed 固定列。可选值有：left（固定在左）、right（固定在右）。一旦设定，对应的列将会被固定在左或右，不随滚动条而滚动。注意：如果是固定在左，该列必须放在表头最前面；如果是固定在右，该列必须放在表头最后面。 
					//templet 自定义列模板，模板遵循 laytpl 语法。这是一个非常实用的功能，你可借助它实现逻辑处理，以及将原始数据转化成其它格式，如时间戳转化为日期字符等
					//toolbar 绑定列工具条。设定后，可在每行列中出现一些自定义的操作性按钮
					//unresize 是否禁用拖拽列宽（默认：false）。默认情况下会根据列类型（type）来决定是否禁用，如复选框列，会自动禁用。而其它普通列，默认允许拖拽列宽，当然你也可以设置 true 来禁用该功能。
			      	//edit 单元格编辑类型（默认不开启）目前只支持：text（输入框）
			      {field:'id', title:'编号', fixed: 'left', unresize: true}
			      ,{field:'termName', title:'学期', width:180}
			      ,{field:'cuName', title:'课程名称', width:170}
			      ,{field:'classHour', title:'学时'}
			      ,{field:'credit', title:'学分',}
			      ,{field:'college', title:'开设范围',width:170}
			      ,{field:'status', title:'状态', templet: function(d){
				    	if (d.status == 0){
				    		return '未提交';
				    	}else if (d.status == 1) {
				    		return '待审核';
				    	}else if (d.status == 2) {
				    		return '已核准';
				    	}else if (d.status == 3) {
				    		return '被驳回';
				    	}
				   	}
			      }
			      ,{field:'grade', title:'限选年级'}
			      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:160}
			    ]]
			    ,page: true
			  });
		    //监听行工具事件
		    table.on('tool(application)', function (obj) {
		        var data = obj.data.id;
		        if (obj.event === 'cancel') {
		            layer.confirm('是否确认撤销申请', function (index) {
		                //console.log(obj.data);
		                //console.log($('#id').val());
		                layer.close(index);
		                $.ajax({
		                    url: '${pageContext.request.contextPath}/teacher/updateStatus',
		                    type: "post",
		                    data: {
		                        id: obj.data.id
		                    }, success: function (data) {
		                    	if(data==1){
		                    		//删除对应行（tr）的DOM结构，并更新缓存obj.del();
									window.location.reload();//刷新当前页
			                        layer.msg("撤销成功");
		                    	}else{
		                    		layer.msg("撤销操作繁忙,请刷新页面后重试");
		                    	}
		                    }, error: function (data) {
		                        layer.msg("服务器繁忙,请稍后重试");
		                    }
		                })
		            });
		        } else if (obj.event === 'account') {
		            var remark = obj.data.remark;
		            if(remark==null){
		            	remark="审核人员未给出驳回原因，请联系院系或校级管理员咨询";
		            }
		            layer.open({
		            	title:'驳回原因',
		                content:remark,
		            });
		        } else if(obj.event === 'show'){
		        	var information = obj.data;
		        	//存入当前行信息到localstorysession
		        	sessionStorage.setItem('information', JSON.stringify(information));
		        	//打开窗口显示详情
		        	layer.open({
						  title: '课程申请详情'
						  ,type: 2
						  ,content: '${pageContext.request.contextPath}/teacher/show'
						  ,area: ['1050px', '550px']
					}); 
		        }else if(obj.event ==='edit'){
		        	var information = obj.data;
		        	//存入当前行信息到localstorysession
		        	sessionStorage.setItem('editInfor', JSON.stringify(information));
		        	//打开窗口显示详情
		        	layer.open({
						  title: '修改课程申请详情'
						  ,type: 2
						  ,content: '${pageContext.request.contextPath}/teacher/edit'
						  ,area: ['1050px', '550px']
					});
		        }else if(obj.event ==='print'){
		        	window.open('${pageContext.request.contextPath}/teacher/downloadExcel?id='+obj.data.id+'&cuName='+obj.data.cuName)
		        }
		    })
		});
		
		//弹出增加申请页面
		$("#add").click(function () {
			layer.open({
				  title: '申请课程'
				  ,type: 2
				  ,content: '${pageContext.request.contextPath}/teacher/courseAdd'
				  ,area: ['1050px', '550px']
			});     
		});
		
		//根据学期搜索课程
	    $("#search").click(function () {
	        reload();//重载
	    });
		
		//重载
		function reload() {
		    var table = layui.table;
		    if($('#status').val()=="" || $('#term').val()==""){
		    	layer.msg("请选择学期 / 状态");
		    }else{
		    	//执行重载
			    table.reload('idTest', {
			        url: 'selectCurriculumPage'
			        , where: { //设定异步数据接口的额外参数，任意设
			        	termName: '<%= session.getAttribute("newName") %>'
			        	,status:$('#status').val()
			        	,teacherId:'<%= session.getAttribute("teacherWorknumber") %>'
			        }
			        , page: true
			    });
		    };
		    
		}
	</script>
</html>
