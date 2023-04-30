package com.example.myapplication.models;

public class PostRequestDto {
    private String title;
    private String body;
    private byte[] imageBytes;

    public PostRequestDto(String title, String body, byte[] imageBytes) {
        this.title = title;
        this.body = body;
        this.imageBytes = imageBytes;
    }

    public PostRequestDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
}
