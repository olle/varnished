package example.varnished.app.example;

import example.varnished.api.messaging.MessageConsumedEvent;
import example.varnished.architecture.ApplicationService;
import example.varnished.infra.utils.Logging;

public class ExampleService implements Logging, ApplicationService {

    public void handle(MessageConsumedEvent event) {
        logger().warn("NOT YET HANDLING {}", event);
    }
}
