package cn.wisdsoft.electivesystem.pojo;

public class Rule {
    private Integer id;

    private Integer selectId;

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
}