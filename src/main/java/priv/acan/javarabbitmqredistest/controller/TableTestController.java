package priv.acan.javarabbitmqredistest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import priv.acan.javarabbitmqredistest.entity.TableTest;
import priv.acan.javarabbitmqredistest.service.ITableTestService;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author acan
 * @since 2025-07-11
 */
@RestController
@RequestMapping("/table-test")
public class TableTestController {

    private final ITableTestService tableTestService;

    @Autowired
    public TableTestController(ITableTestService tableTestService) {
        this.tableTestService = tableTestService;
    }

    @GetMapping("/list")
    public String list() {
        return tableTestService.selectTableTestList().toString();
    }

    @GetMapping("/set2")
    public String set2() {
        tableTestService.updateTableTest2();
        return "222";
    }

    @GetMapping("/set1")
    public String set1() {
        tableTestService.updateTableTest1();
        return "111";
    }
}
