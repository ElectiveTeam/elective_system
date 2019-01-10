package cn.wisdsoft.electivesystem.pojo;

import java.io.Serializable;

public class StudentDo implements Serializable {

    private static final long serialVersionUID = 3325219718079238970L;
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
     * 课程编号
     */
    private int cuId;

    /**
     * 课时
     */
    private int classHour;

    /**
     * 学分
     */
    private double credit;

    /**
     * 课程简介
     */
    private String describe;

    /**
     * 年级
     */
    private String grade;

    /**
     * 教师Id(职工号)
     */
    private String teacherId;

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

    public int getCuId() {
        return cuId;
    }

    public void setCuId(int cuId) {
        this.cuId = cuId;
    }

    public int getClassHour() {
        return classHour;
    }

    public void setClassHour(int classHour) {
        this.classHour = classHour;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
