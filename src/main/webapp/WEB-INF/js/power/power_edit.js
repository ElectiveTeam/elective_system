layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;
    form.on('submit(updatePower)', function (data) {
        //权限
        var coll = $("#myCollege").val();
        //职工号
        let worknumber = $("#worknumber").val();
        $.ajax({
            url:"http://localhost:8080/powerupdata",
            type:"post",
            data:{
                worknumber:worknumber,
                teapower:coll
            },
            success:function () {
                layer.msg('授权成功', {icon: 6, time: 1000});
                // 获得frame索引
                let index = parent.layer.getFrameIndex(window.name);
                //实时更新
                window.parent.location.reload();
                //关闭当前frame
                parent.layer.close(index);
            }

        })
        return false;
    });

    $.ajax({
        type : 'get',
        url : 'http://localhost:8080/elective/js/power/College.json',
        success(res){
            // console.log(res);
            let college = ``;
            for(let key in res) {
                const value1 = res[key];
                if($("#powers").text() == key) {
                    college += `<option id="items" selected value="${value1}">${key}</option>`;
                } else {
                    college += `<option id="items" value="${value1}">${key}</option>`;
                }
            }
            $("#myCollege").html(college);
            form.render();
        }
    })
});
$("#updatePower").click(function () {


})