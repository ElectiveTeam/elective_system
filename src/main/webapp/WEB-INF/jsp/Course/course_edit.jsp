<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/10
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>编辑分组</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/elective/layui/css/layui.css" media="all">
    <script src="/elective/js/jquery_2.2.4.min.js" charset="UTF-8"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item" style="margin-top: 10px">
        <div class="layui-inline">
            <label class="layui-form-label">课程名称</label>
            <div class="layui-input-inline">
                <input type="tel" name="cuName" lay-verify="required" disabled value="${cuName}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">课程组</label>
            <div class="layui-input-inline">
                <select name="quiz" id="UpdateCource">
                    <option value="">请选择课程组</option>
                    <c:forEach items="${courseList}" var="courseList">
                        <c:choose>
                            <c:when test="${courseList.courseName==courseName}">
                                <option value="${courseList.id}" selected>${courseList.courseName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${courseList.id}">${courseList.courseName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div style="margin-left: 70px;margin-top: 20px">
            <button class="layui-btn layui-btn-normal"  lay-filter="updateCourse" lay-submit="">修改</button>
            <button class="layui-btn layui-btn-primary" id="colseButton">取消</button>
        </div>
    </div>
</form>
</body>
</html>
<script src="/elective/layui/layui.js" charset="utf-8"></script>
<script>
    let id = "${curId}";
    <%--console.log(${curId});--%>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;
        form.on('submit(updateCourse)', function (data) {
            $.ajax({
                url: 'http://localhost:8080/curriculum/UpdateCurriculum',
                type: "post",
                data: {
                    id: id,
                    couId :$("#UpdateCource").val()
                },
                success: function (res) {
                    let responseCourse = res.data;
                    // console.log(responseCourse);
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //实时更新
                    window.parent.location.reload();
                    //关闭当前frame
                    parent.layer.close(index);
                    // layer.msg("更新成功");
                }, error: function (res) {
                    console.log("失败"+res);
                }
            })
        });
        $("#colseButton").click(function () {
            // 获得frame索引
            var index = parent.layer.getFrameIndex(window.name);
            //关闭当前frame
            parent.layer.close(index);
        });
    });
</script>