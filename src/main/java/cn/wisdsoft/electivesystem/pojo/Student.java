package cn.wisdsoft.electivesystem.pojo;

import java.io.Serializable;

/**
 * <p>ClassName: Student</p>
 * <p>Description:学生对象</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/7 21:45
 */
public class Student implements Serializable {

    private String stuId;
    public Student() {


    }

    public String getStudentId() {
        return stuId;
    }

    public void setStudentId(String studentId) {
        this.stuId = studentId;
    }
}
