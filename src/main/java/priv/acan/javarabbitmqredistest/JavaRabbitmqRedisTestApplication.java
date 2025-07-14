package priv.acan.javarabbitmqredistest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@ConfigurationPropertiesScan
@MapperScan("priv.acan.javarabbitmqredistest.mapper")
public class JavaRabbitmqRedisTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaRabbitmqRedisTestApplication.class, args);
    }

}
