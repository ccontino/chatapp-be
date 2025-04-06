package it.unife.reactive.chatapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@RestController
@RequestMapping("/async")
public class SinksExample {

    private final Sinks.Many<String> sink = Sinks.many().multicast().onBackpressureBuffer();

    @GetMapping(value = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> subscribe() {
        return sink.asFlux(); // Espone il flusso
    }

    @PostMapping("/send")
    public void sendNotification(@RequestBody String message) {
        sink.tryEmitNext("Messaggio ricevuto: " + message); // Inietta un evento
    }

}
