package cn.wisdsoft.electivesystem.pojo.VO;

import java.util.Date;

public class Student {
    private String id;

    private String stuName;

    private String stuSex;

    private Date stuBirthday;

    private String stuNative;

    private Date stuEntrancetime;

    private Date stuGraduationtime;

    private String stuPoliticalface;

    private String stuFamilynumber;

    private String stuAddress;

    private String stuPhone;

    private String stuIdcard;

    private String stuMajorid;

    private String stuNational;

    private Integer stuDelflag;

    private String stuStatus;

    private String stuProvince;

    private String stuSource;

    private String stuCulobject;

    private String stuCulcategory;

    private String stuSchooltype;

    private String stuGradcategory;

    private String stuCandidatetype;

    private String stuQq;

    private String stuPassword;

    private String remark;

    private String stuPicture;

    private String majorName;

    private String collegeName;




    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", stuName=" + stuName + ", stuSex=" + stuSex + ", stuBirthday=" + stuBirthday
                + ", stuNative=" + stuNative + ", stuEntrancetime=" + stuEntrancetime + ", stuGraduationtime="
                + stuGraduationtime + ", stuPoliticalface=" + stuPoliticalface + ", stuFamilynumber=" + stuFamilynumber
                + ", stuAddress=" + stuAddress + ", stuPhone=" + stuPhone + ", stuIdcard=" + stuIdcard + ", stuMajorid="
                + stuMajorid + ", stuNational=" + stuNational + ", stuDelflag=" + stuDelflag + ", stuStatus="
                + stuStatus + ", stuProvince=" + stuProvince + ", stuSource=" + stuSource + ", stuCulobject="
                + stuCulobject + ", stuCulcategory=" + stuCulcategory + ", stuSchooltype=" + stuSchooltype
                + ", stuGradcategory=" + stuGradcategory + ", stuCandidatetype=" + stuCandidatetype + ", stuQq=" + stuQq
                + ", stuPassword=" + stuPassword + ", remark=" + remark + ", stuPicture=" + stuPicture + ", majorName="
                + majorName + "]";
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex == null ? null : stuSex.trim();
    }

    public Date getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getStuNative() {
        return stuNative;
    }

    public void setStuNative(String stuNative) {
        this.stuNative = stuNative == null ? null : stuNative.trim();
    }

    public Date getStuEntrancetime() {
        return stuEntrancetime;
    }

    public void setStuEntrancetime(Date stuEntrancetime) {
        this.stuEntrancetime = stuEntrancetime;
    }

    public Date getStuGraduationtime() {
        return stuGraduationtime;
    }

    public void setStuGraduationtime(Date stuGraduationtime) {
        this.stuGraduationtime = stuGraduationtime;
    }

    public String getStuPoliticalface() {
        return stuPoliticalface;
    }

    public void setStuPoliticalface(String stuPoliticalface) {
        this.stuPoliticalface = stuPoliticalface == null ? null : stuPoliticalface.trim();
    }

    public String getStuFamilynumber() {
        return stuFamilynumber;
    }

    public void setStuFamilynumber(String stuFamilynumber) {
        this.stuFamilynumber = stuFamilynumber == null ? null : stuFamilynumber.trim();
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress == null ? null : stuAddress.trim();
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public String getStuIdcard() {
        return stuIdcard;
    }

    public void setStuIdcard(String stuIdcard) {
        this.stuIdcard = stuIdcard == null ? null : stuIdcard.trim();
    }

    public String getStuMajorid() {
        return stuMajorid;
    }

    public void setStuMajorid(String stuMajorid) {
        this.stuMajorid = stuMajorid == null ? null : stuMajorid.trim();
    }

    public String getStuNational() {
        return stuNational;
    }

    public void setStuNational(String stuNational) {
        this.stuNational = stuNational == null ? null : stuNational.trim();
    }

    public Integer getStuDelflag() {
        return stuDelflag;
    }

    public void setStuDelflag(Integer stuDelflag) {
        this.stuDelflag = stuDelflag;
    }

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus == null ? null : stuStatus.trim();
    }

    public String getStuProvince() {
        return stuProvince;
    }

    public void setStuProvince(String stuProvince) {
        this.stuProvince = stuProvince == null ? null : stuProvince.trim();
    }

    public String getStuSource() {
        return stuSource;
    }

    public void setStuSource(String stuSource) {
        this.stuSource = stuSource == null ? null : stuSource.trim();
    }

    public String getStuCulobject() {
        return stuCulobject;
    }

    public void setStuCulobject(String stuCulobject) {
        this.stuCulobject = stuCulobject == null ? null : stuCulobject.trim();
    }

    public String getStuCulcategory() {
        return stuCulcategory;
    }

    public void setStuCulcategory(String stuCulcategory) {
        this.stuCulcategory = stuCulcategory == null ? null : stuCulcategory.trim();
    }

    public String getStuSchooltype() {
        return stuSchooltype;
    }

    public void setStuSchooltype(String stuSchooltype) {
        this.stuSchooltype = stuSchooltype == null ? null : stuSchooltype.trim();
    }

    public String getStuGradcategory() {
        return stuGradcategory;
    }

    public void setStuGradcategory(String stuGradcategory) {
        this.stuGradcategory = stuGradcategory == null ? null : stuGradcategory.trim();
    }

    public String getStuCandidatetype() {
        return stuCandidatetype;
    }

    public void setStuCandidatetype(String stuCandidatetype) {
        this.stuCandidatetype = stuCandidatetype == null ? null : stuCandidatetype.trim();
    }

    public String getStuQq() {
        return stuQq;
    }

    public void setStuQq(String stuQq) {
        this.stuQq = stuQq == null ? null : stuQq.trim();
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword == null ? null : stuPassword.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStuPicture() {
        return stuPicture;
    }

    public void setStuPicture(String stuPicture) {
        this.stuPicture = stuPicture == null ? null : stuPicture.trim();
    }
}