package cn.wisdsoft.electivesystem.pojo;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: SongJunWei
 * @CreateDate: 2019/1/15 11:11
 * @Version: 1.0
 */
public class CourseVo implements Serializable {

    private Integer id;

    /**
     * 课程组名称
     */
    private String courseName;

    /**
     * 审核状态（0申请中、1选课进行中、2选课结束、3补选进行中、4补选结束、5授课进行中、6成绩录入中、7学期结束）
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
