package com.webproject.icollect.utils.exception;

public class UserRepeatException extends GlobalExceptionBase {
    public UserRepeatException(Integer code, String message) {
        super(code, message);
    }
}
