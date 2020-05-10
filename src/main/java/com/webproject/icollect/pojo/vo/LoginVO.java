package com.webproject.icollect.pojo.vo;

public class LoginVO<T>{
    private String token;
    private T info;

    public LoginVO(String token, T info) {
        this.token = token;
        this.info = info;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
