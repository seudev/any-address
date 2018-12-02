package com.seudev.anyaddress.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-12-01T22:32:34.396-0300")
@StaticMetamodel(Cep.class)
public class Cep_ {
	public static volatile SingularAttribute<Cep, City> city;
	public static volatile SingularAttribute<Cep, String> cep;
	public static volatile SingularAttribute<Cep, String> neighborhood;
	public static volatile SingularAttribute<Cep, String> address;
	public static volatile SingularAttribute<Cep, LocalDateTime> lastUpdate;
}
