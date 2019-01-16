package cn.wisdsoft.electivesystem.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>ClassName: Curriculum</p>
 * <p>Description:前端传值课程对象</p>
 *
 * @author 闫亮
 * @version 1.0
 * @date 2019/1/12 15:13
 */
public class CurriculumPage implements Serializable {
    private static final long serialVersionUID = 5590203364972740975L;
    //课程申请id
    private Integer id;
    //课程名称
    private String cuName;
    //教师编号
    private String teacherId;
    //学时
    private Integer classHour;
    //学分
    private BigDecimal credit;
    //年级
    private String grade;
    //状态（0编辑、1未审核、2已通过、3未通过）
    private Integer status;
    //课程组外键
    private Integer couId;
    //描述
    private String describe;
    //备注(驳回原因)
    private String remark;
    //由课组外键查询到的课组表中的学期资源表外键
    private Integer trId;
    //由学期资源表外键查询到的开设范围（学院）
    private String college;
    //学期名称
    private String termName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCouId() {
		return couId;
	}
	public void setCouId(Integer couId) {
		this.couId = couId;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getTrId() {
		return trId;
	}
	public void setTrId(Integer trId) {
		this.trId = trId;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getTermName() {
		return termName;
	}
	public void setTermName(String termName) {
		this.termName = termName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}