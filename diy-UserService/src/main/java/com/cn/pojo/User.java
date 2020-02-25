package com.cn.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "t_inv_personal")
public class User {
    @Id   // 表明id
   // @GeneratedValue   //  自动生成
    private String personal_id;
    private String id;
    private String name;
    private Integer gender;
    private String nowAdd;
    private Integer  hukouKind ;
    private String  cityid;
    private Integer  statusRecord;
    private String address;
    private String tel;
    private String cardNum;
private String area_code;
    private String birthdate;

    private String cdpfWjId;//残疾人调查信息id
    private String  cdpfWjStatus;//上报状态 4未调查3已调查
    private String investigationWay="0";//调查方式 调查方式 1.入户调查 2.电话采访
    private String personalStatus;//核查状态1.查无此人 2. 已搬迁 3. 空挂户 4. 外出 5. 死亡 6. 正常
    private String cjType;//采集状态 2app 1pc
    private String phone;
    private String idtKind;//残疾类别
    private String idtLevel;//残疾等级
    private String iqLevel;//智力残疾等级
    private String mentalLevel;//精神残疾等级
    private String bodyLevel;//肢体残疾等级
    private Integer age=0;

    private String code;

    private int status;//上报状态（数据上报的栏目）
    private String modifyCommon;//MODIFY_COMMON 就2个值都是中文，死亡待注销和已注销

    private String productTime;//创建时间
    private String editTime;//修改时间
    private String if_welfare_living;//是否在敬（养）老院、福利院、荣军院居住


    private String myimage;
    /**
     * 填报状态
     * 1：未填报
     * 2：已填报
     */
    private String cdpfTBStatus;
    /**
     * 是否属于在校大学生
     * 1：是
     */
    private String daxuesheng;
    /**
     * 是否需要危房改造
     * 1:是
     */
    private String weifang;

    /**
     * 是否低保
     * 1：是
     */
    private String dibao;
    /**
     * 是否低保
     * 1：是
     */
    private String jiandanglika;

    public String getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(String personal_id) {
        this.personal_id = personal_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNowAdd() {
        return nowAdd;
    }

    public void setNowAdd(String nowAdd) {
        this.nowAdd = nowAdd;
    }

    public Integer getHukouKind() {
        return hukouKind;
    }

    public void setHukouKind(Integer hukouKind) {
        this.hukouKind = hukouKind;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public Integer getStatusRecord() {
        return statusRecord;
    }

    public void setStatusRecord(Integer statusRecord) {
        this.statusRecord = statusRecord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCdpfWjId() {
        return cdpfWjId;
    }

    public void setCdpfWjId(String cdpfWjId) {
        this.cdpfWjId = cdpfWjId;
    }

    public String getCdpfWjStatus() {
        return cdpfWjStatus;
    }

    public void setCdpfWjStatus(String cdpfWjStatus) {
        this.cdpfWjStatus = cdpfWjStatus;
    }

    public String getInvestigationWay() {
        return investigationWay;
    }

    public void setInvestigationWay(String investigationWay) {
        this.investigationWay = investigationWay;
    }

    public String getPersonalStatus() {
        return personalStatus;
    }

    public void setPersonalStatus(String personalStatus) {
        this.personalStatus = personalStatus;
    }

    public String getCjType() {
        return cjType;
    }

    public void setCjType(String cjType) {
        this.cjType = cjType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdtKind() {
        return idtKind;
    }

    public void setIdtKind(String idtKind) {
        this.idtKind = idtKind;
    }

    public String getIdtLevel() {
        return idtLevel;
    }

    public void setIdtLevel(String idtLevel) {
        this.idtLevel = idtLevel;
    }

    public String getIqLevel() {
        return iqLevel;
    }

    public void setIqLevel(String iqLevel) {
        this.iqLevel = iqLevel;
    }

    public String getMentalLevel() {
        return mentalLevel;
    }

    public void setMentalLevel(String mentalLevel) {
        this.mentalLevel = mentalLevel;
    }

    public String getBodyLevel() {
        return bodyLevel;
    }

    public void setBodyLevel(String bodyLevel) {
        this.bodyLevel = bodyLevel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getModifyCommon() {
        return modifyCommon;
    }

    public void setModifyCommon(String modifyCommon) {
        this.modifyCommon = modifyCommon;
    }

    public String getProductTime() {
        return productTime;
    }

    public void setProductTime(String productTime) {
        this.productTime = productTime;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getIf_welfare_living() {
        return if_welfare_living;
    }

    public void setIf_welfare_living(String if_welfare_living) {
        this.if_welfare_living = if_welfare_living;
    }

    public String getMyimage() {
        return myimage;
    }

    public void setMyimage(String myimage) {
        this.myimage = myimage;
    }

    public String getCdpfTBStatus() {
        return cdpfTBStatus;
    }

    public void setCdpfTBStatus(String cdpfTBStatus) {
        this.cdpfTBStatus = cdpfTBStatus;
    }

    public String getDaxuesheng() {
        return daxuesheng;
    }

    public void setDaxuesheng(String daxuesheng) {
        this.daxuesheng = daxuesheng;
    }

    public String getWeifang() {
        return weifang;
    }

    public void setWeifang(String weifang) {
        this.weifang = weifang;
    }

    public String getDibao() {
        return dibao;
    }

    public void setDibao(String dibao) {
        this.dibao = dibao;
    }

    public String getJiandanglika() {
        return jiandanglika;
    }

    public void setJiandanglika(String jiandanglika) {
        this.jiandanglika = jiandanglika;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }
}
