package com.barak.searchservice.exceptions;

public class ErrorBean {

    private int errorNumber;
    private String errorName;
    private String errorMessage;

    public ErrorBean(int errorNumber, String errorName, String errorMessage) {
        this.errorNumber = errorNumber;
        this.errorName = errorName;
        this.errorMessage = errorMessage;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
