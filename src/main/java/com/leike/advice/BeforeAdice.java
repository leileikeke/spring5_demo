package com.leike.advice;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-09 14:53
 */
public class BeforeAdice {

    public void methodBefore(){
        System.out.println("我是前AOP，我在方法之前执行...");
    }

    public void before(JoinPoint joinPoint){

        String name = joinPoint.getSignature().getName();


        System.out.println("方法名methon:   "+name);
    }
}
