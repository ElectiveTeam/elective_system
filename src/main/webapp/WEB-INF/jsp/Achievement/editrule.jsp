<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>修改规则</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/elective/layui/css/layui.css"  media="all">
    <script src="/elective/js/jquery_2.2.4.min.js" charset="UTF-8"></script>
</head>
<body>
<form class="layui-form" action="">
<div style="padding: 15px;">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">
                <span class="x-red">*</span>课程名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="cuName" disabled name="cuName"
                       autocomplete="off" class="layui-input" value="${rule.cuName}"/>
            </div>
        </div>
        <div class="layui-inline">
            <label for="usual" class="layui-form-label">
                <span class="x-red">*</span>平时成绩
            </label>
            <div class="layui-input-inline">
                <input type="text" id="usual" name="usual"
                       autocomplete="off" class="layui-input" value="${rule.usual}"/>
            </div>
        </div>
        <div class="layui-inline">
            <label for="midTerm" class="layui-form-label">
                <span class="x-red">*</span>期中成绩
            </label>
            <div class="layui-input-inline">
                <input type="text" id="midterm" name="midterm"
                       autocomplete="off" class="layui-input" value="${rule.midterm}"/>
            </div>
        </div>
        <div class="layui-inline">
            <label for="skill" class="layui-form-label">
                <span class="x-red">*</span>技能考核
            </label>
            <div class="layui-input-inline">
                <input type="text" id="skill" name="skill"
                       autocomplete="off" class="layui-input" value="${rule.skill}"/>
            </div>
        </div>
        <div class="layui-inline">
            <label for="finalexam" class="layui-form-label">
                <span class="x-red">*</span>期末成绩
            </label>
            <div class="layui-input-inline">
                <input type="text" id="finalexam" name="finalexam"
                       autocomplete="off" class="layui-input" value="${rule.finalexam}"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button class="layui-btn" id="btn" lay-filter="save" lay-submit="">
                保存
            </button>
        </div>
    </div>
</div>
</form>
</body>
</html>
<script src="/elective/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('form', function () {
        var form = layui.form
            , layer = layui.layer;
        //监听提交
        form.on('submit(save)', function () {
            $.ajax({
                url: 'http://localhost:8080/rule/editRuleById',
                type: "post",
                data: {
                    id:${rule.id},
                    usual:$("#usual").val(),
                    midterm:$("#midterm").val(),
                    skill:$("#skill").val(),
                    finalexam:$("#finalexam").val()
                }
                , success: function () {
                    layer.msg('更新成功', {icon: 6, time: 1000});
                    // 获得frame索引
                    let index = parent.layer.getFrameIndex(window.name);
                    //实时更新
                    window.parent.location.reload();
                    //关闭当前frame
                    parent.layer.close(index);
                }, error: function () {
                    layer.msg('更新失败', {icon: 5, time: 1000});
                }
            });
            return false;
        });
    });
</script>