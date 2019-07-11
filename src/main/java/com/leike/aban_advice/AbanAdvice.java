package com.leike.aban_advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-10 10:31
 */

@Aspect  //标记其为一个切面
@Component //标记这个类为Spring的一个组件,相当于在xml中注册了一个bean一样
public class AbanAdvice {

    @Before("execution(* com.leike.aban_service.AbanService.show(String))")
    public void before() {
        System.out.println("注解版的before,方法执行前");
    }

    @Order(1)
    @Before("execution(* com.leike.aban_service.AbanService.show(String))")
    public void before2() {
        System.out.println("");
    }

    @After("execution(* com.leike.aban_service.AbanService.show(String))")
    public void after(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println("注解版的after,方法执行结束");
    }

//    @AfterThrowing(value = "execution(* com.leike.aban_service.AbanService.throwmethon())",throwing = "throwMsg")
//    @AfterThrowing(pointcut="execution(* com.leike.aban_service.*(..))", throwing= "error")
    @AfterThrowing(throwing="ex"
            , pointcut="execution(* com.leike.aban_service.AbanService.throwmethon())")

    public void afterThrowing(JoinPoint joinPoint,Throwable ex){

        System.out.println("异常之后"+joinPoint.getSignature().getName());
        System.out.println("异常信息"+ex);

    }

}
