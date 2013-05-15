package pl.com.fakturago.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-05-14T21:59:22.957+0200")
@StaticMetamodel(Vat.class)
public class Vat_ {
	public static volatile SingularAttribute<Vat, Integer> id;
	public static volatile SingularAttribute<Vat, Byte> vatrate;
	public static volatile ListAttribute<Vat, Service> services;
}
