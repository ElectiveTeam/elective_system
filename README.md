# Elective-course
## 选课系统
#####- [项目git地址](https://github.com/LYLYuLongLiu/Elective-course)
#####- git clone https://github.com/ElectiveTeam/elective_system.git

***

###系统模块
1. 选课系统
    1. 管理员模块
        1. 审核模块
        2. 授权模块
        3. 学期管理模块
        4. 课程组模块
        5. 课程管理模块
        6. 统计模块
        7. 成绩模块
    2. 教师模块
        1. 申请模块
        2. 课程模块
        3. 统计模块
        4. 成绩模块
    3. 学生模块
        1. 选课模块
        2. 成绩模块
    4. 登陆模块
***

**非分页返回数据格式**  
```json
 {
    "status" : "服务器状态,如200",
    "msg" : "服务器返回消息，如OK",
    "data" : "服务器返回数据，如无数据为null"
 }
```

**分页返回数据格式**
```json
 {
    "code" : "服务器状态,如0",
    "msg" : "服务器返回消息，如OK",
    "count" : "数据条数,如20",
    "data" : "服务器返回数据，如无数据为null"
 }
```