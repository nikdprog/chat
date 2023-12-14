package com.application.chat.controller;

import com.application.chat.model.ChatMessage;
import com.application.chat.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class WebSocketController {

    @Autowired
    private ChatMessageService messageService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChatRoom")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        messageService.addMessage(chatMessage);
        System.out.println(chatMessage.getContent());
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/publicChatRoom")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        messageService.addMessage(chatMessage);
        System.out.println(chatMessage.getSender());
        System.out.println(chatMessage.getMessageType());
        return chatMessage;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public String handleChatMessage(String message, Model model) {
        // Обработка входящего сообщения от WebSocket
        // Сохранение сообщения в истории (может потребоваться инъекция сервиса)
        // model.addAttribute("message", message); // Опционально, если вы хотите что-то делать с сообщением на сервере
        return message;
    }
}