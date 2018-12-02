package com.seudev.anyaddress.service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

public abstract class AbstractService {
    
    @PersistenceContext(unitName = "any-address")
    protected EntityManager entityManager;

    protected CriteriaBuilder cb;
    
    @PostConstruct
    protected void postConstruct() {
        cb = entityManager.getCriteriaBuilder();
    }

}
