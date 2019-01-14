layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit;
    //监听提交
    form.on('submit(sub)', function (data) {
        alert(JSON.stringify(data.field));
        $.ajax({
            url: 'http://localhost:8080/application/updateSelection',
            type: "post",
            dataType : 'json',
            contentType : 'application/json',
            data:  JSON.stringify(data.field)
            , success: function () {
                layer.msg('更新成功', {icon: 6, time: 1000});
                // 获得frame索引
                let index = parent.layer.getFrameIndex(window.name);
                //实时更新
                window.parent.location.reload();
                //关闭当前frame
                parent.layer.close(index);
            }, error: function () {
                layer.msg('插入失败', {icon: 5, time: 1000});
            }
        });
        return false;
    });
});
layui.use('layedit', function(){
    let layedit = layui.layedit
        ,$ = layui.jquery;

    //自定义工具栏
    let index = layedit.build('describe', {
        tool: ['face', 'link', 'unlink', '|', 'left', 'center', 'right']
        ,height: 100
    });

    $('.site-demo-layedit').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});