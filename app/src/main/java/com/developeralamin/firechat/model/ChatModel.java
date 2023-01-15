package com.developeralamin.firechat.model;

public class ChatModel {

    private String sender, receiverId, message, chatId, datetime, years;

    public ChatModel() {
    }

    public ChatModel(String sender, String receiverId, String message, String chatId, String datetime, String years) {
        this.sender = sender;
        this.receiverId = receiverId;
        this.message = message;
        this.chatId = chatId;
        this.datetime = datetime;
        this.years = years;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
}
