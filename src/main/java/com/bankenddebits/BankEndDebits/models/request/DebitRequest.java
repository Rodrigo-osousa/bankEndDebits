package com.bankenddebits.BankEndDebits.models.request;

import com.bankenddebits.BankEndDebits.models.entity.Beneficiary;

import java.util.Date;

public class DebitRequest {
    private String name;
    private String documentNumber;
    private String accountNumber;
    private Date debitDate;
    private Double debitValue;
    private Beneficiary beneficiary;

    public DebitRequest (){

    }

    public DebitRequest(String name, String documentNumber, String accountNumber, Date debitDate, Double debitValue, Beneficiary beneficiary) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.accountNumber = accountNumber;
        this.debitDate = debitDate;
        this.debitValue = debitValue;
        this.beneficiary = beneficiary;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDebitDate() {
        return debitDate;
    }

    public void setDebitDate(Date debitDate) {
        this.debitDate = debitDate;
    }

    public Double getDebitValue() {
        return debitValue;
    }

    public void setDebitValue(Double debitValue) {
        this.debitValue = debitValue;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    @Override
    public String toString() {
        return "DebitRequest{" +
                ", name='" + name + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", debitDate=" + debitDate +
                ", debitValue=" + debitValue +
                ", beneficiary=" + beneficiary +
                '}';
    }
}
