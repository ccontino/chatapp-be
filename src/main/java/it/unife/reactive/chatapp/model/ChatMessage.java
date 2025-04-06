package it.unife.reactive.chatapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("chat_message")
@Data
public class ChatMessage {

    @Id
    private Long id;
    private String nickname;
    private String message;
    private LocalDateTime createdAt;

}
