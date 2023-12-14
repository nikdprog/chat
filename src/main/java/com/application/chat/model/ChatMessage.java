package com.application.chat.model;

import java.util.ArrayList;
import java.util.List;

public class ChatMessage {
    private MessageType messageType;
    private String content;
    private String sender;
    public enum MessageType {
        CHAT, JOIN, LEAVE;
    }

    private ArrayList<ChatMessage> messageHistory = new ArrayList<>();
    public MessageType getMessageType() {
        return messageType;
    }
    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessageHistory(ArrayList<ChatMessage> history) {
        this.messageHistory = history;
    }

    public ArrayList<ChatMessage> getMessageHistory() {
        return new ArrayList<>(this.messageHistory);
    }
}
