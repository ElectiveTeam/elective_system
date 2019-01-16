$(() => {
    getContent('2018-2019学年第1学期', '校选');
    $(".my #one").click(() => {
        $(".cugroup").empty();
        getContent('2018-2019学年第1学期', '校选');
    });
    $(".my #two").click(() => {
        $(".cugroup").empty();
        getContent('2018-2019学年第1学期', '软件学院');
    });
    $(".my #three").click(() => {
        $(".cugroup").empty();
        personInfo('16080902031', '软件学院');
    });

    function getContent(termName, category, content = ``) {
        $.ajax({
            url: 'http://localhost:8080/student/selectedCurriculum/selectAllCurriculum',
            type: 'get',
            data: {
                termName: termName,
                category: category
            },
            success: res => {
                if (res.data.length === 0) {
                    content += `<a class="list-group-item list-group-item-action flex-column align-items-start">
                                    <div class="nonecu">
                                    <h3>暂无课程提供选择</h3>
                                    </div>
                                </a>`;
                } else {
                    res.data.forEach((item) => {
                        let {
                            curriculumName,
                            place,
                            classTime,
                            credit,
                            classHour,
                            teacherName,
                            remark,
                            curriculumId,
                            courseId
                        } = item;
                        if (`${remark}` === '招生中') {
                            content += `<a class="list-group-item list-group-item-action flex-column align-items-start" id="myTrue">
                                        <input type="text" class="courseId" hidden value="${courseId}"/>
                                        <input type="text" class="curriculumId" hidden value="${curriculumId}">
                                        <div class="d-flex w-100 justify-content-between">
                                            <h5 class="mb-1">${curriculumName}</h5>
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
                                        <small class="text-muted"><span class="tk1">${remark}</span></small>
                                    </a>`;
                        } else {
                            content += `<a class="list-group-item list-group-item-action flex-column align-items-start" id="myFalse">
                                        <input type="text" class="teacherName" hidden value="${courseId}"/>
                                        <input type="text" class="curriculumId" hidden value="${curriculumId}">
                                        <div class="d-flex w-100 justify-content-between">
                                            <h5 class="mb-1">${curriculumName}</h5>
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
                                        <small class="text-muted"><span class="tk2">${remark}</span></small>
                                    </a>`;
                        }
                    });
                }
                $(".cugroup").append(content);
            },
            error: () => {
                alert("服务器错误");
            }
        });
    }

    function personInfo(stuId, college, content = ``) {
        $.ajax({
            url: 'http://localhost:8080/student/selectedCurriculum/chosenCurriculum',
            type: 'get',
            data: {
                stuId: stuId,
                college: college
            },
            success: res => {
                if (res.data.length === 0) {
                    content += `<a class="list-group-item list-group-item-action flex-column align-items-start">
                                    <div class="nonecu">
                                    <h3>暂无选课信息</h3>
                                    </div>
                                </a>`;
                } else {
                    res.data.forEach((item) => {
                        console.log(item);
                        let {
                            termName,
                            studentDos: studentDos,
                        } = item;
                        content += `<li class="list-group-item list-group-item-action list-group-item-primary" hidden>${termName}</li>`;
                        $(".cugroup").append(content);
                        content = ``;
                        if (studentDos.length === 0) {
                            content += `<a class="list-group-item list-group-item-action flex-column align-items-start">
                                            <div class="nonecu">
                                            <h3>暂无选课信息</h3>
                                            </div>
                                        </a>`;
                            $(".cugroup").append(content);
                        } else {
                            studentDos.forEach((one) => {
                                let {
                                    cuName,
                                    place,
                                    classTime,
                                    credit,
                                    classHour,
                                    teacherName,
                                    selectId
                                } = one;
                                content += `<li class="list-group-item list-group-item-action flex-column align-items-start">
                                        <input type="text" class="selectId" hidden value="${selectId}" />
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
                                        <small class="text-muted tk" data-toggle="modal" data-target="#myM odal"><span>退课</span></small>
                                    </li>`;
                            });
                        }
                    });
                    $(".cugroup").append(content);
                }
            },
            error: () => {
                alert("服务器错误");
            }
        });

        $(".cugroup").on("click", ".tk", (_node) => {
            $.ajax({
                url: 'http://localhost:8080/student/personCenter/delRelationByStuIdAndSelectId',
                type: 'get',
                data: {
                    stuId: stuId,
                    selectId: $(".selectId").val()
                },
                success: res => {
                    // alert("删除成功!");
                    if(res.status === 200) {
                        // console.log(_node.currentTarget);
                        $(_node.currentTarget).parent().remove();
                        $("#myModal").modal('show');
                        $("#closeMo").click(function(){
                            $("#myModal").modal({backdrop:false});
                        });
                    } else {
                        alert("删除失败");
                    }
                },
                error: () => {
                    alert("服务器错误");
                }
            })
        });


    }
});