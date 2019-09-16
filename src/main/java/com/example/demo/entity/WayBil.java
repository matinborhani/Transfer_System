package com.example.demo.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Component
@Table(name = "WYBIL")
public class WayBil {
    enum StatusBar {
        IN_MINE,
        IN_ROAD,
        RECEIVED
    }

    enum KindCar {
        NEISAN
    }

    @Id
    @Column(name = "WYBIL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "DAT_STA_WYBIL")
    Date sendDate;
    @Column(name = "DAT_ENTR_WYBIL")
    Date receivedDate;
    @Column(name = "DAT_CRT_WYBIL")
    Date createDate;
    @Transient
    String sStartDate;
    @Transient
    String sFinishDate;
    @Transient
    String sCreateDate;
    @Column(name = "LKP_TYP_WYBIL")
    String typeBar;
    @Column(name = "LKP_STA_WYBIL")
    String status;
    @Column(name = "AMN_PYM_INSUR_WYBIL")
    Long costInsurance;
    @Column(name = "AMN_TRANS_WYBIL")
    Long costTransfer;
    @Column(name = "AMN_WEI_WYBIL")
    Long costWeightBridge;
    @Column(name = "AMN_WGH_WYBIL")
    Float weight;
    @Column(name = "COD_NTN_DRV_WYBIL")
    String driverNationalCode;
    @Column(name = "NAM_DRV_WYBIL")
    String driverName;
    @Column(name = "NUM_TEL_DRV_WYBIL")
    String driverPhone;
    @Column(name = "NUM_DRV_WYBIL")
    String driverLicsDriving;
    @Column(name = "NUM_CAR_WYBIL")
    String carTag;
    @Transient
    String firstPart_carTag;
    @Transient
    String letterPart_carTag;
    @Transient
    String secondPart_carTag;
    @Transient
    String lastPart_carTag;


    @Column(name = "LKP_TYPE_CAR_WYBIL")
    String carKind;
    @Column(name = "NAM_SNDR_WYBIL")
    String senderName;
    @Column(name = "COD_NTNL_SNDR_WYBIL")
    String senderNationalCode;
    @Column(name = "COD_PST_SNDR_WYBIL")
    String senderPostCode;
    @Column(name = "NUM_TEL_SNDR_WYBIL")
    String senderPhone;
    @Column(name = "NUM_NAT_IDENT_SNDR_WYBIL")
    String senderIdentifyCode;


    @Column(name = "NAM_RCV_WYBIL")
    String receiverName;
    @Column(name = "COD_NTNL_RCV_WYBIL")
    String receiverNationalCode;
    @Column(name = "COD_PST_RCV_WYBIL")
    String receiverPostCode;
    @Column(name = "NUM_TEL_RCV_WYBIL")
    String receiverPhone;
    @Column(name = "NUM_NAT_IDENT_RCVD_WYBIL")
    String receiverIdentifyCode;
    @Column(name = "DES")
    String des;

    // Constructor
    public WayBil(Long id, Date sendDate, Date receivedDate, String typeBar, Long costInsurance, Long costTransfer, Long costWeightBridge, float weight, String driverNationalCode, String driverName,
                  String driverPhone, String driverLicsDriving, String carTag, String carKind, String senderName, String senderNationalCode, String senderPostCode, String senderPhone, String receiverName,
                  String receiverNationalCode, String receiverPostCode, String receiverPhone) {
        this.id = id;
        this.sendDate = sendDate;
        this.receivedDate = receivedDate;
        this.typeBar = typeBar;
        this.costInsurance = costInsurance;
        this.costTransfer = costTransfer;
        this.costWeightBridge = costWeightBridge;
        this.weight = weight;
        this.driverNationalCode = driverNationalCode;
        this.driverName = driverName;
        this.driverPhone = driverPhone;
        this.driverLicsDriving = driverLicsDriving;
        this.carTag = carTag;
        this.carKind = carKind;
        this.senderName = senderName;
        this.senderNationalCode = senderNationalCode;
        this.senderPostCode = senderPostCode;
        this.senderPhone = senderPhone;
        this.receiverName = receiverName;
        this.receiverNationalCode = receiverNationalCode;
        this.receiverPostCode = receiverPostCode;
        this.receiverPhone = receiverPhone;
    }

    public WayBil(Long id, String sendDate, String receivedDate, String createDate, Long costInsurance, Long costTransfer, Long costWeightBridge, float weight, String driverNationalCode, String driverName,
                  String driverPhone, String driverLicsDriving, String carTag, String carKind, String senderName, String senderNationalCode, String senderPostCode, String senderPhone, String receiverName,
                  String receiverNationalCode, String receiverPostCode, String receiverPhone) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
        this.id = id;
        this.sendDate = dateFormat.parse(sendDate);
        this.receivedDate = dateFormat.parse(receivedDate);
        this.sCreateDate = createDate;
        this.costInsurance = costInsurance;
        this.costTransfer = costTransfer;
        this.costWeightBridge = costWeightBridge;
        this.weight = weight;
        this.driverNationalCode = driverNationalCode;
        this.driverName = driverName;
        this.driverPhone = driverPhone;
        this.driverLicsDriving = driverLicsDriving;
        this.carTag = carTag;
        this.carKind = carKind;
        this.senderName = senderName;
        this.senderNationalCode = senderNationalCode;
        this.senderPostCode = senderPostCode;
        this.senderPhone = senderPhone;
        this.receiverName = receiverName;
        this.receiverNationalCode = receiverNationalCode;
        this.receiverPostCode = receiverPostCode;
        this.receiverPhone = receiverPhone;
    }

    public WayBil(long id, Float weight, String senderName, String receiverName) {
        this.id = id;
        this.weight = weight;
        this.senderName = senderName;
        this.receiverName = receiverName;
    }

    public WayBil(Float weight, String senderName, String receiverName) {
        this.weight = weight;
        this.senderName = senderName;
        this.receiverName = receiverName;
    }

    public WayBil() {
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Long getCostInsurance() {
        return costInsurance;
    }

    public void setCostInsurance(Long costInsurance) {
        this.costInsurance = costInsurance;
    }

    public Long getCostTransfer() {
        return costTransfer;
    }

    public void setCostTransfer(Long costTransfer) {
        this.costTransfer = costTransfer;
    }

    public Long getCostWeightBridge() {
        return costWeightBridge;
    }

    public void setCostWeightBridge(Long costWeightBridge) {
        this.costWeightBridge = costWeightBridge;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getDriverNationalCode() {
        return driverNationalCode;
    }

    public void setDriverNationalCode(String driverNationalCode) {
        this.driverNationalCode = driverNationalCode;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverLicsDriving() {
        return driverLicsDriving;
    }

    public void setDriverLicsDriving(String driverLicsDriving) {
        this.driverLicsDriving = driverLicsDriving;
    }

    public String getCarTag() {
        return carTag;
    }

    public void setCarTag(String carTag) {
        this.carTag = carTag;
    }

    public String getCarKind() {
        return carKind;
    }

    public void setCarKind(String carKind) {
        this.carKind = carKind;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderNationalCode() {
        return senderNationalCode;
    }

    public void setSenderNationalCode(String senderNationalCode) {
        this.senderNationalCode = senderNationalCode;
    }

    public String getSenderPostCode() {
        return senderPostCode;
    }

    public void setSenderPostCode(String senderPostCode) {
        this.senderPostCode = senderPostCode;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverNationalCode() {
        return receiverNationalCode;
    }

    public void setReceiverNationalCode(String receiverNationalCode) {
        this.receiverNationalCode = receiverNationalCode;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getSenderIdentifyCode() {
        return senderIdentifyCode;
    }

    public void setSenderIdentifyCode(String senderIdentifyCode) {
        this.senderIdentifyCode = senderIdentifyCode;
    }

    public String getReceiverIdentifyCode() {
        return receiverIdentifyCode;
    }

    public void setReceiverIdentifyCode(String receiverIdentifyCode) {
        this.receiverIdentifyCode = receiverIdentifyCode;
    }

    public String getsStartDate() {
        return sStartDate;
    }

    public void setsStartDate(String sStartDate) {
        this.sStartDate = sStartDate;
    }

    public String getsFinishDate() {
        return sFinishDate;
    }

    public void setsFinishDate(String sFinishDate) {
        this.sFinishDate = sFinishDate;
    }

    public String getTypeBar() {
        return typeBar;
    }

    public void setTypeBar(String typeBar) {
        this.typeBar = typeBar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstPart_carTag() {
        return firstPart_carTag;
    }

    public void setFirstPart_carTag(String firstPart_carTag) {
        this.firstPart_carTag = firstPart_carTag;
    }

    public String getLetterPart_carTag() {
        return letterPart_carTag;
    }

    public void setLetterPart_carTag(String letterPart_carTag) {
        this.letterPart_carTag = letterPart_carTag;
    }

    public String getSecondPart_carTag() {
        return secondPart_carTag;
    }

    public void setSecondPart_carTag(String secondPart_carTag) {
        this.secondPart_carTag = secondPart_carTag;
    }

    public String getLastPart_carTag() {
        return lastPart_carTag;
    }

    public void setLastPart_carTag(String lastPart_carTag) {
        this.lastPart_carTag = lastPart_carTag;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getsCreateDate() {
        return sCreateDate;
    }

    public void setsCreateDate(String sCreateDate) {
        this.sCreateDate = sCreateDate;
    }


}

