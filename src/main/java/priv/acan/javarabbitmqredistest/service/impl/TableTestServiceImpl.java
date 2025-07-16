package priv.acan.javarabbitmqredistest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import priv.acan.javarabbitmqredistest.entity.TableTest;
import priv.acan.javarabbitmqredistest.mapper.TableTestMapper;
import priv.acan.javarabbitmqredistest.service.ITableTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import priv.acan.javarabbitmqredistest.service.MqSender;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author acan
 * @since 2025-07-11
 */
@Service
@RequiredArgsConstructor
public class TableTestServiceImpl extends ServiceImpl<TableTestMapper, TableTest> implements ITableTestService {

    private final RedisTemplate<String, Object> rt;
    private final MqSender ms;

    private static final String RK = "testKey";

    @SuppressWarnings("unchecked")
    @Override
    public List<TableTest> selectTableTestList() {
        Object o = rt.opsForValue().get(RK);
        if (Objects.isNull(o)) {
            List<TableTest> list = lambdaQuery().list();
            ms.setKey(list);
            return list;
        } else {
            return (List<TableTest>) o;
        }
    }

    @Transactional
    @Override
    public void updateTableTest1() {
        ms.deleteKey(RK);
        lambdaUpdate().set(TableTest::getCol1, "aaa")
                .set(TableTest::getCol2, 111)
                .update();
    }

    @Transactional
    @Override
    public void updateTableTest2() {
        ms.deleteKey(RK);
        lambdaUpdate().set(TableTest::getCol1, "aaa")
                .set(TableTest::getCol2, 222)
                .update();
    }

}
