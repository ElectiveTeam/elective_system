$(()=>{
    let content = ``;
    let flag = 0;
    $.ajax({
        url : 'http://localhost:8080/student/personCenter/selectUserCurriculum',
        type : 'get',
        data : {
            stuId : '16080902031'
        },
        success : res => {
            console.log(res);
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
            })
        },
        error : () =>{
            alert("服务器错误");
        }
    });
});