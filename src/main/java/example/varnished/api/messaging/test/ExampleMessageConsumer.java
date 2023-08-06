package example.varnished.api.messaging.test;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import example.varnished.api.messaging.AbstractMessageConsumer;
import example.varnished.api.messaging.MessagingConfig;
import example.varnished.infra.event.BlockingEventEmitter;
import example.varnished.infra.event.NonBlockingEventEmitter;

@Component
public class ExampleMessageConsumer extends AbstractMessageConsumer {

    protected ExampleMessageConsumer(NonBlockingEventEmitter nonBlockingEventEmitter,
            BlockingEventEmitter blockingEventEmitter) {
        super(nonBlockingEventEmitter, blockingEventEmitter);
    }

    @RabbitListener(queues = "#{@" + MessagingConfig.EXAMPLE_QUEUE + "}")
    public void onTest(Message message) {
        consume(message);
    }

}
