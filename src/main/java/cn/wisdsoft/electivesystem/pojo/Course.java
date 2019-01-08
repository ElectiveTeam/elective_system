package cn.wisdsoft.electivesystem.pojo;

import java.io.Serializable;

/**
 * <p>ClassName: Course</p>
 * <p>Description:课程组对象</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/7 21:45
 */
public class Course implements Serializable {
    private static final long serialVersionUID = -1132056729522746391L;
    private Integer id;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 学期外键
     */
    private Integer trId;

    private String remark;

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
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getTrId() {
        return trId;
    }

    public void setTrId(Integer trId) {
        this.trId = trId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}