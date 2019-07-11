package com.leike.aop;

import com.leike.zhujiekaifa.Dog;
import com.leike.zhujiekaifa.Girl;
import com.leike.zhujiekaifa.SpringConfig;
import com.leike.zhujiekaifa.dao.BillDao;
import com.leike.zhujiekaifa.service.BillService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-10 16:44
 */
public class ZhujiekaifaTest {

    @Test
    public void t1(){

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Girl girl = context.getBean("girl1", Girl.class);
        girl.setName("李雷");
        System.out.println(girl);

        Dog dog = context.getBean("dog", Dog.class);
        System.out.println(dog.toString());

    }

    @Test
    public void t2(){

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        BillService billService = context.getBean("billService", BillService.class);
        BillDao billDao = context.getBean("billDao", BillDao.class);
        billService.setBillDao(billDao);
        billService.pay(4234.13);

    }

    @Test
    public void t3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BillService billService = context.getBean("billService", BillService.class);
        billService.pay(4234.13);
    }
}
