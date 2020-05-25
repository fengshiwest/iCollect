package com.webproject.icollect.pojo;


public class CommentDO {

  private String cid;
  private String ctime;
  private String pid;
  private String uid;
  private String content;

  public CommentDO(){}

  public CommentDO(String cid,String ctime, String pid, String uid, String content){
    this.cid = cid;
    this.ctime = ctime;
    this.pid = pid;
    this.uid = uid;
    this.content = content;
  }

  public CommentDO(String pid, String uid, String content){
    this.pid = pid;
    this.uid = uid;
    this.content = content;
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


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
