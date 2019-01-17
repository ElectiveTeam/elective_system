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
    <div class="layui-form">
        <div class="layui-inline">
            <label class="layui-form-label">*课程</label>
            <div class="layui-input-inline">
                <select id="curriculum" lay-verify="required" >
                    <option value="">请选择课程</option>
                    <c:forEach items="${curriculumList}" var="curriculumList">
                        <c:choose>
                            <c:when test="${curriculumList.cuName==cuName}">
                                <option value="${curriculumList.id}" selected>${curriculumList.cuName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${curriculumList.id}">${curriculumList.cuName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label for="usual" class="layui-form-label">
                <span class="x-red"></span>平时成绩
            </label>
            <div class="layui-input-inline">
                <input type="text" id="usual" name="usual"
                       autocomplete="off" class="layui-input" value=""/>
            </div>
        </div>
        <div class="layui-inline">
            <label for="midTerm" class="layui-form-label">
                <span class="x-red"></span>期中成绩
            </label>
            <div class="layui-input-inline">
                <input type="text" id="midterm" name="midterm"
                       autocomplete="off" class="layui-input" value=""/>
            </div>
        </div>
        <div class="layui-inline">
            <label for="skill" class="layui-form-label">
                <span class="x-red"></span>技能考核
            </label>
            <div class="layui-input-inline">
                <input type="text" id="skill" name="skill"
                       autocomplete="off" class="layui-input" value=""/>
            </div>
        </div>
        <div class="layui-inline">
            <label for="finalexam" class="layui-form-label">
                <span class="x-red"></span>期末成绩
            </label>
            <div class="layui-input-inline">
                <input type="text" id="finalexam" name="finalexam"
                       autocomplete="off" class="layui-input" value=""/>
            </div>
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