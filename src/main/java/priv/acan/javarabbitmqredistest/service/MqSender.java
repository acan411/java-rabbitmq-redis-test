package priv.acan.javarabbitmqredistest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import priv.acan.javarabbitmqredistest.entity.TableTest;

import java.util.List;

/**
 * @author acan
 * @since 2025/07/11 16:04
 */
@Service
@RequiredArgsConstructor
public class MqSender {

    private final RabbitTemplate mt;

    public void setKey(List<TableTest> message) {
        mt.convertAndSend("setKey", message);
    }

    public void deleteKey(String key) {
        mt.convertAndSend("deleteKey", key);
    }
}
