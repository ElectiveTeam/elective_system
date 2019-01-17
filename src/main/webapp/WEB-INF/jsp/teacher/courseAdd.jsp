<%--
  User: 闫亮
  Date: 2019/1/9
  Time: 10:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>后台管理系统</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/elective/layui/css/layui.css"  media="all">
  <script type="text/javascript" src="${pageContext.request.contextPath}/elective/js/jquery_2.2.4.min.js" ></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/elective/ckeditor/ckeditor.js" ></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/elective/ckeditor/lang/zh-cn.js" ></script>
  <style type="text/css">
	input:-webkit-autofill {
	  -webkit-box-shadow: 0 0 0px 1000px white inset;
	  -webkit-text-fill-color: #333;
	}
  </style>
</head>
<body>
          
	<form class="layui-form" action="" >
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
		  <legend>课程基础信息配置</legend>
		</fieldset>
	
	  <div class="layui-form-item">
	  	
	    <label class="layui-form-label">课程名称</label>
	    <div class="layui-input-inline">
	      <input type="text" name="cu_name" id="cu_name" lay-verify="cu_name" placeholder="请输入标题（4-15字符）" class="layui-input" onblur="check()">
	    </div>
	    
	    <div class="layui-inline">
	      <label class="layui-form-label" >学时</label>
	      <div class="layui-input-inline">
	        <input type="text" name="class_hour" id="class_hour" lay-verify="class_hour" class="layui-input" placeholder="请输入学时（10-50学时）">
	      </div>
	    </div>
	    
	    <div class="layui-inline">
	      <label class="layui-form-label" >学分</label>
	      <div class="layui-input-inline">
	        <input type="text" name="credit" id="credit" lay-verify="credit" class="layui-input" placeholder="请输入学分（0.1-5.0学分）">
	      </div>
	    </div>
	    
	  </div>
	  
	   <div class="layui-form-item">
	  		<!-- 开设范围value为学期资源表id,可以作为课组外键 -->
		   <label class="layui-form-label">开设范围</label>
		  	<div class="layui-input-inline" onblur="check()">
			  	<select name="term_id" id="term_id" lay-verify="term_id">
				  	<option value="" selected="">请选择范围</option>
				  	<c:forEach items="${termlist}" var="source">
				  		<option value="${source.id}">${source.college}</option>	
					</c:forEach>
			     </select> 
		    </div>
		 
		  <div class="layui-inline" onblur="check()">
			  <label class="layui-form-label">限选年级</label>
			  	<div class="layui-input-inline"  style="margin-bottom: 5px; rgin-right: 10px;">
			      <select name="grade" id="grade" lay-verify="grade">
			        <option value="" selected="">请选择年级</option>
			        <option value="16级">16级</option>
			        <option value="17级">17级</option>
			        <option value="18级">18级</option>
			        <option value="全部">全部</option>
			      </select>
			    </div>
		  </div>
			 <div class="layui-inline" >
				   <label class="layui-form-label">课组限制</label>
				  	<div class="layui-input-inline layui-form" >
					  	<select name="cou_id" id="cou_id" lay-verify="cou_id">
						  	<option value="" selected="">请选择课组</option>
						  	<option value="0">创建默认课组</option>
					     </select> 
				    </div>
			  </div>
	  </div>
	  <div class="layui-form-item">
		  <div class="layui-form-item">
			  <label class="layui-form-label">课程描述</label>
			  <div class="layui-input-inline" style="width:79%;">
			  	<textarea id="describe" class="layui-textarea" style="display:block; width: 200px;"></textarea>
		      </div>
		  </div>
	  </div>


	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-submit="" lay-filter="apply">立即提交</button>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
	  </div>
	</form>
	
	
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px; clear: both;">
  <legend>帮助信息</legend>
</fieldset>
<div class="layui-collapse" lay-filter="test">
  <div class="layui-colla-item">
    <h2 class="layui-colla-title">关于开设范围</h2>
    <div class="layui-colla-content">
      <p>开设范围为当前时间本学期内开放选修课申请的二级学院和校级选修课申请</p>
    </div>
  </div>
</div>
<div class="layui-collapse" lay-filter="test">
  <div class="layui-colla-item">
    <h2 class="layui-colla-title">关于课组的定义</h2>
    <div class="layui-colla-content">
      <p>课组用于对课程进行分类，将同一科目，同一课程、不同教授人，相似课程，进行分类归组，若课组中不存在与课程相对应的课组将自动创建新的课组，若课组中存在相对应的或近似匹配的课组将提示选择其中一个课组加入或跳过课组选择将自动创建同课程名称课组</p>
    </div>
  </div>
</div>
<div class="layui-collapse" lay-filter="test">
  <div class="layui-colla-item">
    <h2 class="layui-colla-title">如果课程信息填写错误如何处理</h2>
    <div class="layui-colla-content">
      <p>系统设计中充分考虑到了容错机制的建立。1、当课程信息填写错误时可以前往取消申请、修改申请，取消申请的前提是申请未被审批；2、院系一级和校级管理员分别具有审批、调整修改院选课和校选课权利，当发现课程信息错误或不具备开设条件等原因时将驳回申请或修改申请，但申请被驳回仍然可以修改申请重新提交申请</p>
    </div>
  </div>
</div>
	 
<script src="${pageContext.request.contextPath}/elective/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>



	window.onload = function(){
	    CKEDITOR.replace('describe',{  
			filebrowserImageUploadUrl:'imageUpload',  
			language : 'zh-cn',  
		});
    }
	layui.use(['form','element','layer'], function(){
	  var form = layui.form;
	  var element = layui.element;
	  var layer = layui.layer;
	  
		//ajax动态获取课组根据学院和名称
		//layui.use 加载layui.define 定义的模块，
		//当外部 js 或 onclick调用 use 内部函数时，需要在 use 中定义 window 函数供外部引用
		window.check=function(){
			  var course_name = $('#cu_name').val();
			   var term_id = $('#term_id').val();
			   if(course_name == ""  ){
			    	layer.msg('请先填写课程名称');
			     	return false;
			   }
			   if(term_id == ""  ){
				    layer.msg('请先选择开设范围');
				    return false;
			   }
			   $.ajax({
		  		//接口地址
		  		url : "http://localhost:8080/teacher/selectCourse",
		  		type : "post",
		  		data : {course_name:course_name,
		  				term_id:term_id},
		  		dataType : "json",
		  		success : function(data){
		  			var item=$('#cou_id');
		  			item.empty();
		  			item.append('<option value="" selected="">请选择课组</option>');
		  			for (var i=0;i<data.length;i++){
		  				//alert('<option value="'+data[i].id+'">'+data[i].courseName+'</option>');
		  				item.append('<option value="'+data[i].id+'">'+data[i].courseName+'</option>');
		  				//有些时候，你的有些表单元素可能是动态插入的。这时 Form模块的自动化渲染是会对其失效的。
		  				//虽然我们没有双向绑定机制（因为我们叫经典模块化框架，偷笑.gif） 但没有关系，
		  				//你只需要执行 form.render(type, filter); 方法即可。
		  			}
		  			item.append('<option value="0" >创建默认课组</option>');
		  			form.render();
		  		},error: function(msg){
		  			$("#msg").text("服务器繁忙，请稍后再试！");
		  		}
		  	});
		}
	  
	  
	  
	  
	  
	  //自定义验证规则
	  form.verify({
		cu_name: function(value){
	      if(value.length < 4){
	        return '课程名称少于4个字符';
	      }
	      if(value.length > 15){
		    return '课程名称大于15个字符';
		  }
	    }
	    ,class_hour:function(value){
	    	if(!(/^[1-5][0-9]$/.test(value))){
	    		return '学时格式错误';
	    	}
	    	if(value<10){
	    		return '学时不能少于10学时';
	    	}
	    	if(value>50){
	    		return '学时不能大于50学时';
	    	}
	    }
	    ,credit: function(value){
	    	if(!(/^[0-5].?[0-9]?$/.test(value))){
	    		return '学分格式错误';
	    	}
	    	if(value<0.1){
	    		return '学分不能少于0.1学分';
	    	}
	    	if(value>5){
	    		return '学分不能大于5学分';
	    	}
	    }
	    ,grade: function(value){
	    	if(value==''){
	    		return '请选择限选年级';
	    	}
	    }
	    ,term_id: function(value){
	    	if(value==''){
	    		return '请选择开设范围';
	    	}
	    }
	    ,cou_id: function(value){
	    	if(value==''){
	    		return '请选择课组限制';
	    	}
	    }
	  });
	  //监听提交
	  form.on('submit(apply)', function(){
		  	//课程名称
		  	var cu_name = $('#cu_name').val();
		  	//学时
		  	var class_hour = $('#class_hour').val();
		  	//学分
		  	var credit = $('#credit').val();
		  	//学期资源表外键（学院字段 ）
		  	var term_id = $('#term_id').val();
		  	//年级
		  	var grade = $('#grade').val();
		  	//课组外键
		  	var cou_id = $('#cou_id').val();
		  	//状态（0编辑、1未审核、2已通过、3未通过）
		  	var status=0;
		  	//描述
		  	var describe = CKEDITOR.instances.describe.getData();
		  	//教师id,从session获取
		  	var teacher_id=1;
		  	//教师姓名,从session获取
		  	var teacher_name='张某某';
		  	
		  	var param={cuName:cu_name,classHour:class_hour,credit:credit,termId:term_id,grade:grade,couId:cou_id,status:status,describe:describe,teacherId:teacher_id,teacherName:teacher_name}
	        $.ajax({
	          url:"http://localhost:8080/teacher/addCurriculum",
	          type:'post',//method请求方式，get或者post
	          data:JSON.stringify(param),//表格数据序列化
	          contentType: "application/json; charset=utf-8",
	          dataType : "text",
	          success:function(res){//res为相应体,function为回调函数
	            	//layer.msg('提示',{time:10*1000},function() {
	            		//回调
	            	//})
	            	layer.msg("添加课程信息成功!");
	          },
	          error:function(){
	        	  layer.msg("添加课程信息失败！");
	        	  //layer.msg('操作失败！');
	          }
	        });
	        $.post();//阻止layui 默认get提交
	        return false;
	  });
	 
	});
	
	 
	
</script>

</body>
</html>