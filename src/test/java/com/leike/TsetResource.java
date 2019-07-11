package com.leike;

import com.leike.dao.ProviderDao;
import com.leike.pojo.Dog;
import com.leike.pojo.Pig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-09 9:22
 */
public class TsetResource {

    @Test
    public void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"resources.xml"});

        ProviderDao providerDao = context.getBean("providerDao",ProviderDao.class);

        System.out.println(providerDao.getUrl());

    }

    @Test
    public void test2(){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext.xml"});
        Pig pig = context.getBean("pig", Pig.class);
        Dog dog = context.getBean("dog", Dog.class);

        System.out.println(pig.toString()+"\n"+dog.toString());


    }
}
