package example.varnished.api.messaging;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import example.varnished.infra.utils.Logging;

public abstract class AbstractMessagePublisher implements Logging {

    private final RabbitTemplate rabbitTemplate;

    protected AbstractMessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    protected void publish(Message message) {
        logger().warn("NOT YET PUBLISHING {}", message);
    }

}
