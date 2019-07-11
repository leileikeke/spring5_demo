package com.leike.aop;

import com.leike.aban_service.AbanService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-10 10:46
 */
public class Test_Aban_AOP {

    @Test
    public void t1(){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/aban_applicationContext.xml");

        AbanService abanService = context.getBean("abanService", AbanService.class);
        abanService.show("涅音梦");

    }
    @Test
    public void t2(){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/aban_applicationContext.xml");

        AbanService abanService = context.getBean("abanService", AbanService.class);
        abanService.throwmethon();

    }
}
