package com.example.mini.dto;

public class MailDto {
    private String address;
    private String title;
    private String message;

    public String getAddress() {
        return address;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
