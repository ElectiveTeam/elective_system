<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>éè¯¾è¯¦æç»è®¡</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
</head>
<body>



<table class="layui-hide" id="test"></table>
              
<script type="text/javascript" src="../js/jquery.min.js" ></script>
<script src="../layui/layui.js" charset="utf-8"></script>

<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">å­¦é¢åå¸é¥¼ç¶å¾</button>
    
  </div>
</script>

<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,width: 600
    ,url:'../json/list2.json'
    ,toolbar: '#toolbarDemo'
    ,cols: [[
      {field:'college_name', width:200, title: 'å­¦é¢', align: 'center'}
      ,{field:'stu_num', width:200, title: 'å­¦å·', align: 'center'}
      ,{field:'stu_name', width:200, title: 'å§å', align: 'center'}
    ]]
    ,page: true
  });
  
});
</script>

</body>
</html>