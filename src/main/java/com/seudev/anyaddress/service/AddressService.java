package com.seudev.anyaddress.service;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.validation.executable.ExecutableType.ALL;

import java.util.List;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.validation.executable.ValidateOnExecution;

import com.seudev.anyaddress.model.Address;

@LocalBean
@Stateless
@Transactional
@ValidateOnExecution(type = ALL)
public class AddressService extends AbstractService {

    @Transactional(SUPPORTS)
    public List<Address> findAll() {
        return entityManager.createQuery("SELECT a FROM Address a", Address.class)
                .getResultList();
    }
    
    @Transactional(SUPPORTS)
    public Address findByID(UUID id) {
        return entityManager.find(Address.class, id);
    }
    
    public void persist(Address address) {
        entityManager.persist(address);
    }
    
    public void remove(Address address) {
        entityManager.remove(address);
    }
    
    public void update(Address address) {
        entityManager.merge(address);
    }
    
}
