package com.example.myapplication.models;

public class PatientSignUpReqDto {

    private String emailId;

    private String password;

    private String confirmPassword;

    public PatientSignUpReqDto() {
    }

    public PatientSignUpReqDto(String emailId, String password, String confirmPassword) {
        this.emailId = emailId;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}