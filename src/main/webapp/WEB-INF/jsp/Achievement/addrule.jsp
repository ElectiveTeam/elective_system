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
<div style="padding: 15px;">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">课程</label>
            <div class="layui-input-inline">
                <select name="quiz" id="curriculum">
                    <option value="">请选择课程</option>
                    <c:forEach items="${curriculumList}" var="courseList">
                        <c:choose>
                            <c:when test="${curriculumList.cuName==cuName}">
                                <option value="${curriculumList.selectId}" selected>${curriculumList.cuName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${curriculumList.selectId}">${curriculumList.cuName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <label class="layui-form-label">
            <span class="x-red">*</span>课程名称
        </label>
        <div class="layui-input-inline">
            <select name="cuName" lay-filter="cuName">
            </select>
        </div>
        <label for="usual" class="layui-form-label">
            <span class="x-red">*</span>平时成绩
        </label>
        <div class="layui-input-inline">
            <input type="text" id="usual" disabled name="usual"
                   autocomplete="off" class="layui-input" value=""/>
        </div>
        <label for="midTerm" class="layui-form-label">
            <span class="x-red">*</span>期中成绩
        </label>
        <div class="layui-input-inline">
            <input type="text" id="midTerm" disabled name="midTerm"
                   autocomplete="off" class="layui-input" value=""/>
        </div>
        <label for="skill" class="layui-form-label">
            <span class="x-red">*</span>技能考核
        </label>
        <div class="layui-input-inline">
            <input type="text" id="skill" disabled name="skill"
                   autocomplete="off" class="layui-input" value=""/>
        </div>
        <label for="finalexam" class="layui-form-label">
            <span class="x-red">*</span>期末成绩
        </label>
        <div class="layui-input-inline">
            <input type="text" id="finalexam" disabled name="finalexam"
                   autocomplete="off" class="layui-input" value=""/>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button class="layui-btn" id="btn" lay-filter="sub" lay-submit="">
                增加
            </button>
        </div>
    </div>
</div>
</body>
</html>
<script src="/elective/layui/layui.js" charset="utf-8"></script>
<script src="/elective/js/achievement/addrule.js"></script>