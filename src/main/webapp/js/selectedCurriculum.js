$(() => {
    let jsonData = JSON.parse(sessionStorage.getItem('student'));
    let termName;
    if (jsonData == null) {
        jsonData = [];
        $("#myModal1").modal({backdrop: 'static', keyboard: false});
        $("#myModal1").modal('show');
        $("#closeMo1").click(function () {
            window.location.href = "../html/studentLogin.html";
        });
    } else {

        $.ajax({
            url: 'http://localhost:8080/student/selectedCurriculum/selectTermName',
            type: 'get',
            data: {
                college: jsonData.collegeName
            },
            success: function (data) {
                termName = data.data.termName;
            },
            error: function () {
                alert("服务器错误1！");
            }
        });


        getContent(termName, '校选');
        $(".my #one").click(() => {
            $(".cugroup").empty();
            getContent(termName, '校选');
        });
        $(".my #two").click(() => {
            $(".cugroup").empty();
            getContent(termName, jsonData.collegeName);
        });
        $(".my #three").click(() => {
            $(".cugroup").empty();
            personInfo(jsonData.id, jsonData.collegeName);
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
                    console.log(res);
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
                    alert("服务器错误2");
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
                    console.log(res);
                    if (res.data.length === 0) {
                        content += `<a class="list-group-item list-group-item-action flex-column align-items-start">
                                    <div class="nonecu">
                                    <h3>暂无选课信息</h3>
                                    </div>
                                </a>`;
                        $(".cugroup").append(content);
                    } else {
                        res.data.forEach((item) => {
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
                                        selectId,
                                        courseId
                                    } = one;
                                    content += `<li class="list-group-item list-group-item-action flex-column align-items-start">
                                        <input type="text" class="selectId" hidden value="${selectId}" />
                                        <input type="text" class="courseId" hidden value="${courseId}" />
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
                    alert("服务器错误3");
                }
            });

            $(".cugroup").on("click", ".tk", (_node) => {
                let myChoose = sessionStorage.getItem("myChoose");
                if (myChoose != null) {
                    sessionStorage.removeItem("myChoose");
                }
                $.ajax({
                    url: 'http://localhost:8080/student/personCenter/delRelationByStuIdAndSelectId',
                    type: 'get',
                    data: {
                        stuId: stuId,
                        selectId: $(_node.currentTarget).siblings("input[class='selectId']").val()
                    },
                    success: res => {
                        // alert("删除成功!");
                        if (res.status === 200) {
                            // console.log(_node.currentTarget);
                            // alert($(_node.currentTarget).siblings("input[class='courseId']").val());
                            $(_node.currentTarget).parent().remove();
                            $("#myModal").modal({backdrop: 'static', keyboard: false});
                            $("#myModal").modal('show');
                        } else {
                            alert("删除失败");
                        }
                    },
                    error: () => {
                        alert("服务器错误4");
                    }
                })
            });


        }

        $(".cugroup").on('click', '#myTrue', (_node) => {
            window.location.href = "/elective/html/cudetails.html?cno=" + $(_node.currentTarget).find("input[class='curriculumId']").val();
        });
    }

});