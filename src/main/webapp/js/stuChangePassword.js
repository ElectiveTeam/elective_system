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
    $("#oldpassword").val("");
    $("#password").val("");
    $("#password2").val("");
});

$("#fanhui").click(function(){
    window.location.href = "../html/stuMain.html"
});

function yzlogin(){
        if ($("#oldpassword").val()=="") {
            alert("旧密码不能为空");
        }
        else if ($("#password").val()=="") {
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
                    oldPassword:$("#oldpassword").val(),
                    newPassword:$("#password2").val()
                },
                success:function(data){
                    console.log(data);
                    if(data.status === 250){
                        alert("更新密码成功,即将返回登录页面进行登录！");
                        sessionStorage.removeItem("student");
                        window.location.href = "http://localhost:8080/elective/html/studentLogin.html"
                    }
                    else {
                        alert("旧密码输入错误！");
                    }

                },
                error:function(e){
                    alert("服务器错误！");
                }
            });
        }

    }