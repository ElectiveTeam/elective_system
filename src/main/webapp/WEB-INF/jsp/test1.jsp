<%--
  Created by IntelliJ IDEA.
  User: 高伟萌
  Date: 2018/9/19
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/elective/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/elective/js/jquery_2.2.4.min.js"></script>
</head>

<body class="layui-layout-body">
<div class="layui-btn-container" style="margin-top: 20px;">
    <button class="layui-btn layui-btn-sm" id="importExcel">批量导入</button>
    <button class="layui-btn layui-btn-sm" id="theBatchExport">下载模板</button>
</div>
平时成绩占比：<input type="text"  lay-verify="required" autocomplete="off" class="layui-input" value="" id="usual">
期中成绩占比：<input type="text"  lay-verify="required" autocomplete="off" class="layui-input" value="" id="midterm">
技能考核占比：<input type="text"  lay-verify="required" autocomplete="off" class="layui-input" value="" id="skill">
期末成绩占比：<input type="text"  lay-verify="required" autocomplete="off" class="layui-input" value="" id="finalexam">
<script src="${pageContext.request.contextPath}/elective/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/elective/js/home_page/index.js"></script>
<script>
$(function () {
    $.ajax({
        url:'',
        type:'post',
        data:{
            
        },
        success:function () {
            
        }
    })
})
</script>
</body>

</html>
