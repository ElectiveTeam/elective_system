<%--
  Created by IntelliJ IDEA.
  User: 李世奇
  Date: 2019/1/10
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/elective/layui/css/layui.css">
    <title>授权</title>
</head>
<body>
    <form class="layui-form" action="" id="yemian">
        <div style="display: flex;">
        <input type="text" required  lay-verify="required" placeholder="请输入职工号" autocomplete="off" class="layui-input" id="zhigonghao1" style="width: 15%;">
        <input type="button" class="layui-btn" value="搜索" id="search">
        </div>
        <div class="layui-input-block" style="display: flex;">
        <input type="text" disabled name="title" value="职工号" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" id="zhigonghao" style="width: 15%;">
            <input type="text" disabled name="title" value="姓名" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" id="zhigonghao4" style="width: 15%;">
            <input type="text" disabled name="title" value="性别" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" id="zhigonghao5" style="width: 15%;">
            <input type="text" disabled name="title" value="权限" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" id="zhigonghao6" style="width: 15%;">
        </div>
        <div id="bottomyemian">

        </div>
    </form>

</body>
<script src="/elective/student/js/jquery_2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/elective/layui/layui.all.js"></script>
<script type="text/javascript">
    layui.use('form', function() {
        var form = layui.form;
        $("#search").click(function () {
            $.ajax({
                url: "http://localhost:8080/powersousuo",
                type: "get",
                data: {
                    zhigonghao: $("#zhigonghao1").val()
                },
                success: function (data) {
                    var i ="";
                    $("#bottomyemian").empty();
                    for ( i = 0; i < data.length; i++) {
                        if(data[i].teaPower=="0"){
                            data[i].teaPower="普通老师";
                        }
                         if(data[i].teaPower=="1"){
                             data[i].teaPower="校级管理员";
                         }
                        if(data[i].teaPower=="HGXY0001"){
                            data[i].teaPower="软件学院管理员";
                        }
                        if(data[i].teaPower=="HGXY0002"){
                            data[i].teaPower="建筑学院管理员";
                        }
                        var  res = " <div class='layui-form-item' >" +
                            "<div class='layui-input-block' style='display: flex;'>" +
                                "<input type='text' disabled name='title' value='"+data[i].worknumber+ "' required  lay-verify='required' placeholder='请输入标题' autocomplete='off' class='layui-input' id='zhigonghao' style='width: 15%;'>" +
                                "<input type='text' disabled name='title' value='"+data[i].teaName+"' required  lay-verify='required' placeholder='请输入标题' autocomplete='off' class='layui-input' id='name' style='width: 15%;'>" +
                                "<input type='text' disabled name='title' value='"+data[i].teaSex+"' required  lay-verify='required' placeholder='请输入标题' autocomplete='off' class='layui-input' id='sex' style='width: 15%;'>" +
                                "<input type='text' disabled name='title' value='"+data[i].teaPower+"' required  lay-verify='required' placeholder='请输入标题' autocomplete='off' class='layui-input' id='quanxian' style='width: 15%;'>" +
                                    "<div class='layui-form-item' style='width: 20%;'>" +
                                        "<div class='layui-input-block'>" +
                                        "<select id='select_id' name='city' lay-verify='' >" +
                                        "<option value=''>请选择一个等级</option>" +
                                        "<option value='0'> 普通老师</option>" +
                                        "<option value='1'>校级管理</option>" +
                                        "<option value='HGXY0001'>软件学院</option>" +
                                        "<option value='HGXY0002'>建筑学院</option>" +
                                        "<option value='HGXY0003'>工程管理</option>" +
                                        "<option value='HGXY0004'>经济管理</option>" +
                                        "<option value='HGXY0005'>信息学院</option>" +
                                        "<option value='HGXY0006'>人文学院</option>" +
                                        "<option value='HGXY0007'>土木工程</option>" +
                                        "<option value='HGXY0008'>会计学院</option>" +
                                        "</select>" +
                                        "</div>" +
                                    "</div>" +
                                "<input type='button' class='layui-btn' value='确认' id= 'qunren' >"+
                            "</div>" +
                            "</div>";

                        $("#bottomyemian").append(res);
                    }
                    form.render();

                }
            });
        });
    });
    $(document).on('click','#qunren',function () {
        var zhigongid = $(this).parent().children().val();
        var quanxianid=$(this).prev().children().children().find("option:selected").val();
        $.ajax({
            url:"http://localhost:8080/powerupdata",
            type:"get",
            data:{
                worknumber:zhigongid,
                teapower:quanxianid
            },
            success:function (data) {
                alert("授权成功");
                location.reload();
            },
            error:function (e) {
                alert("授权失败");
            }
        })
    });
</script>
</html>
