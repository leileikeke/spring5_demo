package com.leike.pojo;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-07 20:57
 */
public class Dog2 {

    private Dog dog;

    @Override
    public String toString() {
        return "Dog2{" +
                "dog=" + dog +
                '}';
    }

    public Dog2() {
    }

    public Dog2(Dog dog) {
        this.dog = dog;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
