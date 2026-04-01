package ru.ksergey.springBoot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myConfig")
@Scope("singleton")
//@Scope("prototype")
public class AppConfig {

    @Value("${appConfig.params}")
    private int params;
    @Value("${appConfig.token}")
    private String token;

    public AppConfig() {

    }

    public int getParams() {
        return params;
    }

    public void setParams(int params) {
        this.params = params;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @PostConstruct
    public void init() {
        System.out.println("  >>> init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("  >>> destroy");
    }
}
