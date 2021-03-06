<%--
  User: Mr.Liu
  Date: 2019/1/10
  Time: 15:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>课程管理</title>
    <link rel="stylesheet" type="text/css" href="/elective/layui/css/layui.css">
    <script type="text/javascript" src="/elective/js/jquery_2.2.4.min.js"></script>
</head>

<body>
<div style="padding: 15px;">
    <div class="demoTable" style="text-align: center; margin-top: 15px;">
        职工号：
        <div class="layui-inline">
            <input class="layui-input" name="categoryName" id="categoryName" value="" autocomplete="off">
        </div>
        <button class="layui-btn" id="search" data-type="reload">搜索</button>
    </div>
    <table id="major" lay-filter="test"></table>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" id="courseButton_edit" lay-event="edit">编辑</a>
    </script>
</div>
</body>
<script type="text/javascript" src="/elective/layui/layui.js"></script>
<script type="text/javascript" src="/elective/js/power/power.js"></script>
</html>
<script type="text/html" id="show">
    {{# if (d.status == 1) { }}
    未审核
    {{# } else if (d.status == 2) { }}
    已通过
    {{# } else if (d.status == 3) { }}
    未通过
    {{# } }}
</script>
