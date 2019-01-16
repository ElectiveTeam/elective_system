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
<span>下载模板前请先添加该课程成绩规则</span>
<div class="layui-btn-container" style="margin-top: 20px;">
    <button class="layui-btn layui-btn-sm" id="importExcel">导入</button>
    <button class="layui-btn layui-btn-sm" id="theBatchExport">打印</button>
    <button class="layui-btn layui-btn-sm" id="save">发布</button>
</div>
<table id="test" lay-filter="test"></table>
<script type="text/html" id="barDemo">
    {{# if (d.status == 0) { }}
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    {{# }else { }}
    不可操作
    {{# } }}
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
            , url: '${pageContext.request.contextPath}/achievement/getAll'
            ,where:{
                selectId:1
            }
            , id: 'achieveReload'
            , even: true    //隔行换色
            , cols: [[
                {
                    field: 'id', title: '编号', sort: true,align: 'center'
                },{
                    field: 'stuId', title: '学号',align: 'center'
                }, {
                    field: 'stuName', title: '姓名',align: 'center'
                }, {
                    field: 'usual', title: '平时成绩',align: 'center'
                }, {
                    field: 'midterm', title: '期中成绩',align: 'center'
                }, {
                    field: 'skill', title: '技能考核',align: 'center'
                }, {
                    field: 'finalexam', title: '期末成绩',align: 'center'
                }, {
                    field: 'achieve', title: '总成绩',align: 'center'
                },{
                    fixed: 'right', title:'操作', toolbar: '#barDemo',align: 'center'
                }]],
            done:function (res) {
                if(res.data[1].status == 1){
                    $("#save").hide();
                    $("#importExcel").hide()
                }else if (res.data[1].status == 0) {
                    $("#importExcel").hide()
                }
            }

        });
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                layer.confirm('确认修改吗', function (index) {
                    layer.open({
                        type: 2,
                        content: 'http://localhost:8080/achievement/getAchieveById/'+ data.id,
                        area: ['550px', '500px'],
                        offset: ['25px', '250px']
                    });
                });
            }
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
            var selectId=1;
            var formData = new FormData();
            formData.append("model", JSON.stringify(data));
            formData.append("selectId", selectId);
            var url = "${pageContext.request.contextPath}/achievement/exportExcel";
            var xhr = new XMLHttpRequest();
            xhr.open("post", url, true);
            xhr.responseType = "blob";
            layer.msg('正在下载', {icon: 4});
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
        })
    });
    $("#save").on('click',function () {
        $.ajax({
            url:'http://localhost:8080/achievement/saveAchieve',
            type:'post',
            data:{
                selectId: 1
            },
            success:function () {
                window.location.reload()
            }
        })
    })
</script>