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
<span>下载模板前请填写各项成绩占比，例如：平时成绩：20 期中成绩：20 技能考核：0 期末成绩：60;不填则默认为0，总和须为100</span>
<div class="layui-btn-container" style="margin-top: 20px;">
    <button class="layui-btn layui-btn-sm" id="importExcel">批量导入</button>
    <button class="layui-btn layui-btn-sm" id="theBatchExport">下载模板</button>
</div>
<div class="layui-form-item">
    <div class="layui-inline">
        <label class="layui-form-label">平时成绩：</label>
        <div class="layui-input-inline">
            <input type="text" id="usual" style="width: 50px" name="usual" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">期中成绩:</label>
        <div class="layui-input-inline">
            <input type="text" id="midterm" style="width: 50px" name="midterm" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div><div class="layui-inline">
    <label class="layui-form-label">技能考核:</label>
    <div class="layui-input-inline">
        <input type="text" id="skill" style="width: 50px" name="skill" lay-verify="required" autocomplete="off" class="layui-input">
    </div>
</div><div class="layui-inline">
    <label class="layui-form-label">期末成绩:</label>
    <div class="layui-input-inline">
        <input type="text" id="finalexam" style="width: 50px" name="finalexam" lay-verify="required" autocomplete="off" class="layui-input">
    </div>
</div>
</div>
<table id="test" lay-filter="test"></table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>
</body>
</html>
<script src="/elective/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['table','upload'] ,function () {
        var table = layui.table
            ,form = layui.form
            ,upload = layui.upload;
        table.render({
            elem: '#test' //指定原始表格元素选择器（推荐id选择器）
            , url: '${pageContext.request.contextPath}/achievement/importExcel'
            , id: 'achieveReload'
            , even: true    //隔行换色
            , cols: [[
                {
                    field: 'stuId', title: '学号', sort: true
                }, {
                    field: 'stuName', title: '姓名'
                }, {
                    field: 'achieve', title: '成绩'
                }]],

        });
        upload.render({
            elem: '#importExcel',
            url: '${pageContext.request.contextPath}/achievement/importExcel',
            auto: 'true',
            accept: 'fileType',
            exts: 'xls|xlsx',
            field: 'fileType',
            data:{
                selectId:1
            },
            done: function (msg) {
                var table = layui.table;
                //执行重载
                table.reload('achieveReload', {
                    url: '${pageContext.request.contextPath}/achievement/test1'
                })
                if (msg.status == 200){
                    layer.msg('导入成功', {icon: 6});
                }else{
                    layer.msg('导入失败', {icon: 5});
                }
            }
        })
    })
    $('#theBatchExport').on('click',function (){
        layui.use('table', function () {
            var table = layui.table;
            var data = table.cache.achieveReload;
            var usual = parseInt($("#usual").val());
            var midterm = parseInt($("#midterm").val());
            var skill = parseInt($("#skill").val());
            var finalexam = parseInt($("#finalexam").val());
            if ($("#usual").val()==null||$("#usual").val()==""){
                usual=0;
            }
            if ($("#midterm").val()==null||$("#midterm").val()==""){
                midterm=0;
            }
            if ($("#skill").val()==null||$("#skill").val()==""){
                skill=0;
            }
            if ($("#finalexam").val()==null||$("#finalexam").val()==""){
                finalexam=0;
            }
            var selectId=1;
            console.log(usual+midterm+skill+finalexam)
            if (usual+midterm+skill+finalexam == 100) {
                var formData = new FormData();
                formData.append("model", JSON.stringify(data));
                formData.append("usual", usual);
                formData.append("midterm", midterm);
                formData.append("skill", skill);
                formData.append("finalexam", finalexam);
                formData.append("selectId", selectId);
                var url = "${pageContext.request.contextPath}/achievement/exportExcel";
                var xhr = new XMLHttpRequest();
                xhr.open("post", url, true);
                xhr.responseType = "blob";
                layer.msg('王尼玛来打个酱油', {icon: 4});
                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        var name = xhr.getResponseHeader("Content-disposition");
                        console.log(name);
                        var fileName = name.substring(21, name.length);
                        var filename = decodeURIComponent(fileName);
                        var blob = new Blob([xhr.response], {type: 'text/xls'});
                        var csvUrl = URL.createObjectURL(blob);
                        var a = document.createElement('a');
                        a.href = csvUrl;
                        a.download = filename;
                        a.click();
                    }
                };
                xhr.send(formData);
            }else{
                layer.alert('请重新填写规则，规则总和必须为100', {
                    icon: 6,
                    skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                });
            }
        })
    });
</script>