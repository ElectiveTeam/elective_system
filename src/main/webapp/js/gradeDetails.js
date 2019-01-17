$(function () {
    let jsonData = JSON.parse(sessionStorage.getItem('student'));
    let selectId = getUrlParam("selectId");
    if (jsonData == null) {
        jsonData = [];
        $("#myModal1").modal({backdrop: 'static', keyboard: false});
        $("#myModal1").modal('show');
        $("#closeMo1").click(function () {
            window.location.href = "../html/studentLogin.html";
        });
    }else{
        $.ajax({
            url:'http://localhost:8080/student/selectedGrade/selDetails/',
            type:'get',
            data:{
                stuId:jsonData.id,
                selectId:selectId
            },
            success:function (res) {
                 let content = `<tr>
                                    <td>平时成绩</td>
                                    <td>${res.data[1].usual}%</td>
                                    <td>${res.data[0].usual}</td>
                                </tr>
                                <tr>
                                    <td>期中考试</td>
                                    <td>${res.data[1].midterm}%</td>
                                    <td>${res.data[0].midterm}</td>
                                </tr>
                                <tr>
                                    <td>技能考核</td>
                                    <td>${res.data[1].skill}%</td>
                                    <td>${res.data[0].skill}</td>
                                </tr>
                                <tr>
                                    <td>期末成绩</td>
                                    <td>${res.data[1].finalexam}%</td>
                                    <td>${res.data[0].finalexam}</td>
                                </tr>
                                <tr>
                                    <td>总成绩</td>
                                    <td>100%</td>
                                    <td>${res.data[0].achieve}</td>
                                </tr>`;
                 $("#body").append(content);
            },
            error: function () {
                alert("服务器错误1！");
            }
        });
    }
    function getUrlParam(name) {
        const reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        const r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]);
        return null; //返回参数值
    }
})