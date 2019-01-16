$(function () {
    let jsonData = JSON.parse(sessionStorage.getItem('student'));
    if (jsonData == null) {
        jsonData = [];
        $("#myModal1").modal({backdrop: 'static', keyboard: false});
        $("#myModal1").modal('show');
        $("#closeMo1").click(function () {
            window.location.href = "../html/studentLogin.html";
        });
    }else{
        $.ajax({
            url:'http://localhost:8080/student/selectedGrade/',
            type:'get',
            data:{
                stuId:jsonData.id
            },
            success:function (res) {
                 console.log(res);
                 if(res.data === null){
                     let content = `<a class="list-group-item list-group-item-action flex-column align-items-start">
                                            <div class="nonecu">
                                            <h3>暂无成绩</h3>
                                            </div>
                                        </a>`;
                     $("#body").append(content);
                 }
                 else{
                     let content = `<table class="table table-bordered">
                                    <thead>
                                    <tr class="myTr">
                                        <th>学期</th>
                                        <th>课程名称</th>
                                        <th>任课教师</th>
                                        <th>平时成绩</th>
                                        <th>期中考试</th>
                                        <th>技能考核</th>
                                        <th>期末成绩</th>
                                        <th>学分</th>
                                        <th>总成绩</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>`
                     res.data.forEach((one) => {
                         let {
                             termName,
                             cuName,
                             teacherName,
                             usual,
                             midterm,
                             skill,
                             finalexam,
                             credit,
                             achieve,
                             selectId,
                             stuId
                         } = one;
                         if(achieve<60){
                             credit=0;
                         }
                         content += `<tr>
                                    <td>${termName}</td>
                                    <td>${cuName}</td>
                                    <td>${teacherName}</td>
                                    <td>${usual}</td>
                                    <td>${midterm}</td>
                                    <td>${skill}</td>
                                    <td>${finalexam}</td>
                                    <td>${credit}</td>
                                    <td>${achieve}</td>
                                    <td><a href="http://localhost:8080/elective/html/gradeDetails.html/?selectId=${selectId}">详情</a></td>
                                </tr>`;
                     });
                     content += `</tbody>
                                </table>`;
                     $("#body").append(content);
                 }
            },
            error: function () {
                alert("服务器错误1！");
            }
        });
    }

})