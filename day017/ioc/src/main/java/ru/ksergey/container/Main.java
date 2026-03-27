package ru.ksergey.container;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        IoCContainer ioc = new IoCContainer();

        if (new Random().nextInt(2) == 0) {
            ioc.register(MyService.class, MyServiceImpl1.class);
        } else {
            ioc.register(MyService.class, MyServiceImpl2.class);
        }

        MyService myService = ioc.resolve(MyService.class);

        myService.execute();

    }
}
