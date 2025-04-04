package it.unife.reactive.chatapp.repository;

import it.unife.reactive.chatapp.model.ChatMessage;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ChatMessageRepository extends ReactiveCrudRepository<ChatMessage, Long> {
    Flux<ChatMessage> findByIdGreaterThan(Long id);
}
