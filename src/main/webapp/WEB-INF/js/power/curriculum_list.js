layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#major' //指定原始表格元素选择器（推荐id选择器）
        , url: 'http://localhost:8080/curriculum/findAllByPage'
        , id: 'majorReload'
        , cols: [[{
            field: 'id', title: '课程编号', sort: true,hide:true
        }, {
            field: 'cuName', title: '课程名称', align: 'center'
        }, {
            field: 'price', title: '教师名称', align: 'center'
        }, {
            field: 'classHour', title: '学时', align: 'center'
        }, {
            field: 'credit', title: '学分', align: 'center'
        }, {
            field: 'grade', title: '年级', align: 'center'
        }, {
            field: 'status', title: '审核状态', align: 'center',unresize: true,
            templet: '#show'
        }, {
            fixed: 'right', align: 'center', title: '操作', unresize: true, toolbar: '#barDemo'
        }]],
        page: true
    });
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        if (obj.event === 'success') {
            layer.open({
                type: 2,
                content: 'http://localhost:8080/application/insertSelection/' + obj.data.id,
                area: ['800px', '500px'],
                offset: ['25px', '250px']
            });
        } else if (obj.event === 'refuse') {
            $.ajax({
                url: 'http://localhost:8080/application/review',
                type: "post",
                data: {
                    'id': obj.data.id,
                    'status': 3
                }, success: function (data) {
                    layer.msg("更改成功");
                }, error: function (data) {
                    layer.msg("服务器异常");
                }
            })
        } else if (obj.event === 'info') {
            layer.open({
                type: 2,
                content: 'http://localhost:8080/application/find/' + obj.data.id,
                area: ['850px', '500px'],
                offset: ['25px', '250px']
            })
        } else if (obj.event === 'success_info') {
            layer.open({
                type: 2,
                content: 'http://localhost:8080/application/selectionInfo/' + obj.data.id,
                area: ['850px', '500px'],
                offset: ['25px', '250px']
            })
        }
    });

    $("#search").click(function () {
        reload();
    });


});
$("#CatCourse").click(function () {
    layer.open({
        type: 2,
        title: '查看分组',
        area: ['800px', '580px'],
        fixed: false, //不固定
        maxmin: true,
        content: '/course/'
    });
});
$("#term").click(function () {
    layer.open({
        type: 2,
        title: '查看学期',
        area: ['800px', '580px'],
        fixed: false, //不固定
        maxmin: true,
        // offset: ['25px', '250px'],
        content: '/term/term'
    });
});
function reload() {
    var table = layui.table;
    let category = $('#categoryName').val();
    console.log(category === "" || category == null);
    if (category === "" || category == null) {
        $('#categoryName').val('1')
    }
    //执行重载
    table.reload('majorReload', {
        url: 'http://localhost:8080/commodity/findCategory/' + $('#categoryName').val()
        , page: true
    });
    $('#categoryName').val("");
}