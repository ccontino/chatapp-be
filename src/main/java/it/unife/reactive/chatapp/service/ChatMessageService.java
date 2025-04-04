package it.unife.reactive.chatapp.service;

import it.unife.reactive.chatapp.model.ChatMessage;
import it.unife.reactive.chatapp.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class ChatMessageService
{
    private final ChatMessageRepository repository;
    private final Sinks.Many<ChatMessage> sink = Sinks.many().multicast().onBackpressureBuffer();

    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.repository = chatMessageRepository;
    }

    public Flux<ChatMessage> streamNewMessages() {
        return sink.asFlux();
    }

    public Mono<ChatMessage> saveMessage(ChatMessage message) {
        return repository.save(message)
                .doOnSuccess(sink::tryEmitNext);
    }

}
