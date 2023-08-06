package example.varnished.infra.adapter.example;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import example.varnished.api.messaging.MessageConsumedEvent;
import example.varnished.app.example.ExampleService;
import example.varnished.infra.utils.Logging;

@Component
public class ExampleServiceAdapter implements Logging {

    private final ExampleService service;

    public ExampleServiceAdapter(ExampleService service) {
        this.service = service;
    }

    @EventListener
    public void on(MessageConsumedEvent event) {
        service.handle(event);
    }
}
