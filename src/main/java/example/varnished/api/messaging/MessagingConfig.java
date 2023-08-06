package example.varnished.api.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MessagingConfig {

    public static final String EXAMPLE_QUEUE = "exampleQueue";

    @Bean(EXAMPLE_QUEUE)
    Queue exampleQueue() {
        return QueueBuilder.nonDurable().autoDelete().exclusive().build();
    }
}
