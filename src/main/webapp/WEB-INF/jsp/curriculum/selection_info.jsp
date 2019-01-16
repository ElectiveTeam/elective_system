<%--
  User: Mr.Liu
  Date: 2019/1/10
  Time: 23:54
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>选课信息</title>
    <link rel="stylesheet" type="text/css" href="/elective/layui/css/layui.css">
    <script type="text/javascript" src="/elective/js/jquery_2.2.4.min.js"></script>
</head>

<body>
<div style="padding: 15px;">
    <div class="layui-form-item">
        <label for="cuName" class="layui-form-label">
            <span class="x-red">*</span>课程名称
        </label>
        <div class="layui-input-inline">
            <input type="text" id="cuName" disabled name="cuName"
                   autocomplete="off" class="layui-input" value="${ curriculum.curriculumName }"/>
        </div>
        <label for="teacherName" class="layui-form-label">
            <span class="x-red">*</span>授课人
        </label>
        <div class="layui-input-inline">
            <input type="text" id="teacherName" disabled name="teacherName" value="${ curriculum.teacherName }"
                   autocomplete="off" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label for="courseName" class="layui-form-label">
            <span class="x-red">*</span>分组名称
        </label>
        <div class="layui-input-inline">
            <input type="text" id="courseName" disabled name="courseName" value="${ curriculum.courseName }"
                   autocomplete="off" class="layui-input"/>
        </div>
        <label for="grade" class="layui-form-label">
            <span class="x-red">*</span>年级
        </label>
        <div class="layui-input-inline">
            <input type="text" id="grade" disabled name="grade" value="${ curriculum.grade }"
                   autocomplete="off" class="layui-input"/>
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
        <div class="layui-input-inline" style="width: 80%;">
            <input type="text" id="describe" disabled name="describe" value="${ curriculum.describe }"
                   autocomplete="off" class="layui-input" style="display: none"/>
        </div>
    </div>
    <hr class="layui-bg-blue">
    <form class="layui-form" action="">
        <input type="text" value="${ curriculum.selectionId }" name="id" hidden>
        <div class="layui-form-item">
            <label for="classTime" class="layui-form-label">
                <span class="x-red">*</span>上课时间
            </label>
            <div class="layui-input-inline">
                <input type="text" id="classTime" lay-verify="required" name="classTime"
                       value="${ curriculum.classTime }"
                       autocomplete="off" class="layui-input"/>
            </div>
            <label for="place" class="layui-form-label">
                <span class="x-red">*</span>上课地点
            </label>
            <div class="layui-input-inline">
                <input type="text" id="place" lay-verify="required" name="place" value="${ curriculum.place }"
                       autocomplete="off" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="minNumber" class="layui-form-label">
                最小人数
            </label>
            <div class="layui-input-inline">
                <input type="text" id="minNumber" placeholder="默认为30" name="minNumber"
                       value="${ curriculum.minNumber }"
                       autocomplete="off" class="layui-input"/>
            </div>
            <label for="maxNumber" class="layui-form-label">
                <span class="x-red">*</span>最大人数
            </label>
            <div class="layui-input-inline">
                <input type="text" id="maxNumber" lay-verify="required" name="maxNumber"
                       value="${ curriculum.maxNumber }"
                       autocomplete="off" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button class="layui-btn" id="btn" lay-filter="sub" lay-submit="">
                更新
            </button>
        </div>
    </form>
</div>
</body>
<script type="text/javascript" src="/elective/layui/layui.js"></script>
<script type="text/javascript" src="/elective/js/curriculum/selection_info.js"></script>
</html>
