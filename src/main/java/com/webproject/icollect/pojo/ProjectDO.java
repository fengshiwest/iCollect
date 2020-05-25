package com.webproject.icollect.pojo;


public class ProjectDO {


  private String pid = "";
  private int authorID;
  private String author = "";
  private String name = "";
  private String introduction  = "";
  private String image  = "";
  private String startTime  = "";
  private String endTime  = "";
  private double targetMoney;
  private double currentMoney;
  private boolean isFinished;
  private boolean isChecked;
  private boolean isEnded;
  private String qrCode = "";
  private String category;

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public int getAuthorID() {
    return authorID;
  }

  public void setAuthorID(int authorID) {
    this.authorID = authorID;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public double getTargetMoney() {
    return targetMoney;
  }

  public void setTargetMoney(double targetMoney) {
    this.targetMoney = targetMoney;
  }

  public double getCurrentMoney() {
    return currentMoney;
  }

  public void setCurrentMoney(double currentMoney) {
    this.currentMoney = currentMoney;
  }

  public boolean getIsFinished() {
    return isFinished;
  }

  public void setIsFinished(boolean finished) {
    isFinished = finished;
  }

  public boolean getIsChecked() {
    return isChecked;
  }

  public void setIsChecked(boolean checked) {
    isChecked = checked;
  }

  public boolean getIsEnded() {
    return isEnded;
  }

  public void setIsEnded(boolean ended) {
    isEnded = ended;
  }

  public String getQrCode() {
    return qrCode;
  }

  public void setQrCode(String qrCode) {
    this.qrCode = qrCode;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
