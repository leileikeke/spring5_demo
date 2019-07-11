package com.leike.aban_service;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-10 10:31
 */

@Component
public class AbanService {

    public String show(String name){

        System.out.println("service层的public String show(   "+name+"  )函数");

        return "返回值"+name;
    }

    public void throwmethon(){
        System.out.println("我准备异常");
        throw new RuntimeException("狼来了");
    }
}
