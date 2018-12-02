package com.seudev.anyaddress.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-12-01T22:32:34.388-0300")
@StaticMetamodel(Address.class)
public class Address_ {
	public static volatile SingularAttribute<Address, Cep> cep;
	public static volatile SingularAttribute<Address, String> neighborhood;
	public static volatile SingularAttribute<Address, String> address;
	public static volatile SingularAttribute<Address, String> number;
	public static volatile SingularAttribute<Address, String> complement;
	public static volatile SingularAttribute<Address, LocalDateTime> lastUpdate;
}
