package com.seudev.anyaddress.model;

import static javax.persistence.FetchType.LAZY;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.seudev.overjax.data.model.SimpleEntity;

@Entity
@Table
public class Cep extends SimpleEntity<Cep> {

    private static final long serialVersionUID = -5192581428230555650L;
    static final int CEP_LENGTH = 8;
    static final int NEIGHBORHOOD_LENGTH = 100;
    static final int ADDRESS_LENGTH = 100;

    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "city", nullable = false, foreignKey = @ForeignKey(name = "fk_city"))
    private City city;

    @NotBlank
    @Pattern(regexp = "[0-9]{" + CEP_LENGTH + "}")
    @Column(name = "cep", nullable = false, length = CEP_LENGTH)
    private String cep;

    @NotEmpty
    @Size(max = NEIGHBORHOOD_LENGTH)
    @Column(name = "neighborhood", length = NEIGHBORHOOD_LENGTH)
    private String neighborhood;

    @NotEmpty
    @Size(max = ADDRESS_LENGTH)
    @Column(name = "address", length = ADDRESS_LENGTH)
    private String address;

    @NotNull
    @Column(name = "lastUpdate", nullable = false)
    private LocalDateTime lastUpdate;

    public Cep() {
        super(Cep.class);
    }

    public String getAddress() {
        return address;
    }

    public String getCep() {
        return cep;
    }

    public City getCity() {
        return city;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

}
