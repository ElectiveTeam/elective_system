package cn.wisdsoft.electivesystem.pojo;

import java.io.Serializable;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-01-10 20:47
 * @ Description：查询所有课程详细信息的Do层
 */
public class CurriculumDo implements Serializable {
    private static final long serialVersionUID = -7050086613521584905L;

    /**
     * 学期名称
     */
    private String termName;

    /**
     * 学院名称
     */
    private String college;

    /**
     * 课程组ID
     */
    private Integer courseId;

    /**
     * 课程ID
     */
    private Integer curriculumId;

    /**
     * 课程名称
     */
    private String curriculumName;

    /**
     * 教师ID
     */
    private String teacherId;

    /**
     * 学时
     */
    private Integer classHour;

    /**
     * 学分
     */
    private Double credit;

    /**
     * 上课时间
     */
    private String classTime;

    /**
     * 上课地点
     */
    private String place;

    /**
     * 最大人数
     */
    private Integer maxNumber;

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }
}
