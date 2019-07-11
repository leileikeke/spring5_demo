package com.leike;

import com.leike.pojo.Dog;
import com.leike.pojo.Girl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-07 15:21
 */
public class TestGirl {

    @Test
    public void test1() {

        // 1 获取上下文对象 , Spring里面声明对象都需要通过上下文对象获取
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2 通过这个对象获取我们的girl
        Girl g = (Girl) context.getBean("girl");
        System.out.println(g.toString());
    }

    @Test
    public void tset2(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

        Girl youGirl = (Girl) context.getBean("youGirl");

        System.out.println(youGirl);

        ((ClassPathXmlApplicationContext) context).close();
//        ((ClassPathXmlApplicationContext) context).refresh();
    }
    @Test
    public void tset3(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        //默认是单例方式
        Girl g = (Girl) context.getBean("mygirl");
        Girl g2 = (Girl) context.getBean("g2");
        Girl g3 = (Girl) context.getBean("g3");
        System.out.println(g);
        System.out.println(g2);
        System.out.println(g3);
    }
    @Test
    public void tset4(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        context.getBean("boy");
    }
    @Test
    public void tset5(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        Dog dog = (Dog) context.getBean("旺财");
        System.out.println(dog);
    }


    @Test
    public void test5(){

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

        System.out.println(context.getBean("test").toString());

    }

}
