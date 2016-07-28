package org.misoton.exampleapp;

import android.graphics.Bitmap;

public class Message {
    private String userId;
    private String userName;
    private String messageBody;
    private Bitmap icon;
    private String date;

    public Message(String userId, String userName, String messageBody, Bitmap icon, String date) {
        this.userId = userId;
        this.userName = userName;
        this.messageBody = messageBody;
        this.icon = icon;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public String getDate() {
        return date;
    }
}
