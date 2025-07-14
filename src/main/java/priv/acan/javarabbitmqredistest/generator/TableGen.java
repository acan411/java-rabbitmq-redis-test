package priv.acan.javarabbitmqredistest.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author acan
 * @since 2025/07/10 16:50
 */
public class TableGen {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/myTest";
        String username = "root";
        String password = "123456";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("acan") // 设置作者
                            .disableOpenDir() // 禁用打开输出目录
                            .outputDir("C:\\Project\\Code\\1.Study\\java-rabbitmq-redis-test\\src\\main\\java"); // 输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("priv.acan.javarabbitmqredistest") // 设置父包名
//                            .moduleName("tableTest") // 设置模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C:\\Project\\Code\\1.Study\\java-rabbitmq-redis-test\\src\\main\\resources\\mapper")); // Mapper XML 生成路径
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .strategyConfig(builder -> {
                    builder.addInclude("table_test"); // 需要生成的表名
                })
                .execute();
    }
}
