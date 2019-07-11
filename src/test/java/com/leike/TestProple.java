package com.leike;

import com.leike.pojo.Prople;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-08 8:45
 */
public class TestProple {

    @Test
    public void tset1() {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext2.xml"});

        Prople prople = (Prople) context.getBean("prople");

        System.out.println(prople.getPigs());
        System.out.println(prople.getDogs());
        System.out.println(prople.getUserMap());
    }
}