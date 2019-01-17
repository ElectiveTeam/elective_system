package cn.wisdsoft.electivesystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
     * 课程组名称
     */
    private String courseName;

    /**
     * 课程ID
     */
    private Integer curriculumId;

    /**
     * 课程名称
     */
    private String curriculumName;

    /**
     * 教师名称
     */
    private String teacherName;

    /**
     * 学时
     */
    private Integer classHour;

    /**
     * 学分
     */
    private BigDecimal credit;

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

    /**
     * 最小人数
     */
    private Integer minNumber;

    /**
     * 年级
     */
    private String grade;

    /**
     * 描述
     */
    private String describe;

    /**
     * 状态
     */
    private String status;

    private Integer selectionId;

    private String remark;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date openTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date closeTime;

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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
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

    public String getCourseName() {
        return courseName;
    }

    public CurriculumDo setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public Integer getMinNumber() {
        return minNumber;
    }

    public CurriculumDo setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public CurriculumDo setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public CurriculumDo setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public CurriculumDo setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getSelectionId() {
        return selectionId;
    }

    public CurriculumDo setSelectionId(Integer selectionId) {
        this.selectionId = selectionId;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
}
