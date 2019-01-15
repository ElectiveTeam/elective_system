
$(document).ready(function(){
    var jsonData = JSON.parse(sessionStorage.getItem('student'));
    console.log(jsonData);
    if(jsonData == null){
        jsonData = [];
        $(".modal-body").text("用户未登录，请先登录！");
        $("#myModal").modal('show');
        $("#closeMo").click(function(){
            $("#myModal").modal({backdrop:'static',keyboard:false});
            window.location.href = "../html/studentLogin.html";
        });
    }
    else{
        $("#ft").load('../html/footer.html');
        $("#one").click(function(){
            $.ajax({
                url: "http://localhost:8080/student/selectedCurriculum/chooseStatus",
                type: "get",
                data:{
                    category:jsonData.collegeName
                },
                success: function(data) {
                    console.log(data);
                    if (data.status == 200){

                        location.href = "http://localhost:8080/elective/html/selectedCurriculum.html";
                    }else{
                        $("#myModal").modal('show');

                        $("#closeMo").click(function(){
                            $("#myModal").modal({backdrop:'static',keyboard:false});

                        });
                    }
                }
                ,error: function () {
                    alert("接口请求失败！");
                }
            });
        });

        $("#two").click(function(){
            location.href = "http://localhost:8080/elective/html/personCenter.html";
        });

        $("#three").click(function(){
            location.href = "http://localhost:8080/elective/html/selectedCurriculum.html";
        });
    }
});