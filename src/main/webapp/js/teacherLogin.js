$("#chongzhi").click(function(){
    $("#xuehao").val("");
    $("#password").val("");
});
function yzlogin(){
    if ($("#xuehao").val()=="") {
        alert("职工号不能为空");
    } else if($("#password").val()==""){
        alert("密码不能为空");
    } else{
        $.ajax({
            type:"post",
            url:"http://localhost:8080/teacher/TeacherLogin",
            data:{
                worknumber:$("#xuehao").val(),
                teaPassword:$("#password").val()
            },
            success:function(data){
                if (data.status === 200) {
                    sessionStorage.setItem("teacher",JSON.stringify(data.data));
                    window.location.href="http://localhost:8080/index";
                }else {
                    alert(data.msg)
                }
            },
            error:function(e){
                alert("失败");
            }
        });
    }

}