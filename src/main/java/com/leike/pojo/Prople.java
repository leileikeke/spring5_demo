package com.leike.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-08 8:37
 */
public class Prople {

    private String Name;

    private Integer age;

    private String[] friends;

    private List<Integer> Nums;

    private List<Dog> dogs;

    private Set<Pig> pigs;

    private Map<String,User> userMap;

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Prople() {
        super();
    }

    @Override
    public String toString() {
        return "Prople{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", friends=" + Arrays.toString(friends) +
                ", Nums=" + Nums +
                ", dogs=" + dogs +
                ", pigs=" + pigs +
                ", userMap=" + userMap +
                '}';
    }

    public Prople(String name, Integer age, String[] friends, List<Integer> nums, List<Dog> dogs, Set<Pig> pigs, Map<String, User> userMap) {
        Name = name;
        this.age = age;
        this.friends = friends;
        Nums = nums;
        this.dogs = dogs;
        this.pigs = pigs;
        this.userMap = userMap;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    public List<Integer> getNums() {
        return Nums;
    }

    public void setNums(List<Integer> nums) {
        Nums = nums;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public Set<Pig> getPigs() {
        return pigs;
    }

    public void setPigs(Set<Pig> pigs) {
        this.pigs = pigs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
