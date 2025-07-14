package priv.acan.javarabbitmqredistest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import priv.acan.javarabbitmqredistest.entity.TableTest;

import java.time.Duration;
import java.util.List;

/**
 * @author acan
 * @since 2025/07/11 16:05
 */
@Service
@RequiredArgsConstructor
public class MqListener {

    private final RedisTemplate<String, Object> rt;
    private static final String RK = "testKey";

    @RabbitListener(queues = "setKey")
    public void setKey(List<TableTest> list) {
        rt.opsForValue().set(RK, list, Duration.ofSeconds(10));
    }

    @RabbitListener(queues = "deleteKey")
    public void deleteKey(String key) {
        rt.delete(key);
    }
}
