<%--
  User: Mr.Liu
  Date: 2019/1/10
  Time: 22:44
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>产品添加</title>
    <link rel="stylesheet" type="text/css" href="/js/layui/css/layui.css">
    <script type="text/javascript" src="/js/jquery-2.2.4-min.js"></script>
</head>

<body>
<div style="padding: 15px;">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label for="cuName" class="layui-form-label">
                <span class="x-red">*</span>课程名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="cuName" disabled name="cuName"
                       autocomplete="off" class="layui-input" value="${ curriculum.cuName }"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="teacherName" class="layui-form-label">
                <span class="x-red">*</span>授课人
            </label>
            <div class="layui-input-inline">
                <input type="text" id="teacherName" disabled name="teacherName" value="${ curriculum.teacherName }"
                       autocomplete="off" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="course.courseName" class="layui-form-label">
                <span class="x-red">*</span>分组名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="course.courseName" disabled name="course.courseName" value="${ curriculum.course.courseName }"
                       autocomplete="off" class="layui-input" style="display: none"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="grade" class="layui-form-label">
                <span class="x-red">*</span>年级
            </label>
            <div class="layui-input-inline">
                <input type="text" id="grade" name="grade" disabled value="${ curriculum.grade }"
                       autocomplete="off" class="layui-input" style="display: none"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="classHour" class="layui-form-label">
                <span class="x-red">*</span>课时
            </label>
            <div class="layui-input-inline">
                <input type="text" id="classHour" disabled name="classHour" value="${ curriculum.classHour }"
                       autocomplete="off" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="credit" class="layui-form-label">
                <span class="x-red">*</span>学分
            </label>
            <div class="layui-input-inline">
                <input type="text" id="credit" disabled name="credit" value="${ curriculum.credit }"
                       autocomplete="off" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="describe" class="layui-form-label">
                <span class="x-red">*</span>简介
            </label>
            <div class="layui-input-inline">
                <input type="text" id="describe" name="describe" value="${ curriculum.describe }"
                       autocomplete="off" class="layui-input" style="display: none"/>
            </div>
        </div>
    </form>
</div>
</body>
<script type="text/javascript" src="/elective/layui/layui.js"></script>
</html>

