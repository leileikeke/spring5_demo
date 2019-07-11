package com.leike.dao;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-09 9:18
 */
public class ProviderDao {

    private String url;
    private String driver;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;

    public void updata(){
        System.out.println("dao.....数据库更新");
    }

}
