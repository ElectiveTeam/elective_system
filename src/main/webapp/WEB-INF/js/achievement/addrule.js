layui.use('form', function () {
    var form = layui.form
        , layer = layui.layer;
    //监听提交
    form.on('submit(sub)', function () {
        $.ajax({
            url: 'http://localhost:8080/rule/addRule',
            type: "post",
            data: {
                selectId:$("#curriculum").val(),
                cuName:$("#curriculum option:selected").text(),
                usual:$("#usual").val(),
                midTerm:$("#midTerm").val(),
                skill:$("#skill").val(),
                finalexam:$("#finalexam").val()
            }
            , success: function () {
                layer.msg('添加成功', {icon: 6, time: 1000});
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