package com.example.myapplication.models;

public class UserLoginRequestDto {
    private String emailId;

    private String password;

    public UserLoginRequestDto(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public UserLoginRequestDto() {
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
