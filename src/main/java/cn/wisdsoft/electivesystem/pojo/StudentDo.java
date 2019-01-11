package cn.wisdsoft.electivesystem.pojo;

import java.io.Serializable;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-01-10 14:29
 * @ Description：学生课程信息Do层
 */
public class StudentDo implements Serializable {
    private static final long serialVersionUID = 4019750860923706046L;

    /**
     * 课程ID
     */
    private Integer curriculumId;

    /**
     * 课程组ID
     */
    private Integer courseId;

    /**
     * 课程名称
     */
    private String cuName;

    /**
     * 上课时间
     */
    private String classTime;

    /**
     * 上课地点
     */
    private String place;

    /**
     * 学时
     */
    private Integer classHour;

    /**
     * 学分
     */
    private Double credit;

    /**
     * 年级
     */
    private String grade;

    /**
     * 选课表Id
     */
    private Integer selectId;

    /**
     * 教师编号
     */
    private String teacherId;

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCuName() {
        return cuName;
    }

    public void setCuName(String cuName) {
        this.cuName = cuName;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
