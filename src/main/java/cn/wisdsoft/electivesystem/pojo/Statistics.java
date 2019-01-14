package cn.wisdsoft.electivesystem.pojo;

import java.math.BigDecimal;

public class Statistics {
	
	/**
	 * 学期
	 */
	private String termName;
	
	/**
	 * 学院
	 */
	private String college;
	
	/**
	 * 课程编号
	 */
	private Integer id;

	/**
	 * 课程名称
	 */
	private String cuName;
	
	/**
	 * 教师编号
	 */
	private String teacherId;

	/**
	 * 教师姓名
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
     * 地点
     */
    private String place;
	
    /**
	 * 已选人数
	 */
    
    private Integer countNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getCuName() {
		return cuName;
	}

	public void setCuName(String cuName) {
		this.cuName = cuName;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() { return teacherName; }

	public void setTeacherName(String teacherName) { this.teacherName = teacherName; }

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

	public Integer getCountNum() {
		return countNum;
	}

	public void setCountNum(Integer countNum) {
		this.countNum = countNum;
	}
    
    
}
