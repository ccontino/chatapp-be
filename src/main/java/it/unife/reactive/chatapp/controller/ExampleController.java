package it.unife.reactive.chatapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
public class ExampleController {

    @GetMapping(value="/example1", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> getNumbersFiltered() {
        return Flux.range(1, 5)
                .map(n -> n * 2)
                .filter(n -> n % 4 == 0)
                .delayElements(Duration.ofSeconds(1));
    }

    @GetMapping(value="/example2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getNumbersDelay() {
        List<String> items = List.of("uno", "due", "tre", "quattro");
        return Flux.fromIterable(items)
                .delayElements(Duration.ofSeconds(1));
    }


}
