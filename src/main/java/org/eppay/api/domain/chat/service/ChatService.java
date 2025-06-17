package org.eppay.api.domain.chat.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eppay.api.domain.chat.model.ChatDto;
import org.eppay.api.domain.chat.model.ChatPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ObjectMapper objectMapper;
    private final ChatPublisher chatPublisher;

    public void chat(ChatDto request) throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(request));

        chatPublisher.sendChat(request);
    }
}