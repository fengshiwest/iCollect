package com.webproject.icollect.pojo;
/**
 * create by Zhang Ding
 * */
import java.util.List;

public class UserInfoDo {
    //对应userinfo表的字段
    private String uid;
    private String username;
    private String area;
    private String tel;
    private String description;
    //获取用户头像图片
    private String avatar;
    //用户发起的项目信息
    private List<ProjectDO> createdProject;
    //用户参与的项目信息
    private List<DonateDO> donationInfo;

    public UserInfoDo(){

    }

    public UserInfoDo(String uid){
        this.uid = uid;
    }

    public UserInfoDo(String name, String area, String tel, String description, String avatar){
        this.username = name;
        this.area = area;
        this.tel = tel;
        this.description = description;
        this.avatar = avatar;
    }

    public UserInfoDo(String name, String area, String tel){
        this.username = name;
        this.area = area;
        this.tel = tel;
    }

    public UserInfoDo(String name,String tel){
        this.username = name;
        this.tel = tel;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public String getAvatar(){
        return this.avatar;
    }

    public void setDonationInfo(List<DonateDO> dp){
        this.donationInfo = dp;
    }

    public List<DonateDO> getDonationInfo(){
        return this.donationInfo;
    }

    public void setCreatedProject(List<ProjectDO> cp){
        this.createdProject = cp;
    }
    public List<ProjectDO> getCreatedProject(){
        return this.createdProject;
    }

    public void setArea(String area){
        this.area = area;
    }
    public String getArea(){
        return this.area;
    }

    public void setTel(String tel){
        this.tel = tel;
    }
    public String getTel(){
        return this.tel;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

    public void setUsername(String name){
        this.username = name;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUid(String uid){
        this.uid = uid;
    }

    public String getUid(){
        return this.uid;
    }
}
