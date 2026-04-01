package ru.ksergey.springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myMapper")
public class Mapper {

    @Autowired
    private AppConfig appConfig;

//    @Autowired
//    public Mapper(AppConfig appConfig) {
//        this.appConfig = appConfig;
//    }

    @Autowired
    @Qualifier("mapperHelper01")
    private MapperHelper mapperHelper1;
    @Autowired
    @Qualifier("mapperHelper02")
    private MapperHelper mapperHelper2;

    public Mapper() {
        this.appConfig = new AppConfig();
    }

    public AppConfig getAppConfig() {
        return appConfig;
    }

    //    @Autowired
    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void convert() {
        System.out.println("Что-то делает: " + appConfig.getParams());
    }
}
