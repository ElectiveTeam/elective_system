layui.use(['table','upload'] ,function () {
    var table = layui.table
        ,form = layui.form
        ,upload = layui.upload;
    table.render({
        elem: '#test' //指定原始表格元素选择器（推荐id选择器）
        , url: 'http://localhost:8080/achievement/getSelection'
        , id: 'selectionReload'
        , even: true    //隔行换色
        ,page:false
        , cols: [[
            {
                field:'id', title:'编号', sort: true,align: 'center'
            },{
                field: 'cuName', title: '课程',align: 'center'
            },{
                fixed: 'right', title:'操作', toolbar: '#barDemo',align: 'center'
            }]],
        done:function (res) {
            console.log(res);
        }

    });
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        if (obj.event === 'jump') {
                layer.open({
                    type: 2,
                    content: 'http://localhost:8080/achievement/toStudentDetails/'+data.id,
                    area: ['1300px', '550px'],
                    offset: ['0px', '0px']
                });
        }
    });
});