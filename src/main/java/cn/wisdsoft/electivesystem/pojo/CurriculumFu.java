package cn.wisdsoft.electivesystem.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>ClassName: Curriculum</p>
 * <p>Description:前端传值课程对象</p>
 *
 * @author 闫亮
 * @version 1.0
 * @date 2019/1/10 20:13
 */
public class CurriculumFu implements Serializable {
    private static final long serialVersionUID = 5590203364972740975L;
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
     * 学时
     */
    private Integer classHour;

    /**
     * 学分
     */
    private BigDecimal credit;

    /**
     * 年级
     */
    private String grade;

    /**
     * 状态（0编辑、1未审核、2已通过、3未通过）
     */
    private Integer status;

    /**
     * 课程组外键
     */
    private Integer couId;
    /**
     * 学期资源表外键
     */
    private Integer termId;
    /**
     * 备注
     */
    private String remark;

    /**
     * 描述
     */
    private String describe;

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

	public Integer getTermId() {
		return termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}