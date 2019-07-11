package com.leike.zhujiekaifa;

import com.leike.zhujiekaifa.dao.BillDao;
import com.leike.zhujiekaifa.service.BillService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-10 16:41
 */

@Configuration
@ComponentScan(value = "com.leike.zhujiekaifa")
public class SpringConfig {

    @Bean("dog")
    public Dog createDog() {

        Dog dog = new Dog();
        dog.setName("大黄狗");

        return dog;
    }

//    @Bean("billService")
//    public BillService createBillService(){
//
//        BillService billService = new BillService();
//        return billService;
//
//    }
//
//    @Bean("billDao")
//    public BillDao createBillDao(){
//
//        BillDao billDao = new BillDao();
//        return billDao;
//    }

}
