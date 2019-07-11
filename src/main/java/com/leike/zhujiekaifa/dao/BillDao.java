package com.leike.zhujiekaifa.dao;

import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-10 17:11
 */

@Repository
public class BillDao {

    public void pay(double money) {

        System.out.println("bill Dao pay...");
        System.out.println("支付成功: "+money+" 元");

    }
}
