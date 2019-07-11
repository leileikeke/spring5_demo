package com.leike.aop;

import com.leike.advice.BeforeAdice;
import com.leike.service.ProviderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-09 15:46
 */
public class TestAOP {

    @Test
    public void test1(){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        ProviderService providerService = context.getBean("providerService", ProviderService.class);

        providerService.add("周大福");

    }
}
