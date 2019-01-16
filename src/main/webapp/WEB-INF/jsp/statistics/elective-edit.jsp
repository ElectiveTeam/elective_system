<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>选课详情统计</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/elective/layui/css/layui.css"  media="all">
</head>
<body>



<table class="layui-hide" id="test"></table>

<%--<script type="text/javascript" src="/elective/js/jquery.min.js" ></script>--%>

<script src="/elective/layui/layui.js" charset="utf-8"></script>

<script>
  var selectId = ${selectid};
  layui.use('table', function(){
    var table = layui.table;

    table.render({
      elem: '#test',
      where: {
        selectid: selectId
      },
      url:'${pageContext.request.contextPath }/statistics/findstu',
      toolbar: '#toolbarDemo',
      cellMinWidth: 180,
      cols: [[
        {field:'stuId', title: '学号', align: 'center'}
        ,{field:'stuName', title: '姓名', align: 'center'}
      ]],
      done: function (msg) {
        console.log(msg);

      },
      page: true
    });

  });
</script>

</body>
</html>