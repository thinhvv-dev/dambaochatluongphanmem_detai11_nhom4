/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author NguyenDinhTien
 */
public class SavingDTO {
    private long id;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String idCard;
    private String issueBy;
    private BigDecimal desposite;
    private String currency;
    private int period;
    private String paymentMethot;
    private float interestRate;
    private String fromDate;
    private String status;
    private String numbersaving;
    private String updateDate;
    private String insertBy;
    private String toDate;

    public SavingDTO() {
    }

    public String getFullName() {
        return fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIssueBy() {
        return issueBy;
    }

    public void setIssueBy(String issueBy) {
        this.issueBy = issueBy;
    }

    public BigDecimal getDesposite() {
        return desposite;
    }

    public void setDesposite(BigDecimal desposite) {
        this.desposite = desposite;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getPaymentMethot() {
        return paymentMethot;
    }

    public void setPaymentMethot(String paymentMethot) {
        this.paymentMethot = paymentMethot;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumberSaving() {
        return numbersaving;
    }

    public void setNumberSaving(String numbersaving) {
        this.numbersaving = numbersaving;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getInsertBy() {
        return insertBy;
    }

    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "SavingDTO{" + "id=" + id + ", fullName=" + fullName + ", address=" + address + ", phone=" + phone + ", email=" + email + ", idCard=" + idCard + ", issueBy=" + issueBy + ", desposite=" + desposite + ", currency=" + currency + ", period=" + period + ", paymentMethot=" + paymentMethot + ", interestRate=" + interestRate + ", fromDate=" + fromDate + ", status=" + status + ", numbersaving=" + numbersaving + ", updateDate=" + updateDate + ", insertBy=" + insertBy + ", toDate=" + toDate + '}';
    }

    
    
}
