layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#major' //指定原始表格元素选择器（推荐id选择器）
        , url: 'http://localhost:8080/powersousuo'
        , id: 'majorReload'
        , cols: [[{
            field: 'worknumber', title: '职工编号', align: 'center'
        }, {
            field: 'teaName', title: '教师名称', align: 'center'
        }, {
            field: 'teaSex', title: '性别', align: 'center'
        }, {
            field: 'teaPower', title: '权限', align: 'center',unresize: true
        }, {
            fixed: 'right', align: 'center', title: '操作', unresize: true, toolbar: '#barDemo'
        }]],
        page: true
    });
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        var zhigongid = $(this).parent().parent().parent().children().children().html();
        var name = $(this).parent().parent().parent().children().next().children().html();
        var sex = $(this).parent().parent().parent().children().next().next().children().html();
        var power = $(this).parent().parent().parent().children().next().next().next().children().html();

        var param={worknumber:zhigongid,teaName:name,teaSex:sex,teaPower:power};
        var jsonData = JSON.stringify(param);// 转成JSON格式
        console.log(data);

        if(obj.event == 'edit'){
            layer.open({
                type: 2,
                content: 'http://localhost:8080/powerEdit?param='+encodeURI(jsonData),
                area: ['500px', '500px'],
                offset: 't'
            })
        }
    });
});
$("#search").click(function () {
    reload();
});
function reload() {
    var table = layui.table;
    let category = $('#categoryName').val();
    console.log(category === "" || category == null);
    // if (category === "" || category == null) {
    //     $('#categoryName').val('1')
    // }
    //执行重载
    table.reload('majorReload', {
        url: 'http://localhost:8080/powersousuo/?zhigonghao=' + $("#categoryName").val()
        , page: true
    });
    $('#categoryName').val("");
}