$('#myFrame').attr('src','http://localhost:8080/statistics/main');
layui.use('element', function () {
    var element = layui.element;
    active = {
        tabAdd: function (title, id, uri) {
            element.tabAdd('demo', {
                title: title,
                content: '<iframe frameborder="0" name="content" scrolling="yes" width="100%" height="600px" src="http://localhost:8080/'+uri+'"></iframe>', //支持传入html
                id: id
            })
        },
        tabChange: function (id) {
            //切换到指定Tab项
            element.tabChange('demo', id); //切换到：用户管理
        }
    }
    $('.my-demo').on('click', function () {
        var dataid = $(this);
        var id = dataid.attr('data-id');
        var title = dataid.text();
        var uri = dataid.attr('data-uri');
        var li = $('.layui-tab-title li[lay-id=' + id + ']').length;
        if (li > 0) {
            active.tabChange(id);
        } else {
            active.tabAdd(title, id, uri);
            active.tabChange(id);
        }
        // active.tabAdd(title, id, uri);
        // active.tabChange(id);
    });
});

function logout() {
    $.ajax({
        url : 'http://localhost:8080/administrator/removeToken',
        type : 'post',
        data : {
            token : sessionStorage.getItem("token")
        },
        success(msg){
            if(msg.status === 200) {
                sessionStorage.removeItem("token");
                window.location.href = "http://localhost:8080/administrator/login";
            } else {
                alert("退出失败");
            }
        },
        error(){
            alert("服务器错误")
        }
    });
}