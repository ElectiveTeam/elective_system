<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>后台管理系统</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/elective/layui/css/layui.css"  media="all">
  <style type="text/css">
	input:-webkit-autofill {
	  -webkit-box-shadow: 0 0 0px 1000px white inset;
	  -webkit-text-fill-color: #333;
	}
  </style>
</head>
<body>
          
	<form class="layui-form" action="" lay-filter="example">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
		  <legend>课程基础信息配置</legend>
		</fieldset>
	
	  <div class="layui-form-item">
	  	
	    <label class="layui-form-label"><span style="color:red">*</span>课程名称:</label>
	    <div class="layui-input-inline">
	      <input type="text" name="cu_name" id="cu_name" lay-verify="cu_name" class="layui-input" style="border: none;" disabled="">
	    </div>
	    
	    <div class="layui-inline">
	      <label class="layui-form-label" ><span style="color:red">*</span>学时:</label>
	      <div class="layui-input-inline">
	        <input type="text" name="class_hour" id="class_hour" lay-verify="class_hour" class="layui-input" style="border: none;" disabled="">
	      </div>
	    </div>
	    
	    <div class="layui-inline">
	      <label class="layui-form-label" ><span style="color:red">*</span>学分:</label>
	      <div class="layui-input-inline">
	        <input type="text" name="credit" id="credit" lay-verify="credit" class="layui-input" style="border: none;" disabled=""> 
	      </div>
	    </div>
	    
	  </div>
	  
	  
	  <div class="layui-form-item">
	  	
	    <label class="layui-form-label"><span style="color:red">*</span>开设范围:</label>
	    <div class="layui-input-inline">
	      <input type="text" name="college" id="college" lay-verify="college" class="layui-input" style="border: none;" disabled="">
	    </div>
	    
	    <label class="layui-form-label"><span style="color:red">*</span>限选年级:</label>
	    <div class="layui-input-inline">
	      <input type="text" name="grade" id="grade" lay-verify="grade" class="layui-input" style="border: none;" disabled=""> 
	    </div>
	    
	  </div>
	  
	  
	  
	  
	  
	  
	  
	  <!--描述-->
	  <fieldset class="layui-elem-field">
		  <legend>课程描述</legend>
		  <div class="layui-field-box" id="page"></div>
		</fieldset>

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

<script type="text/javascript" src="${pageContext.request.contextPath}/elective/js/jquery_2.2.4.min.js" ></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/elective/layui/layui.js"></script>
<script>
	var cuName;//课程名称 
	var classHour;//学时
	var credit;//学分
	var college;//开设范围
	var grade;//限选年级
	var describe;//课程描述

	window.onload = function(){
	    //加载localsession中的信息
	    var information = sessionStorage.getItem('information');
		var info = JSON.parse(information);//把获取到的Json字符串转换回对象
		var cuName = info.cuName;//课程名称 
		var classHour = info.classHour;//学时
		var credit = info.credit;//学分
		var college = info.college;//开设范围
		var grade = info.grade;//限选年级
		var describe = info.describe;//课程描述
		document.getElementById("cu_name").value=cuName;
		document.getElementById("class_hour").value=classHour;
		document.getElementById("credit").value=credit;
		document.getElementById("college").value=college;
		document.getElementById("grade").value=grade;
		document.getElementById("page").innerHTML=describe;
    }
	layui.use(['form','element','layer'], function(){
	  var form = layui.form;
	  var element = layui.element;
	  var layer = layui.layer;
	  
	});
</script>

</body>
</html>