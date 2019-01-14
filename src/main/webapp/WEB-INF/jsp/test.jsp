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
<table id="test" lay-filter="test"></table>
<script src="${pageContext.request.contextPath}/elective/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/elective/js/home_page/index.js"></script>
<script>
    layui.use(['table','upload'] ,function () {
        var table = layui.table
            ,form = layui.form
            ,upload = layui.upload;
        table.render({
            elem: '#test' //指定原始表格元素选择器（推荐id选择器）
            , url: '${pageContext.request.contextPath}/achievement/importExcel'
            , id: 'claimReload'
            , even: true    //隔行换色
            , cols: [[
                {type: 'checkbox', fixed: 'left'},{
                field: 'stuId', title: '学号', sort: true,width:70
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
                table.reload('claimReload', {
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
            var checkStatus = table.checkStatus('claimReload');
            var data = checkStatus.data;
            /*$.ajax({
                url:'${pageContext.request.contextPath}/achievement/test2',
                type:'post',
                dataType:"json",
                data: {
                    dt:JSON.stringify(data)
                },
                success:function (res) {
                    console.log(res);
                }
            })*/
            if (data.length === 0) {
                layer.alert('请大哥勾选数据之后在进行导出哦！！ (*^v^*)', {
                    icon: 6,
                    skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                });
            }else{
                var formData = new FormData();
                formData.append("model", JSON.stringify(data));
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
            }
        })
    });
</script>
</body>

</html>
