package com.webproject.icollect.pojo;


public class DonateDO {

  private String did;
  private String pid;
  private String projectName;
  private int donor;
  private String donorName;
  private int donee;
  private String doneeName;
  private double money;
  private String dtime;

  public DonateDO(){}

  public DonateDO(String did, String pid, String projectName, int donor, int donee, String donorName, String doneeName, double money, String dtime){
    this.did = did;
    this.pid = pid;
    this.projectName = projectName;
    this.donor = donor;
    this.donee = donee;
    this.donorName = donorName;
    this.doneeName = doneeName;
    this.money = money;
    this.dtime = dtime;
  }

  public DonateDO(String pid, int donor, int donee, double money){
      this.pid = pid;
      this.donor = donor;
      this.donee = donee;
      this.money = money;
  }


  public String getDid() {
    return did;
  }

  public void setDid(String did) {
    this.did = did;
  }

  public String getPid() { return pid; }

  public void setPid(String pid) { this.pid = pid; }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getDtime() {
    return dtime;
  }

  public void setDtime(String dtime) {
    this.dtime = dtime;
  }

  public int getDonor() {
    return donor;
  }

  public void setDonor(int donor) {
    this.donor = donor;
  }


  public int getDonee() {
    return donee;
  }

  public void setDonee(int donee) {
    this.donee = donee;
  }

  public String getDonorName() {
    return donorName;
  }

  public void setDonorName(String donorName) {
    this.donorName = donorName;
  }

  public String getDoneeName() {
    return doneeName;
  }

  public void setDoneeName(String doneeName) {
    this.doneeName = doneeName;
  }

  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

}
