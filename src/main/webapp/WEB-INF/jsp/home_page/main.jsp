<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>后台首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/elective/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/elective/css/main.css" media="all"/>
</head>
<body class="childrenBody" style="margin: 1%">
<blockquote class="layui-elem-quote">
    <p>欢迎使用选课系统</p>


    <!--文本框-->
    <div style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">软件学院智软工作室制作出品</div>
                    <div class="layui-card-body">
                        公司主页：<a href="www.wisdsoft.cn">www.wisdsoft.cn</a><br>
                        联系QQ：953124935<br>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">承接业务</div>
                    <div class="layui-card-body">
                        前端页面设计 + 后台管理系统<br>
                        分布式 + 服务器
                    </div>
                </div>
            </div>
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header">系统简介</div>
                    <div class="layui-card-body">
                        <p style="text-indent: 2rem;">随着高校招生规模的不断扩大，课程的不断细化，给高校学生选课带来很大的不便。而选课是高校教务系统不可或缺的一部分。为了解决这个问题，产生了高校学生选课系统。</p>
                        <p style="text-indent: 2rem;">该系统以日常生活、学习的各个领域、各个环节中的计算机网络平台为基础，以高校学生、教师、系统管理员为目标用户，以高校教务系统的需求为依据，以应用和服务为核心，以方便用户为宗旨，以信息安全保障为前提，开发出一个稳定可靠、经济实用、操作界面简单的高校学生选课系统。</p>
                        <p style="text-indent: 2rem;">从而提高高校学生的选课效率和管理人员的工作效率，提升高校的教育质量和教学管理质量，推动高校的进一步发展。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>


</blockquote>
<!-- 事件线 -->
<div>
    <fieldset class="layui-elem-field layui-field-title"
              style="margin-top: 30px;">
        <legend>关于系统</legend>
    </fieldset>

</div>

<div class="">
    <blockquote class="layui-elem-quote title">系统基本参数</blockquote>
    <table class="layui-table">
        <colgroup>
            <col>
            <col>
        </colgroup>
        <tbody>
        <tr>
            <td>当前版本</td>
            <td class="version"></td>
        </tr>
        <tr>
            <td>开发作者</td>
            <td class="author"></td>
        </tr>
        <tr>
            <td>服务器环境</td>
            <td class="server"></td>
        </tr>
        <tr>
            <td>数据库版本</td>
            <td class="dataBase"></td>
        </tr>
        <tr>
            <td>最大上传限制</td>
            <td class="maxUpload"></td>
        </tr>
        </tbody>
    </table>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/elective/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/elective/js/home_page/main.js"></script>

</body>
</html>