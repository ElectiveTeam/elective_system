package cn.wisdsoft.electivesystem.pojo;

import java.io.Serializable;

/**
 * <p>ClassName: Relationship</p>
 * <p>Description:学生课程关系对象</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/7 21:45
 */
public class Relationship implements Serializable {
    private static final long serialVersionUID = -925675723845110413L;
    private Integer id;

    /**
     * 选课编号
     */
    private Integer selectId;

    /**
     * 学生编号
     */
    private String stuId;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}