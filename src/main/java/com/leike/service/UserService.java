package com.leike.service;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-09 10:29
 */

//标记它为一个组件
@Component("userService")
public class UserService {

    public void eat(){
        System.out.println("我吃了一斤西瓜");
    }
}
