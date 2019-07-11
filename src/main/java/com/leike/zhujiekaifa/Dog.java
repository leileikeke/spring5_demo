package com.leike.zhujiekaifa;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-10 17:00
 */
public class Dog {

    private String name;

    public Dog() {
        super();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
