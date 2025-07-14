package priv.acan.javarabbitmqredistest.service;

import priv.acan.javarabbitmqredistest.entity.TableTest;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author acan
 * @since 2025-07-11
 */
public interface ITableTestService extends IService<TableTest> {

    List<TableTest> selectTableTestList();

    void updateTableTest1();

    void updateTableTest2();
}
