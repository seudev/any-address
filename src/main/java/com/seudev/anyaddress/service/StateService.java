package com.seudev.anyaddress.service;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.validation.executable.ExecutableType.ALL;

import java.util.List;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.validation.executable.ValidateOnExecution;

import com.seudev.anyaddress.model.State;

@LocalBean
@Stateless
@Transactional
@ValidateOnExecution(type = ALL)
public class StateService extends AbstractService {

    @Transactional(SUPPORTS)
    public List<State> findAll(UUID countryId) {
        return entityManager.createQuery("SELECT s FROM State s WHERE s.country.id = :countryId", State.class)
                .setParameter("countryId", countryId)
                .getResultList();
    }
    
    @Transactional(SUPPORTS)
    public State findByID(UUID id) {
        return entityManager.find(State.class, id);
    }
    
    public void merge(State state) {
        entityManager.merge(state);
    }
    
    public void persist(State state) {
        entityManager.persist(state);
    }
    
    public void remove(State state) {
        entityManager.remove(state);
    }

}
