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
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <link rel="stylesheet" href="../css/courseInfo.css" />
  <style>
  	td{
  		width: 150px;
  		height: 2rem;
  		border: none;
  	}
  	.td_left{
  		font-family: "微软雅黑";
  		font-weight: bold;
  		font-size: 15px;
  		text-align: right;
  		line-height: 2rem;
  		padding-right: 0.5rem;
  	}
  </style>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>个人信息</legend>
	</fieldset>
	<table style="border: none; margin-left: 2rem; float: left;">
	  <tr>
	    <td class="td_left">教职工号:</td>
	    <td>HG20030624</td>
	  </tr>
	  <tr>
	    <td class="td_left">密码:</td>
	    <td><a>[更改密码]</a></td>
	  </tr>
	  <tr>
	    <td class="td_left">权限:</td>
	    <td>教师</td>
	  </tr>
	  <tr>
	    <td class="td_left">姓名:</td>
	    <td>张傲男</td>
	  </tr>
	  <tr>
	    <td class="td_left">性别:</td>
	    <td>女</td>
	  </tr>
	  <tr>
	    <td class="td_left">民族:</td>
	    <td>汉</td>
	  </tr>
	  <tr>
	    <td class="td_left">政治面貌:</td>
	    <td>九三学社社员</td>
	  </tr>
	  <tr>
	    <td class="td_left">联系方式:</td>
	    <td>15200128056</td>
	  </tr>
	</table>
	
	<table style="border: none; margin-right: 2rem;">
	  <tr>
	    <td class="td_left">教育程度:</td>
	    <td>博士</td>
	  </tr>
	  <tr>
	    <td class="td_left">参加工作日期:</td>
	    <td>2018-06-27</td>
	  </tr>
	  <tr>
	    <td class="td_left">教师类型:</td>
	    <td>专任</td>
	  </tr>
	  <tr>
	    <td class="td_left">职称:</td>
	    <td>教授</td>
	  </tr>
	  <tr>
	    <td class="td_left">校区:</td>
	    <td>校本部（南校区）</td>
	  </tr>
	  <tr>
	    <td class="td_left">任职状态:</td>
	    <td>退休返聘</td>
	  </tr>
	</table>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	
	
	
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px; clear: both;">
  <legend>帮助信息</legend>
</fieldset>
<div class="layui-collapse" lay-filter="test">
  <div class="layui-colla-item">
    <h2 class="layui-colla-title">发现个人信息有误？</h2>
    <div class="layui-colla-content">
      <p>当您发现的信息有误时，请联系院系一级管理、校级管理员或人事处进行信息更正</p>
    </div>
  </div>
</div>
<div class="layui-collapse" lay-filter="test">
  <div class="layui-colla-item">
    <h2 class="layui-colla-title">更改密码提示系统繁忙？</h2>
    <div class="layui-colla-content">
      <p>此情况是由于系统并发过高响应延迟，建议稍后再试</p>
    </div>
  </div>
</div>
          
<script src="layui/layui.js" charset="utf-8"></script>
<script>
layui.use(['element', 'layer'], function(){
  var element = layui.element;
  var layer = layui.layer;
});
</script>

</body>
</html>