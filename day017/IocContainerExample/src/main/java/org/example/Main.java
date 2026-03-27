package org.example;

import org.example.container.IoCContainer;
import org.example.services.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        IoCContainer ioc = new IoCContainer();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int rnd = random.nextInt(3) + 1;
//            System.out.println(rnd);
            if (rnd == 1) ioc.register(MyService.class, MyServiceImpl1.class);
            else if (rnd == 2) ioc.register(MyService.class, MyServiceImpl2.class);
            else ioc.register(MyService.class, MyServiceImpl3.class);

            MyService myService = ioc.resolve(MyService.class);

            myService.execute();
        }
    }
}
