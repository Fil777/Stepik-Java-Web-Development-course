package ru.ksergey.springBoot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

//@Configuration
//@ComponentScan
@SpringBootApplication
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class ApplicationContextConfig {

    @Bean
    public MapperHelper mapperHelper01() {
        return new MapperHelper(1);
    }

    @Bean
    public MapperHelper mapperHelper02() {
        return new MapperHelper(2);
    }
}
