package com.webproject.icollect.pojo;


public class CommentDO {

  private String cid;
  private String ctime;
  private String pid;
  private String projectName;
  private int uid;
  private String username;
  private String content;
  private String avatar;

  public CommentDO(){}

  public CommentDO(String cid,String ctime, String pid, String projectName, int uid, String username, String content, String avatar){
    this.cid = cid;
    this.ctime = ctime;
    this.pid = pid;
    this.projectName = projectName;
    this.uid = uid;
    this.username = username;
    this.content = content;
    //添加评论中的头像图片部分
    this.avatar = avatar;
  }

  public CommentDO(String pid, int uid, String content){
    this.pid = pid;
    this.uid = uid;
    this.content = content;
  }

  //对应的get set方法
  public void setAvatar(String avatar){
    this.avatar = avatar;
  }
  public String getAvatar(){
    return this.avatar;
  }

  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }

  public String getCtime() {
    return ctime;
  }

  public void setCtime(String ctime) {
    this.ctime = ctime;
  }

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
