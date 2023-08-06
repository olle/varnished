package example.varnished.api.messaging;

import org.springframework.amqp.core.Message;

import example.varnished.architecture.IngressEvent;

public record MessageConsumedEvent(Message message) implements IngressEvent {
    public static MessageConsumedEvent from(Message message) {
        return new MessageConsumedEvent(message);
    }
}
