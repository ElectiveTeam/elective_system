$(() => {
    var jsonData = JSON.parse(sessionStorage.getItem('student'));
    $.ajax({
        url : 'http://localhost:8080/student/selectedCurriculum/selectDetails',
        type : 'get',
        data : {
            curriculumId : getUrlParam("cno")
        },
        success : res => {
            console.log(res);
            let content = ``;
            let {
                college,
                curriculumId,
                curriculumName,
                teacherName,
                classTime,
                place,
                classHour,
                credit,
                describe,
                courseId
            } = res.data;
            content += `<div class="card-header">
                            ${college}
                        </div>
                        <div class="card-body">
                            <input type="text" hidden id="curriculumId" value="${curriculumId}">
                            <input type="text" hidden id="courseId" value="${courseId}">
                            <div class="myTable">
                                <div class="myRow">
                                    <h5 class="card-title">课程名称</h5>
                                    <p class="card-text" id="cuName">${curriculumName}</p>
                                </div>
                                <div class="myRow">
                                    <h5 class="card-title">任课教师</h5>
                                    <p class="card-text">${teacherName}</p>
                                </div>
                            </div>
                            <div class="myTable">
                                <div class="myRow">
                                    <h5 class="card-title">上课时间</h5>
                                    <p class="card-text">${classTime}</p>
                                </div>
                                <div class="myRow">
                                    <h5 class="card-title">上课地点</h5>
                                    <p class="card-text">${place}</p>
                                </div>
                            </div>
                            <div class="myTable">
                                <div class="myRow">
                                    <h5 class="card-title">学时</h5>
                                    <p class="card-text">${classHour}</p>
                                </div>
                                <div class="myRow">
                                    <h5 class="card-title">学分</h5>
                                    <p class="card-text">${credit}</p>
                                </div>
                            </div>
                            <h5 class="card-title">课程简介</h5>
                            <p class="card-text">${describe}</p>
                            <button class="btn btn-primary btn-lg" id="choo">选课</button>
                        </div>`;
            $(".card").append(content);
        },
        error : () => {
            alert("服务器错误");
        }
    });

    $(".card").on('click','#choo',(_node) => {
        $(".tips_body").text("你是否要选择此课程："+$("#cuName").text());
        $("#tips").modal({backdrop:'static',keyboard:false});
        $("#tips").modal('show');
    });

    $("#yes").click(() => {
        let flag = true;
        let temp = $("#courseId").val();
        // let x = sessionStorage.getItem("myChoose");
        // if(x == null) {
        //     // x = JSON.parse(x);
        //     let y = [];
        //     y.push(temp);
        //     sessionStorage.setItem("myChoose",JSON.stringify(Array.from(new Set(y))));
        //     $("#tips").modal('hide');
        //     insertCurriculum('16080902031','小松松',4,'软件学院');
        // }
        let myChoose = [];
        $.ajax({
            url : 'http://localhost:8080/student/selectedCurriculum/checkCurriculum',
            type : 'post',
            async : false,
            data : {
                stuId : jsonData.id
            },
            success : res => {
                console.log(res.data);
                myChoose = res.data;
            },
            error : () => {
                alert("服务器错误");
            }
        });

        myChoose.forEach(item => {
            if(item+"" === temp) {
                flag = false;
                $(".tips1_body").text("请勿选择相似课程！");
                $("#tips1").modal({backdrop:'static',keyboard:false});
                $("#tips").modal('hide');
                $("#tips1").modal('show');
            }
        });
        if(flag) {
            // myChoose.push(temp);
            // sessionStorage.setItem("myChoose",JSON.stringify(Array.from(new Set(myChoose))));
            $("#tips").modal('hide');
            insertCurriculum(jsonData.id,jsonData.stuName,$("#curriculumId").val(),jsonData.collegeName);
        }
    });

    function getUrlParam(name) {
        const reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        const r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]);
        return null; //返回参数值
    }
    function insertCurriculum(stuId,stuName,curriculumId,yard) {
        $.ajax({
            url : 'http://localhost:8080/student/selectedCurriculum/insertRelation',
            type : 'post',
            data : {
                stuId : stuId,
                stuName : stuName,
                curriculumId : curriculumId,
                yard : yard
            },
            success : res => {
                console.log(res);
                if(res.status === 200) {
                    $(".tips1_body").text("选择成功");
                    $("#tips1").modal({backdrop:'static',keyboard:false});
                    $("#tips1").modal('show');
                    $("#yeskey").click(function(){
                        window.location.href = "http://localhost:8080/elective/html/selectedCurriculum.html";
                    });
                } else {
                    $(".tips1_body").text(res.msg);
                    $("#tips1").modal({backdrop:'static',keyboard:false});
                    $("#tips1").modal('show');
                }
            },
            error : () => {
                alert("服务器错误");
            }
        });
    }
});