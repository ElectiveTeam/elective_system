<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学期模块</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/elective/layui/css/layui.css"  media="all">
</head>
<body>
<button class="layui-btn layui-btn-normal" id = "addTerm" style="margin-top: 10px;margin-left: 10px">创建学期</button>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="status">
  {{#  if(d.status==0){ }}
  申请中
  {{# } else if(d.status==1) { }}
  选课进行中
  {{# } else if(d.status==2) { }}
  选课结束
  {{# } else if(d.status==3) { }}
  补选进行中
  {{# } else if(d.status==4) { }}
  补选结束
  {{# } else if(d.status==5) { }}
  授课进行中
  {{# } else if(d.status==6) { }}
  成绩录入
  {{#  } else { d.status==7}}
  学期结束
  {{#  } }}
</script>
</body>
</html>
<script src="/elective/layui/layui.js" charset="utf-8"></script>
 <script src="/elective/js/jquery_2.2.4.min.js" charset="utf-8"></script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,url:'http://localhost:8080/term/findAll'
    ,title: '学年学期表'
    ,cellMinWidth: 80
    ,cols: [[
      {field:'id', title:'学期编号', fixed: 'left', sort: true}
      ,{field:'termName', title:'学年学期名称'}
      ,{field:'college', title:'学院'}
      ,{field:'openTime', title:'开放时间'}
      ,{field:'closeTime', title:'截止时间'}
      ,{field:'status', title:'状态',templet: '#status'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
    ]]
    ,page: false
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'getCheckData':
        var data = checkStatus.data;
        layer.alert(JSON.stringify(data));
      break;
      case 'getCheckLength':
        var data = checkStatus.data;
        layer.msg('选中了：'+ data.length + ' 个');
      break;
      case 'isAll':
        layer.msg(checkStatus.isAll ? '全选': '未全选');
      break;
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    console.log(data);
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
    	  $.ajax({
              url: 'http://localhost:8080/term/delete',
              type: "post",
              data: {
                  'termResource': obj.data.id,
              }, success: function (data) {
            	  obj.del();
                  layer.close(index);
              }, error: function (data) {
                  layer.msg("该课程已被使用！");
              }
          })
        
      });
    } else if(obj.event === 'edit'){
    	//prompt层
    	layer.open({
    		  type: 2, 
    		  title :'编辑学期',
    		  closeBtn: 1, //显示关闭按钮
    		  area: ['500px', '600px'],
    		  content: '/term/termEdit?id='+data.id+"&states="+data.status
    	});
    }
  });
});
$("#addTerm").click(function(){
	//prompt层
	layer.open({
		  type: 2, 
		  title :'新建学期',
		  closeBtn: 1, //显示关闭按钮
		  area: ['500px', '400px'],
		  content: '/term/termAdd'
		}); 
})
</script>