package com.seudev.anyaddress.service;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.validation.executable.ExecutableType.ALL;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.validation.executable.ValidateOnExecution;

import com.seudev.anyaddress.model.Country;
import com.seudev.anyaddress.model.Country_;
import com.seudev.anyaddress.query.filter.CountryFilter;

@LocalBean
@Stateless
@ValidateOnExecution(type = ALL)
public class CountryService extends AbstractService {

    @Transactional(SUPPORTS)
    public List<Country> findAll(CountryFilter filter) {
        CriteriaQuery<Country> query = cb.createQuery(Country.class);
        Root<Country> from = query.from(Country.class);

        List<Predicate> predicates = new ArrayList<>(2);
        if (filter.getAbbreviation() != null) {
            predicates.add(cb.like(from.get(Country_.abbreviation), filter.getAbbreviation()));
        }

        if (filter.getName() != null) {
            predicates.add(cb.like(from.get(Country_.name), filter.getName()));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query)
                .getResultList();
    }

    @Transactional(SUPPORTS)
    public Country findByID(UUID id) {
        return entityManager.find(Country.class, id);
    }

    public void merge(Country country) {
        entityManager.merge(country);
    }

    public void persist(Country country) {
        entityManager.persist(country);
    }

    public void remove(Country country) {
        entityManager.remove(country);
    }

}
