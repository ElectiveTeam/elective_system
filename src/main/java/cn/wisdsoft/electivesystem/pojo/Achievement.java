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
}