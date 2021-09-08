package com.mizan.service;


import com.mizan.config.HibernateConfig;
import com.mizan.model.Customer;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class CustomerService {
    private final HibernateConfig hibernateConfig;

    public CustomerService(HibernateConfig hibernateConfig) {
        this.hibernateConfig = hibernateConfig;
    }

    @Transactional
    public void save(Customer customer) {
        var session = hibernateConfig.getSession();
        Transaction tx = session.getTransaction();
        if (!tx.isActive())
            tx = session.beginTransaction();
        session.save(customer);
        session.flush();
        tx.commit();
    }
}
