package priv.acan.javarabbitmqredistest.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author acan
 * @since 2025/07/11 15:58
 */
@Configuration
@EnableRabbit
public class RabbitConfig {

    @Bean
    public Queue queue1() {
        return new Queue("setKey", true);
    }

    @Bean
    public Queue queue2() {
        return new Queue("deleteKey", true);
    }

}
