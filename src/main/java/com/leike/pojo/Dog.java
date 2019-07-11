package com.leike.pojo;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-07 19:08
 */
public class Dog {
    private String name;
    public Dog() {
        super();
//        System.out.println("Dog加载完成");
    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
