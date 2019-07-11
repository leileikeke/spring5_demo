package com.leike.pojo;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-08 9:18
 */
public class Pig {

    private String name;

    public Pig() {
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                '}';
    }

    public Pig(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
