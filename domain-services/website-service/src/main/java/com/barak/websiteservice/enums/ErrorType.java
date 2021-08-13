package com.barak.websiteservice.enums;

public enum ErrorType {

    GENERAL_ERROR(800, "GENERAL_ERROR","General error", true),
    ALREADY_EXISTS(801, "ALREADY_EXISTS", "This value must be unique and already exists", false),
    MUST_INSERT_A_VALUE(802, "MUST_INSERT_A_VALUE", "Must insert a value", false),
    CANNOT_BE_FOUND(803, "CANNOT_BE_FOUND", "Could not find what you are looking for", false),
    INVALID_INPUT(803, "INVALID_INPUT", "the input you entered is invalid", false),
    SQL_ERROR(804, "SQL_ERROR", "error in database connection / sql query / something else", true),
    MUST_HAVE_A_VALUE(805, "MUST_HAVE_A_VALUE", "This field must have a value", false),
    VALUE_LOWER_THAN_ZERO(806, "VALUE_LOWER_THAN_ZERO", "Value can't be lower than zero", false);


    private int errorNumber;
    private String errorName;
    private String errorMessage;
    private boolean isShowingStackTrace;

    ErrorType(int errorNumber, String errorName, String errorMessage, boolean isShowingStackTrace) {
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
        this.isShowingStackTrace = isShowingStackTrace;
        this.errorName = errorName;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isShowingStackTrace() {
        return isShowingStackTrace;
    }

    public String getErrorName() {
        return errorName;
    }
}
