$("#chongzhi").click(function(){
    $("#xuehao").val("");
    $("#password").val("");
});
function yzlogin(){
    if ($("#xuehao").val()=="") {
        alert("学号不能为空");
    } else if($("#password").val()==""){
        alert("密码不能为空");
    } else{
        $.ajax({
            type:"post",
            url:"http://localhost:8080/student/studentLogin/StudentLogin",
            data:{
                xuehao:$("#xuehao").val(),
                password:$("#password").val()
            },
            success:function(data){
                console.log(data);
                if (data.status === 200) {
                    sessionStorage.setItem("student",JSON.stringify(data.data));
                    console.log(data.data);
                    window.location.href="http://localhost:8080/elective/html/stuMain.html";
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