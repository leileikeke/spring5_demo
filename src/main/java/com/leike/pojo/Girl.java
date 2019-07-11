package com.leike.pojo;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-07 15:18
 */
public class Girl {

    private Integer id;

    private String name;

    private String sex;

    public Girl() {
        super();
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Girl(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void xiezhuang(){
        System.out.println("我要卸妆了......");
    }

    public void huazhuang(){
        System.out.println("早起化妆............");
    }
}
