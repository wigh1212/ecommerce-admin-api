package org.eppay.api.controller;

import lombok.RequiredArgsConstructor;
import org.eppay.api.domain.chat.model.ChatDto;
import org.eppay.api.domain.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebSocketController {

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/init")
    public void chat(ChatDto request){

        messagingTemplate.convertAndSend("/chat/des/1",request );
    }
}
