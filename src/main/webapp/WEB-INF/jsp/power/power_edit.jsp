<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 李世奇
  Date: 2019/1/17
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="/elective/layui/css/layui.css">
    <script type="text/javascript" src="/elective/js/jquery_2.2.4.min.js"></script>
</head>
<body>
<form class="layui-form" action="" style="margin-top: 20px">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">职工编号</label>
            <div class="layui-input-inline">
                <input type="text" id="worknumber" value="${params.worknumber}" lay-verify="" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">教师名称</label>
            <div class="layui-input-inline">
                <input type="text" name="teaName" value="${params.teaName}" lay-verify="" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
                <input type="text" name="teaSex" value="${params.teaSex}" lay-verify="" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div hidden id="powers">${params.teaPower}</div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">请选择授权</label>
            <div class="layui-input-inline">
                <select name="modules" id="myCollege" lay-verify="required" lay-search="">
                </select>
            </div>
        </div>
    </div>
    <div style="margin-left: 70px;margin-top: 20px">
        <button class="layui-btn layui-btn-normal"  lay-filter="updatePower" id="updatePower" lay-submit="">修改</button>
        <button class="layui-btn layui-btn-primary" id="colseButton">取消</button>
    </div>
</form>
</body>
</html>
<script type="text/javascript" src="/elective/layui/layui.js"></script>
<script src="/elective/js/power/power_edit.js"></script>
<script type="text/javascript">

</script>