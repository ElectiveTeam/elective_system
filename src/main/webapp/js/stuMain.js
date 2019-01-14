
$(document).ready(function(){

    $("#ft").load('../html/footer.html');
    $("#one").click(function(){
        $.ajax({
            url: "http://localhost:8080/student/selectedCurriculum/chooseStatus",
            type: "get",
            data:{
                category:"软件学院"
            },
            success: function(data) {
                console.log(data);
                if (data.status == 200){

                    location.href = "../html/selectedCurriculum.html";
                }else{
                    $("#myModal").modal('toggle');

                    $("#closeMo").click(function(){

                        window.location.reload();
                    });
                }
            }
            ,error: function () {
                alert("接口请求失败！");
            }
        });
    });

    $("#two").click(function(){
        location.href = "../html/personCenter.html";
    });

    $("#three").click(function(){
        location.href = "../html/selectedCurriculum.html";
    });

});