package org.eppay.api.domain.chat.model;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class ChatPublisher{

    private final SimpMessagingTemplate messagingTemplate;

    public ChatPublisher(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendChat(ChatDto request ){
        messagingTemplate.convertAndSend("/chat/des/1",request );
    }
}
