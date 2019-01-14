$(function () {
    let couseId = null,courseName=null;
    $.ajax({
        url:'http://localhost:8080/course/selectCource',
        type:"get",
        data:{},
        success: function (res) {
            let responseCourse = res.data;
            for (let courseList of responseCourse) {
                console.log(courseList);
                let ressults=`
                <div class="layui-colla-item">
                    <h2 class="layui-colla-title" data-id="${courseList.id}">${courseList.courseName}</h2>
                    <div class="layui-colla-content">
                      <p><table class="layui-hide" id="curriculum${courseList.id}"  lay-filter="curriculum"></table></p>
                    </div>
                </div>
                `;
                $(".layui-collapse").append(ressults);
                layui.use(['element', 'layer'], function(){
                    var element = layui.element;
                    var layer = layui.layer;
                    //监听折叠
                    element.on('collapse(test)', function(data){
                        // layer.msg('展开状态：'+ data.show);
                        if(data.show===true){
                            //分组编号
                            couseId = $(this).data("id");
                            console.log(couseId);
                            layui.use('table', function(){
                                var table = layui.table;
                                table.render({
                                    elem: '#curriculum'+couseId
                                    ,url:'http://localhost:8080/course/SelectCurriculum?couId='+couseId
                                    // ,toolbar: '#toolbarDemo'
                                    ,cellMinWidth: 80
                                    ,title: '用户数据表'
                                    ,cols: [[
                                        // {type: 'checkbox', fixed: 'left'}
                                        {field:'id', title:'课程编号', sort: true,align: 'center'}
                                        ,{field:'cuName', title:'课程名称',align: 'center'}
                                        ,{field:'teacherName', title:'教师名称',align: 'center'}
                                        ,{field:'classHour', title:'学时',align: 'center'}
                                        ,{field:'credit', title:'学分',align: 'center'}
                                        ,{field:'grade', title:'年级',align: 'center'}
                                        ,{field:'status', title:'状态',align: 'center',templet: '#status'}
                                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo',align: 'center'}
                                    ]]
                                    ,page: false
                                });

                                //监听行工具事件
                                table.on('tool(curriculum)', function(obj){
                                    var data = obj.data;
                                    //课程组名称
                                    let str = $(obj.tr).parents(".layui-colla-content").siblings(".layui-colla-title").html();
                                    var arr = str.split("<")[0];
                                    if(obj.event === 'del'){
                                        // console.log($(obj.tr).parents(".layui-table-main").find("tr"));
                                        //查看该分组下有几门课程，将小于一的组删除
                                        // let trs = $(obj.tr).parents(".layui-table-main").find("tr");
                                        // if(trs.length<=1){
                                        // layer.confirm('真的删除行么', function(index){
                                        //     $.ajax({
                                        //         url:'http://localhost:8080/course/deleteCourseById',
                                        //         type:"get",
                                        //         data:{id:data.couId},
                                        //         success: function (res) {
                                        //             let responseCourse = res.data;
                                        //             console.log(res);
                                        //             obj.del();
                                        //             layer.close(index);
                                        //         },error: function (res) {
                                        //
                                        //         }
                                        //     })
                                        // });
                                        // }
                                    } else if(obj.event === 'edit'){
                                        layer.open({
                                            type: 2,
                                            title :'修改分组',
                                            offset: 't',
                                            area: ['455px', '400px'],
                                            skin: 'layui-layer-demo', //样式类名
                                            closeBtn: 1, //显示关闭按钮
                                            content: '/course/courseEdit?curId='+data.id+"&cuName="+data.cuName+"&courseName="+arr
                                        });
                                    }
                                });
                            });
                        }
                    });
                });
            }
        },error: function (res) {

        }
    })
});