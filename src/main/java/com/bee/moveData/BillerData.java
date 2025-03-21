package com.bee.moveData;

public class BillerData {
    private String billType;
    private String billName;
    private String provinceId;
    private String billNo;
    private String user;

    public BillerData() {
    }

    public BillerData(String billType, String billName, String provinceId, String billNo, String user) {
        this.billType = billType;
        this.billName = billName;
        this.provinceId = provinceId;
        this.billNo = billNo;
        this.user = user;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BillerData{" +
                "billType='" + billType + '\'' +
                ", billName='" + billName + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", billNo='" + billNo + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
