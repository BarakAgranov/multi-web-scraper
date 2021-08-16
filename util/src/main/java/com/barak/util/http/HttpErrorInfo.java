package com.barak.util.http;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class HttpErrorInfo {

    private final String errorName;
    private final int errorNumber;
    private final String message;
    private final String path;
    private final ZonedDateTime timestamp;


    public HttpErrorInfo() {
        this.errorName = null;
        timestamp = null;
        this.errorNumber = 0;
        this.path = null;
        this.message = null;
    }

    public HttpErrorInfo(String errorName, int errorNumber, String path, String message) {
        this.errorName = errorName;
        timestamp = ZonedDateTime.now();
        this.errorNumber = errorNumber;
        this.path = path;
        this.message = message;
    }

    public String getErrorName() {
        return errorName;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
