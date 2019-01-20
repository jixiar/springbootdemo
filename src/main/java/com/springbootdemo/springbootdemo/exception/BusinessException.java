package com.springbootdemo.springbootdemo.exception;

public class BusinessException extends RuntimeException {
    private String errorCode;

    public static final String PARAM_MISS = "504";
    public static final String PARAM_ERROR = "505";
    public static final String SELF_LOGIC_WRONG = "508";
    public static final String BUSINESS_ERROR = "500";

    public BusinessException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
