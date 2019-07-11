package com.leike.zhujiekaifa;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-10 16:41
 */
@Component(value = "girl")
public class Girl {

    private String name;

    public Girl() {
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
