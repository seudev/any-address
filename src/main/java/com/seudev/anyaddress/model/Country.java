package com.seudev.anyaddress.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.seudev.overjax.data.model.SimpleEntity;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "uq_country_abbreviation", columnNames = "abbreviation"),
        @UniqueConstraint(name = "uq_country_name", columnNames = "name")
})
public class Country extends SimpleEntity<Country> {

    private static final long serialVersionUID = -1522477099693573177L;
    
    private static final int ABBREVIATION_LENGTH = 3;
    private static final int NAME_LENGTH = 50;
    
    @NotBlank
    @Size(max = ABBREVIATION_LENGTH)
    @Column(name = "abbreviation", nullable = false, length = ABBREVIATION_LENGTH)
    private String abbreviation;
    
    @NotBlank
    @Size(max = NAME_LENGTH)
    @Column(name = "name", nullable = false, length = NAME_LENGTH)
    private String name;

    public Country() {
        super(Country.class);
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setName(String name) {
        this.name = name;
    }

}
