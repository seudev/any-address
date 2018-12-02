package com.seudev.anyaddress.model;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.seudev.overjax.data.model.SimpleEntity;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "uq_state_abbreviation", columnNames = {"country", "abbreviation"}),
        @UniqueConstraint(name = "uq_state_name", columnNames = {"country", "name"})
})
public class State extends SimpleEntity<State> {

    private static final long serialVersionUID = 6076755231220716567L;
    private static final int ABBREVIATION_LENGTH = 5;
    private static final int NAME_LENGTH = 50;

    @NotBlank
    @Size(max = ABBREVIATION_LENGTH)
    @Column(name = "abbreviation", nullable = false, length = ABBREVIATION_LENGTH)
    private String abbreviation;

    @NotBlank
    @Size(max = NAME_LENGTH)
    @Column(name = "name", nullable = false, length = NAME_LENGTH)
    private String name;

    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "country", nullable = false, foreignKey = @ForeignKey(name = "fk_country"))
    private Country country;

    public State() {
        super(State.class);
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
