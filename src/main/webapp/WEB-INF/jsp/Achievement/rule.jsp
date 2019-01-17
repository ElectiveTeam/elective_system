<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>成绩模块</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/elective/layui/css/layui.css"  media="all">
    <script src="/elective/js/jquery_2.2.4.min.js" charset="UTF-8"></script>
</head>
<body>
<div class="demoTable" style="text-align: center; margin-top: 15px;">
    课程名称：
    <div class="layui-inline">
        <input class="layui-input" name="cuName" id="cuName" value="" autocomplete="off">
    </div>
    <button class="layui-btn" id="search" data-type="reload">搜索</button>
</div>
<div class="layui-btn-container" style="margin-top: 20px;">
    <button class="layui-btn layui-btn-sm" id="add">添加规则</button>
</div>
<table id="test" lay-filter="test"></table>
</body>
</html>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script src="/elective/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script src="/elective/js/achievement/rule.js"></script>