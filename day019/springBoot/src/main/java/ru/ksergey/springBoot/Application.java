package ru.ksergey.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext =
                SpringApplication.run(ApplicationContextConfig.class, args);

        AppConfig appConfig1 = (AppConfig) appContext.getBean("myConfig");

        System.out.println("Token: " + appConfig1.getToken());
        System.out.println("Params: " + appConfig1.getParams());

        Mapper appMapper = (Mapper) appContext.getBean("myMapper");

        System.out.println(appMapper.getAppConfig().getToken());
        System.out.println(appMapper.getAppConfig().getParams());

        appMapper.convert();

        AppConfig appConfig2 = (AppConfig) appContext.getBean("myConfig");

        System.out.println(appConfig1 == appConfig2);

        appContext.close();
    }
}
