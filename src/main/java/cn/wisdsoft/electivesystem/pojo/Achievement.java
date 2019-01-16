package cn.wisdsoft.electivesystem.pojo;

import java.io.Serializable;

/**
 * <p>ClassName: Achievement</p>
 * <p>Description:成绩对象</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/7 21:45
 */
public class Achievement implements Serializable {
    private static final long serialVersionUID = 6645453281008711637L;
    private Integer id;

    /**
     * 学生编号
     */
    private String stuId;

    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 平时成绩
     */
    private Integer usual;
    /**
     * 期中成绩
     */
    private Integer midterm;
    /**
     * 技能考核
     */
    private Integer skill;
    /**
     * 期末成绩
     */
    private Integer finalexam;
    /**
     * 选课编号
     */
    private Integer selectId;

    /**
     * 成绩
     */
    private Integer achieve;

    /**
     * 状态（0未发布，不可查看，1已发布，可查看）
     */
    private Integer status;
    /**
     * 课程
     */
    private String cuName;
    /**
     * 学期
     */
    private String termName;

    /**
     * 教师
     */
    private  String teacher;

    /**
     * 教师Id
     */
    private  String teacherId;
    /**
     * 学分
     */
    private double credit;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public Integer getAchieve() {
        return achieve;
    }

    public void setAchieve(Integer achieve) {
        this.achieve = achieve;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getCuName() {
        return cuName;
    }

    public void setCuName(String cuName) {
        this.cuName = cuName;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getUsual() {
        return usual;
    }

    public void setUsual(Integer usual) {
        this.usual = usual;
    }

    public Integer getMidterm() {
        return midterm;
    }

    public void setMidterm(Integer midterm) {
        this.midterm = midterm;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public Integer getFinalexam() {
        return finalexam;
    }

    public void setFinalexam(Integer finalexam) {
        this.finalexam = finalexam;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "id=" + id +
                ", stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", usual=" + usual +
                ", midterm=" + midterm +
                ", skill=" + skill +
                ", finalexam=" + finalexam +
                ", selectId=" + selectId +
                ", achieve=" + achieve +
                ", status=" + status +
                ", cuName='" + cuName + '\'' +
                ", termName='" + termName + '\'' +
                ", teacher='" + teacher + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", credit=" + credit +
                ", remark='" + remark + '\'' +
                '}';
    }
}