package com.webproject.icollect.utils.exception;

public class GlobalExceptionBase extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;
    private String message;

    public GlobalExceptionBase(Integer code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
