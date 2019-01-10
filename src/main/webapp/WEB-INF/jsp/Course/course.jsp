<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/9
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/elective/layui/css/layui.css"  media="all">
    <script src="/elective/js/jquery_2.2.4.min.js" charset="UTF-8"></script>
</head>
<body>
<div class="layui-collapse" lay-filter="test"></div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>
<script src="/elective/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    let couseId = null;

    layui.use(['element', 'layer'], function(){
        var element = layui.element;
        var layer = layui.layer;

        //监听折叠
        element.on('collapse(test)', function(data){
            layer.msg('展开状态：'+ data.show);
            // console.log();
            couseId = $(this).data('id');
            layui.use('table', function(){
                var table = layui.table;
                // console.log(couseId)
                table.render({
                    elem: '#test'+couseId
                    ,url:'http://localhost:8080/course/SelectCurriculum?couId='+couseId
                    // ,toolbar: '#toolbarDemo'
                    ,cellMinWidth: 80
                    ,title: '用户数据表'
                    ,cols: [[
                        // {type: 'checkbox', fixed: 'left'}
                        {field:'id', title:'分组编号', sort: true,align: 'center'}
                        ,{field:'cuName', title:'课程名称',align: 'center'}
                        ,{field:'teacherId', title:'教师编号',align: 'center'}
                        ,{field:'classHour', title:'学时',align: 'center'}
                        ,{field:'credit', title:'学分',align: 'center'}
                        ,{field:'grade', title:'年级',align: 'center'}
                        ,{field:'status', title:'状态',align: 'center'}
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
                    ]]
                    ,page: false
                });

                //监听行工具事件
                table.on('tool(test)', function(obj){
                    var data = obj.data;
                    // console.log(obj.data.couId)
                    if(obj.event === 'del'){
                        layer.confirm('真的删除行么', function(index){
                            $.ajax({
                                url:'http://localhost:8080/course/deleteCourseById',
                                type:"get",
                                data:{id:data.couId},
                                success: function (res) {
                                    let responseCourse = res.data;
                                    console.log(res);
                                    obj.del();
                                    layer.close(index);
                                },error: function (res) {

                                }
                            })
                        });
                    } else if(obj.event === 'edit'){
                        layer.prompt({
                            formType: 2
                            ,value: data.email
                        }, function(value, index){
                            obj.update({
                                email: value
                            });
                            layer.close(index);
                        });
                    }
                });
            });
        });
    });
    $(function () {
        $.ajax({
            url:'http://localhost:8080/course/selectCource',
            type:"get",
            data:{},
            success: function (res) {
                let responseCourse = res.data;
                for (let courseList of responseCourse) {
                    console.log(courseList);
                    let ressults="<div class=\"layui-colla-item\">\n" +
                        "   <h2 class=\"layui-colla-title\" data-id='"+courseList.id+"'>"+courseList.courseName+"</h2>\n" +
                        "   <div class=\"layui-colla-content\">\n" +
                        "      <p><table class=\"layui-hide\" id='test"+courseList.id+"' lay-filter=\"test\"></table></p>\n" +
                        "   </div>\n" +
                        "</div>";
                    $(".layui-collapse").append(ressults);
                }
            },error: function (res) {
                
            }
        })
    });
</script>