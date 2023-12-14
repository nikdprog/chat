package com.application.chat.controller;

import com.application.chat.model.ChatMessage;
import com.application.chat.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatMessageService messageService;

    @GetMapping("/history")
    public List<ChatMessage> getMessageHistory() {
        return messageService.getMessageStory();
    }
}
