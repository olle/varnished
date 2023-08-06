package example.varnished.api.messaging;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.Socket;
import java.util.stream.Stream;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueInformation;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import example.varnished.app.VarninshedApp;

@ExtendWith(RabbitMqAvailable.class)
@SpringBootTest(classes = VarninshedApp.class)
@TestInstance(Lifecycle.PER_CLASS)
class MessagingConsumersIT {

    @Autowired
    RabbitAdmin rabbitAdmin;
    @Autowired
    ApplicationContext ctx;

    Stream<String> allDeclaredQueueNames() {
        return ctx.getBeansOfType(Queue.class).values().stream().map(Queue::getActualName);
    }

    @ParameterizedTest
    @MethodSource("allDeclaredQueueNames")
    void all_queue_beans_are_declared_on_broker(String queueName) throws Exception {

        assertThat(rabbitAdmin).isNotNull();
        assertThat(rabbitAdmin.getQueueInfo(queueName)).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("allDeclaredQueueNames")
    void all_declared_non_dlq_queues_have_a_consumer(String queueName) throws Exception {

        QueueInformation info = rabbitAdmin.getQueueInfo(queueName);

        if (queueName.endsWith(".dlq")) {
            assertThat(info.getConsumerCount()).as("Invalid consumer count. %s").isZero();
        } else {
            assertThat(info.getConsumerCount()).as("Invalid consumer count. %s", info).isPositive();
        }
    }
}

class RabbitMqAvailable implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {

        try (Socket s = new Socket("localhost", 5672)) {
            return ConditionEvaluationResult.enabled("RabbitMQ on localhost:5672");
        } catch (Exception ex) {
            return ConditionEvaluationResult.disabled("No RabbitMQ on localhost:5672");
        }
    }
}