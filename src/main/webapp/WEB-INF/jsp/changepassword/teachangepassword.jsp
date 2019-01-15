<%--
  Created by IntelliJ IDEA.
  User: 李世奇
  Date: 2019/1/9
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/elective/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/elective/css/teachangepassword.css">
    <title>老师修改密码</title>
</head>
<body>
<div class="bg">
    <img src="/elective/img/banner.jpg"/>
</div>
<input type="text" id="id" value="${TeaId}" hidden>
<div class="bigbox">
    <div class="big1">
        <div class="biaoti">
            <p><h2>老师密码修改</h2></p>
        </div>
        <form class="layui-form" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">请输入密码</label>
                <div class="layui-input-block">
                    <input type="password" name="title" lay-verify="title" autocomplete="off" placeholder="请输入密码" class="layui-input" id="password" style="width: 70%;">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">请再次输入密码</label>
                <div class="layui-input-block">
                    <input type="password" name="title" lay-verify="title" autocomplete="off" placeholder="请再次输入密码" class="layui-input" id="password2" style="width: 70%;">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="button" class="layui-btn" lay-submit="" lay-filter="demo1" id="queren" onclick="yzlogin()">确认修改</button>
                    <button type="button" class="layui-btn layui-btn-primary" id="chongzhi">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="/elective/js/jquery.js"></script>
<script type="text/javascript">
    $("#chongzhi").click(function(){
        $("#password").val("");
        $("#password2").val("");
    });
    function yzlogin(){
        if ($("#password").val()=="") {
            alert("密码不能为空");
        } else if($("#password2").val()==""){
            alert("密码不能为空");
        } else if($("#password").val()!=$("#password2").val()){
            alert("两次输入的密码不相同");
        } else{
            alert("成功");
            $.ajax({
                type:"post",
                url:"http://localhost:8080/TeaUpdatePassword",
                data:{
                    teaid:$("#id").val(),
                    password:$("#password").val()
                },
                success:function(data){
                    alert("更新密码成功");

                },
                error:function(e){
                    alert("更新密码失败");
                }
            });
        }

    }
</script>
</html>
