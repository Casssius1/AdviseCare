package com.example.myapplication.models;

public class UserLoginResponseDto {
    private String  EmailId;
    private  String Gender;

    public UserLoginResponseDto(String emailId, String gender) {
        EmailId = emailId;
        Gender = gender;
    }

    public UserLoginResponseDto() {
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
