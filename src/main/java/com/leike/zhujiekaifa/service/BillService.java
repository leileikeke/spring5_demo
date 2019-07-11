package com.leike.zhujiekaifa.service;

import com.leike.zhujiekaifa.dao.BillDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-10 17:11
 */

@Service("billService")
public class BillService {

    @Autowired    //自动注入
    private BillDao billDao;

    public void pay(double money){
        System.out.println("Bill Service pay...");
        billDao.pay(money);
    }
    public BillService(BillDao billDao) {
        this.billDao = billDao;
    }

    public BillService() {
        super();
    }

    public BillDao getBillDao() {
        return billDao;
    }

    public void setBillDao(BillDao billDao) {
        this.billDao = billDao;
    }


}
