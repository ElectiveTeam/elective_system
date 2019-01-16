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
    private double usual;
    /**
     * 期中成绩
     */
    private double midterm;
    /**
     * 技能考核
     */
    private double skill;
    /**
     * 期末成绩
     */
    private double finalexam;
    /**
     * 选课编号
     */
    private Integer selectId;

    /**
     * 成绩
     */
    private double achieve;

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
    private  String teacherName;

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

    public double getAchieve() {
        return achieve;
    }

    public void setAchieve(double achieve) {
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public double getUsual() {
        return usual;
    }

    public void setUsual(double usual) {
        this.usual = usual;
    }

    public double getMidterm() {
        return midterm;
    }

    public void setMidterm(double midterm) {
        this.midterm = midterm;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public double getFinalexam() {
        return finalexam;
    }

    public void setFinalexam(double finalexam) {
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
                ", teacher='" + teacherName + '\'' +
                ", credit=" + credit +
                ", remark='" + remark + '\'' +
                '}';
    }
}