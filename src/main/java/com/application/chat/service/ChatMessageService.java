package com.application.chat.service;


import com.application.chat.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageService {
    private List<ChatMessage> messageHistory = new ArrayList<>();

    public void addMessage(ChatMessage message) {
        messageHistory.add(message);
    }

    public List<ChatMessage> getMessageStory() {
        return new ArrayList<>(messageHistory);
    }
}
