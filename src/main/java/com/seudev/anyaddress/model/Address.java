package com.seudev.anyaddress.model;

import static com.seudev.anyaddress.model.Cep.ADDRESS_LENGTH;
import static com.seudev.anyaddress.model.Cep.NEIGHBORHOOD_LENGTH;
import static javax.persistence.FetchType.LAZY;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.seudev.overjax.data.model.SimpleEntity;

@Entity
@Table
public class Address extends SimpleEntity<Address> {

    private static final long serialVersionUID = 430803184159901247L;
    static final int NUMBER_LENGTH = 20;
    static final int COMPLEMENT_LENGTH = 250;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cep", nullable = false, foreignKey = @ForeignKey(name = "fk_cep"))
    private Cep cep;

    @NotEmpty
    @Size(max = NEIGHBORHOOD_LENGTH)
    @Column(name = "neighborhood", length = NEIGHBORHOOD_LENGTH)
    private String neighborhood;

    @NotEmpty
    @Size(max = ADDRESS_LENGTH)
    @Column(name = "address", length = ADDRESS_LENGTH)
    private String address;

    @NotEmpty
    @Size(max = NUMBER_LENGTH)
    @Column(name = "number", length = NUMBER_LENGTH)
    private String number;

    @NotEmpty
    @Size(max = COMPLEMENT_LENGTH)
    @Column(name = "complement", length = COMPLEMENT_LENGTH)
    private String complement;

    @NotNull
    @Column(name = "lastUpdate", nullable = false)
    private LocalDateTime lastUpdate;

    public Address() {
        super(Address.class);
    }

}
