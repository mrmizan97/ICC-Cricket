package com.mizan.service;

import com.mizan.config.HibernateConfig;
import com.mizan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private HibernateConfig hibernateConfig;
    @Autowired
    private CountryService countryService;


    public List<User> getAllUser(){
        CriteriaBuilder criteriaBuilder = hibernateConfig.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        return hibernateConfig.getSession().getEntityManagerFactory()
                .createEntityManager().createQuery(criteriaQuery)
                .getResultList();
    }
}
