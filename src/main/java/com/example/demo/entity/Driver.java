package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "DRIVER")
public class Driver {

  @Id
  @Column(name = "DRV_ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long drvId;
  @Column(name = "NAM_DRV")
  private String namDrv;
  @Column(name = "NUM_TEL_DRV")
  private String numTelDrv;
  @Column(name = "COD_NTN_DRV")
  private String codNtnDrv;
  @Column(name = "ADDR_HOME_DRV")
  private String addrHomeDrv;
  @Column(name = "NUM_LICS_DRV")
  private String numLicsDrv;



  public String getNamDrv() {
    return namDrv;
  }

  public void setNamDrv(String namDrv) {
    this.namDrv = namDrv;
  }


  public String getNumTelDrv() {
    return numTelDrv;
  }

  public void setNumTelDrv(String numTelDrv) {
    this.numTelDrv = numTelDrv;
  }


  public String getCodNtnDrv() {
    return codNtnDrv;
  }

  public void setCodNtnDrv(String codNtnDrv) {
    this.codNtnDrv = codNtnDrv;
  }


  public String getAddrHomeDrv() {
    return addrHomeDrv;
  }

  public void setAddrHomeDrv(String addrHomeDrv) {
    this.addrHomeDrv = addrHomeDrv;
  }


  public String getNumLicsDrv() {
    return numLicsDrv;
  }

  public void setNumLicsDrv(String numLicsDrv) {
    this.numLicsDrv = numLicsDrv;
  }


  public long getDrvId() {
    return drvId;
  }

  public void setDrvId(long drvId) {
    this.drvId = drvId;
  }

}
