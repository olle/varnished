package example.varnished.infra.event;

import java.time.Instant;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;

@Configuration
public class EventConfig {

    @Bean
    public EventEmitter blockingEventEmitter(ApplicationEventPublisher publisher) {
        return publisher::publishEvent;
    }

    @Bean
    public NonBlockingEventEmitter nonBlockingEventEmitter(ApplicationEventPublisher publisher,
            TaskScheduler scheduler) {
        return (event) -> scheduler.schedule(() -> publisher.publishEvent(event), Instant.now());
    }
}
