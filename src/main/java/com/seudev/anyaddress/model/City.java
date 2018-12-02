package com.seudev.anyaddress.model;

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
        @UniqueConstraint(name = "uq_city_name", columnNames = {"state", "name"})
})
public class City extends SimpleEntity<City> {
    
    private static final long serialVersionUID = -8669729721044544848L;
    
    private static final int NAME_LENGTH = 100;
    
    @NotBlank
    @Size(max = NAME_LENGTH)
    @Column(name = "name", nullable = false, length = NAME_LENGTH)
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "state", foreignKey = @ForeignKey(name = "city_state"))
    private State state;
    
    public City() {
        super(City.class);
    }
    
    public String getName() {
        return name;
    }
    
    public State getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
}
