var a = sessionStorage.getItem("student");
var b =  $.parseJSON( a );


if(a == null){
    a = [];
    $("#myModal1").modal({backdrop:'static',keyboard:false});
    $("#myModal1").modal('show');
    $("#closeMo1").click(function(){
        window.location.href = "../html/studentLogin.html";
    });
}


$("#chongzhi").click(function(){
    $("#password").val("");
    $("#password2").val("");
});

function yzlogin(){
    if ($("#password").val()=="") {
        alert("密码不能为空");
    } else if($("#password2").val()==""){
        alert("密码不能为空");
    } else if($("#password").val()!=$("#password2").val()){
        alert("两次输入的密码不相同");
    } else{
        var c = b.id;
        $.ajax({
            type:"post",
            url:"http://localhost:8080/student/studentLogin/StuUpdatePassword",
            data:{
                stuid:c,
                password:$("#password").val()
            },
            success:function(data){
                alert("更新密码成功,即将返回登录页面进行登录");
                window.location.href = "http://localhost:8080/elective/html/studentLogin.html"

            },
            error:function(e){
                alert("更新密码失败");
            }
        });
    }

}