package example.varnished.api.messaging;

import org.springframework.amqp.core.Message;

import example.varnished.infra.event.BlockingEventEmitter;
import example.varnished.infra.event.NonBlockingEventEmitter;
import example.varnished.infra.utils.Logging;

public abstract class AbstractMessageConsumer implements Logging {

    private final NonBlockingEventEmitter nonBlockingEventEmitter;
    private final BlockingEventEmitter blockingEventEmitter;

    protected AbstractMessageConsumer(NonBlockingEventEmitter nonBlockingEventEmitter,
            BlockingEventEmitter blockingEventEmitter) {

        this.nonBlockingEventEmitter = nonBlockingEventEmitter;
        this.blockingEventEmitter = blockingEventEmitter;
    }

    protected void consume(Message message) {
        blockingEventEmitter.emitEvent(MessageConsumedEvent.from(message));
    }
}
