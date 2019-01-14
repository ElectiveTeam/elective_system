<%--
  Created by IntelliJ IDEA.
  User: SongJunWei
  Date: 2019/1/9
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/elective/layui/css/layui.css"  media="all">
    <script src="/elective/js/jquery_2.2.4.min.js" charset="UTF-8"></script>
</head>
<body>
<div class="layui-collapse" lay-filter="test"></div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <%--<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
</script>
<script type="text/html" id="status">
        {{#  if(d.status==1){ }}
        未审核
        {{# } else if(d.status==2) { }}
        已通过
        {{#  } else { d.status==3}}
        未通过
        {{#  } }}
</script>
</body>
</html>
<script src="/elective/layui/layui.js" charset="utf-8"></script>
<script src="/elective/js/course/course.js" charset="utf-8"></script>