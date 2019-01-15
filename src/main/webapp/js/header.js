$(document).ready(function(){
    var jsonData = JSON.parse(sessionStorage.getItem('student'));
    console.log(jsonData);
    if(jsonData == null){
        jsonData = [];
    $("#myModal1").modal({backdrop:'static',keyboard:false});
    $("#myModal1").modal('show');
    $("#closeMo1").click(function(){
        window.location.href = "../html/studentLogin.html";
    });
    }
    else{
        // 初始化
        $("#college").text(jsonData.collegeName);
        $("#stu_name").text(jsonData.stuName);
    }

    $("#logout").click(function(){
        sessionStorage.removeItem('student');
        window.location.href = "/elective/html/studentLogin.html";
    });

    $("#changePass").click(function(){
        window.location.href = "/elective/html/stuChangePassword.html";
    });

    $("#back").click(function(){
        window.location.href = "/elective/html/stuMain.html";
    });
});
