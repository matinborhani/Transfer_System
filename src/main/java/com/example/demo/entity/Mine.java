package com.example.demo.entity;


import javax.persistence.*;

@Entity
@Table(name = "MINE")
public class Mine {

  @Id
  @Column(name = "MINE_ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long mineId;
  @Column(name = "NAM_MINE")
  private String namMine;
  @Column(name = "COD_NTN_MINE")
  private String codNtnMine;
  @Column(name = "COD_POST_MINE")
  private String codPostMine;
  @Column(name = "NUM_TEL_MINE")
  private String numTelMine;
  @Column(name = "ADDR_MINE")
  private String addr;


  public long getMineId() {
    return mineId;
  }

  public void setMineId(long mineId) {
    this.mineId = mineId;
  }


  public String getNamMine() {
    return namMine;
  }

  public void setNamMine(String namMine) {
    this.namMine = namMine;
  }


  public String getCodNtnMine() {
    return codNtnMine;
  }

  public void setCodNtnMine(String codNtnMine) {
    this.codNtnMine = codNtnMine;
  }


  public String getCodPostMine() {
    return codPostMine;
  }

  public void setCodPostMine(String codPostMine) {
    this.codPostMine = codPostMine;
  }


  public String getNumTelMine() {
    return numTelMine;
  }

  public void setNumTelMine(String numTelMine) {
    this.numTelMine = numTelMine;
  }


  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

}
