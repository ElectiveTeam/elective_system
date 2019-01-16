package cn.wisdsoft.electivesystem.pojo;

public class Rule {
    private Integer id;

    private Integer selectId;

    private String CuName;

    private Integer usual;

    private Integer midterm;

    private Integer skill;

    private Integer finalexam;

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

    public Integer getUsual() {
        return usual;
    }

    public void setUsual(Integer usual) {
        if(usual==null){
            this.usual=0;
        }else {
            this.usual = usual;
        }
    }

    public Integer getMidterm() {
        return midterm;
    }

    public void setMidterm(Integer midterm) {
        if(midterm==null){
            this.midterm=0;
        }else {
            this.midterm = midterm;
        }
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        if(skill==null){
            this.skill=0;
        }else {
            this.skill = skill;
        }
    }

    public Integer getFinalexam() {
        return finalexam;
    }

    public void setFinalexam(Integer finalexam) {
        if(finalexam==null){
            this.finalexam=0;
        }else {
            this.finalexam = finalexam;
        }
    }

    public String getCuName() {
        return CuName;
    }

    public void setCuName(String cuName) {
        CuName = cuName;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", selectId=" + selectId +
                ", CuName='" + CuName + '\'' +
                ", usual=" + usual +
                ", midterm=" + midterm +
                ", skill=" + skill +
                ", finalexam=" + finalexam +
                '}';
    }
}