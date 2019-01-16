<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>创建学期-内置页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/elective/layui/css/layui.css" media="all">
    <script src="/elective/layui/layui.js" charset="utf-8"></script>
    <script src="/elective/js/jquery_2.2.4.min.js" charset="utf-8"></script>
</head>
<body>
<form class="layui-form" action="" style="margin-top: 20px;">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">学年学期：</label>
            <div class="layui-input-inline">
                <input id="Semester" type="tel" name="phone" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">学院名称：</label>
            <div class="layui-input-inline">
                <input id="CollegeName" type="tel" name="phone"
                       lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">开放时间：</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="test5"
                       placeholder="yyyy-MM-dd HH:mm:ss">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">截止时间：</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="test6"
                       placeholder="yyyy-MM-dd HH:mm:ss">
            </div>
        </div>
    </div>
    <%--<div class="layui-inline">--%>
    <%--<label class="layui-form-label">当前状态：</label>--%>
    <%--<div class="layui-input-inline">--%>
    <%--<select name="quiz" id="Current">--%>
    <%--<option value="">请选择当前状态</option>--%>
    <%--<option value="0">申请中</option>--%>
    <%--<option value="1">选课进行中</option>--%>
    <%--<option value="2">选课结束</option>--%>
    <%--<option value="3">补选进行中</option>--%>
    <%--<option value="4">补选结束</option>--%>
    <%--<option value="5">授课进行中</option>--%>
    <%--<option value="6">成绩录入中</option>--%>
    <%--<option value="7">学期结束</option>--%>
    <%--</select>--%>
    <%--</div>--%>
    <%--</div>--%>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1" id="tiJiao">提交</button>
            <button class="layui-btn layui-btn-primary" id="colseButton">取消</button>
        </div>
    </div>
</form>

</body>
</html>
<script type="text/javascript">
    layui.use(['form', 'layedit', 'laydate'],
        function () {
            var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;
            //开放时间日期时间选择器
            laydate.render({
                elem: '#test5',
                type: 'datetime'
            });
            //截止时间日期时间选择器
            laydate.render({
                elem: '#test6',
                type: 'datetime'
            });
            //监听提交
            form.on('submit(demo1)', function (data) {
                $.ajax({
                    url: 'http://localhost:8080/term/insert',
                    type: "POST",
                    data: {
                        'termName': $("#Semester").val(),
                        'college': $("#CollegeName").val(),
                        'openTime': $("#test5").val(),
                        'closeTime': $("#test6").val(),
                        'status': $("#Current").val()
                    },
                    success: function () {
                        // 获得frame索引
                        var index = parent.layer
                            .getFrameIndex(window.name);
                        //实时更新
                        window.parent.location.reload();
                        //关闭当前frame
                        parent.layer.close(index);
                    },
                    error: function () {
                        layer.msg('插入失败', {
                            icon: 5,
                            time: 1000
                        });
                    }
                });
                return false;
            });
            $("#colseButton").click(function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
        });
</script>