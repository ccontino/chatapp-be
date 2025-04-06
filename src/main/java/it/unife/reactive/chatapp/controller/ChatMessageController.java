package it.unife.reactive.chatapp.controller;

import it.unife.reactive.chatapp.model.ChatMessage;
import it.unife.reactive.chatapp.service.ChatMessageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ChatMessageController {

    private final ChatMessageService service;

    public ChatMessageController(ChatMessageService service) {
        this.service = service;
    }

    @GetMapping(value = "/api/messages", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ChatMessage> streamNewMessages() {
        return service.streamNewMessages();
    }

    @PostMapping(value = "/api/message", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ChatMessage> saveMessage(@RequestBody ChatMessage message) {
        return service.saveMessage(message);
    }

}
