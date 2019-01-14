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
            /*if (data.length === 0) {
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
            }*/
        })
    });
</script>