layui.use(['table','upload'] ,function () {
    var table = layui.table
        ,form = layui.form
        ,upload = layui.upload;
    table.render({
        elem: '#test' //指定原始表格元素选择器（推荐id选择器）
        , url: 'http://localhost:8080/rule/getRule'
        , id: 'ruleReload'
        , even: true    //隔行换色
        ,where:{
            teacherId:'2016ZR0002'
        }
        , cols: [[
            {
                field:'id', title:'编号', sort: true,align: 'center'
            },{
                field: 'cuName', title: '课程',align: 'center'
            }, {
                field: 'usual', title: '平时成绩',align: 'center'
            }, {
                field: 'midterm', title: '期中成绩',align: 'center'
            }, {
                field: 'skill', title: '技能考核',align: 'center'
            }, {
                field: 'finalexam', title: '期末成绩',align: 'center'
            },{
                fixed: 'right', title:'操作', toolbar: '#barDemo',align: 'center'
            }]],

    });
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            layer.confirm('确认修改吗', function (index) {
                layer.open({
                    type: 2,
                    content: 'http://localhost:8080/rule/getRuleById/'+data.id,
                    area: ['550px', '500px'],
                    offset: ['25px', '250px']
                });
            });
        } else if (obj.event === 'del') {
            layer.confirm('真的删除行么', function(index) {
                $.ajax({
                    url: 'http://localhost:8080/rule/delRule',
                    type: "post",
                    data: {id: data.id},
                    success: function (res) {
                        layer.msg('删除成功', {icon: 6});
                        let responseCourse = res.data;
                        obj.del();
                        layer.close(index);
                    }, error: function (res) {

                    }
                })
            })
        }
    });
    $("#search").click(function () {
        reload();
    });
});
function reload() {
    var table = layui.table;
    let cuName = $('#cuName').val();
    //执行重载
    table.reload('ruleReload', {
        url: 'http://localhost:8080/rule/getRule'
        ,where:{
            teacherId:'2016ZR0002',
            cuName:cuName
        }
    });
    $('#categoryName').val("");
}