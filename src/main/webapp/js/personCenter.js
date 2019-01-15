$(()=>{
    var jsonData = JSON.parse(sessionStorage.getItem('student'));
    if(jsonData == null) {
        jsonData = [];
        $("#myModal1").modal('hide');
        $("#myModal1").modal({backdrop: 'static', keyboard: false});
        $("#myModal1").modal('show');
        $("#closeMo1").click(function () {
            window.location.href = "../html/studentLogin.html";
        });
    }
    let content = ``;
    let flag = 0;
    $.ajax({
        url : 'http://localhost:8080/student/personCenter/selectUserCurriculum',
        type : 'get',
        data : {
            stuId : jsonData.id
        },
        success : res => {
            console.log(res);
            if(res.data.length === 0) {
                content += `<a class="list-group-item list-group-item-action flex-column align-items-start">
                                <div class="history">
                                <h3>暂无选课历史</h3>
                                </div>
                            </a>`;
                $(".list-group").append(content);
                content = ``;
            }
            res.data.forEach((item) => {
                console.log(item);
                let {
                    termName,
                    studentDos : studentDos
                } = item;
                content += `<div class="cugroup" id="${flag}">
                                <li class="list-group-item list-group-item-action list-group-item-primary">${termName}</li>
                            </div>`;
                $(".list-group").append(content);
                content = ``;
                studentDos.forEach(one => {
                    let {
                        cuName,
                        place,
                        classTime,
                        credit,
                        classHour,
                        teacherName
                    } = one;
                    content += `<li class="list-group-item list-group-item-action flex-column align-items-start">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h5 class="mb-1">${cuName}</h5>
                                        <small class="text-muted">${teacherName}</small>
                                    </div>
                                    <p class="mb-1 cuinfo">
                                        <span>地点:</span>
                                        <span>${place}</span>
                                        <span class="cutime">时间:</span>
                                        <span>${classTime}</span>
                                    </p>
                                    <small class="text-muted"><span>学分：</span><span>${credit}</span></small>
                                    <small class="text-muted cutime"><span>学时：</span><span>${classHour}</span></small>
                                    <!--<small class="text-muted tk" data-toggle="modal" data-target="#myModal">退课</small>-->
                                </li>`;
                });
                $(`#${flag}`).append(content);
                content = ``;
                flag++;
            })
        },
        error : () =>{
            alert("服务器错误");
        }
    });
});