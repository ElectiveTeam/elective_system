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
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">选课系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item my-demo" data-id="0" data-uri="login/first">首页</li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="#">
                    用户名
                </a>
                <dl class="layui-nav-child">
                    <dd><a data-id="6" data-uri="administrator/updatePwd" class="my-demo">个人信息</a></dd>
                    <dd><a data-id="7" data-uri="administrator/updatePwd" class="my-demo" onclick="update()">修改密码</a></dd>
                    <dd><a data-id="7" data-uri="administrator/updatePwd" class="my-demo" onclick="logout()">退出</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a>2018-2019学年第二学期</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">管理员管理</a>
                    <dl class="layui-nav-child">
                        <%--data-uri中填写@Controller注解下面的@RequestMapping注解的value值 加上 方法对应的@RequestMapping注解的value值--%>
                        <dd><a data-id="1" data-uri="" class="my-demo">学期模块</a></dd>
                        <dd><a data-id="2" data-uri="" class="my-demo" onclick="power()">授权模块</a></dd>
                        <dd><a data-id="3" data-uri="/application/toPage" class="my-demo">课程模块</a></dd>
                        <dd><a data-id="4" data-uri="" class="my-demo">审核模块</a></dd>
                        <dd><a data-id="5" data-uri="" class="my-demo">统计模块</a></dd>
                        <dd><a data-id="6" data-uri="" class="my-demo">课程组模块</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a data-id="7" data-uri="" class="my-demo">统计汇总</a>
                    <dl class="layui-nav-child">
                        <%--data-uri中填写@Controller注解下面的@RequestMapping注解的value值 加上 方法对应的@RequestMapping注解的value值--%>
                        <dd><a data-id="8" data-uri="/statistics/list" class="my-demo">选课情况统计表</a></dd>
                        <dd><a data-id="9" data-uri="/statistics/Echarts" class="my-demo">选课人数统计图</a></dd>
                        <dd><a data-id="10" data-uri="" class="my-demo">选课成绩统计表</a></dd>
                        <dd><a data-id="11" data-uri="" class="my-demo">选课成绩统计图</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">课程管理</a>
                    <dl class="layui-nav-child">
                        <dd><a data-id="12" data-uri="" class="my-demo">课程列表</a></dd>
                        <dd><a data-id="13" data-uri="" class="my-demo">申请课程</a></dd>
                        <dd><a data-id="14" data-uri="" class="my-demo">取消课程</a></dd>
                        <dd><a data-id="15" data-uri="" class="my-demo">驳回课程</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a data-id="16" data-uri="" class="my-demo">成绩管理</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <div class="layui-tab" lay-filter="demo" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="0">首页</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <iframe frameborder="0" name="content" scrolling="yes" width="100%" height="560px" id="myFrame"></iframe>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <p>© 河北工程技术学院 <span style="float: right;margin-right: 20px;">技术支持：软件学院-智软工作室www.wisdsoft.cn</span></p>
    </div>
</div>
<script src="${pageContext.request.contextPath}/elective/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/elective/js/home_page/index.js"></script>
</body>
<script type="text/javascript">
    function power() {
        var a = sessionStorage.getItem("teacher");
        var b =  $.parseJSON( a );
        var c = (b.teaPower);
        if (c==1){
            window.location.href="http://localhost:8080/power";
        }else {
            alert("您没有授权功能");
        }


    }
    function update() {
        var a = sessionStorage.getItem("teacher");
        var b =  $.parseJSON( a );
        var c = (b.worknumber);
        window.location.href="http://localhost:8080/TeaChangePassword?TeaId="+c;
    }
</script>
</html>
