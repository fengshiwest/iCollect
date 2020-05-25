package com.webproject.icollect.pojo;


public class DonateDO {

  private String did;
  private String pid;
  private String donor;
  private String donee;
  private double money;
  private String dtime;

  public DonateDO(){}

  public DonateDO(String did, String pid, String donor, String donee, double money, String dtime){
    this.did = did;
    this.pid = pid;
    this.donor = donor;
    this.donee = donee;
    this.money = money;
    this.dtime = dtime;
  }

  public DonateDO(String pid, String donor, String donee, double money){
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

  public String getDtime() {
    return dtime;
  }

  public void setDtime(String dtime) {
    this.dtime = dtime;
  }


  public String getDonor() {
    return donor;
  }

  public void setDonor(String donor) {
    this.donor = donor;
  }


  public String getDonee() {
    return donee;
  }

  public void setDonee(String donee) {
    this.donee = donee;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

}
