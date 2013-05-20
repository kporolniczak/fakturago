package pl.com.fakturago.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-05-20T17:59:50.915+0200")
@StaticMetamodel(Seller.class)
public class Seller_ {
	public static volatile SingularAttribute<Seller, Integer> id;
	public static volatile SingularAttribute<Seller, String> address;
	public static volatile SingularAttribute<Seller, String> city;
	public static volatile SingularAttribute<Seller, String> name;
	public static volatile SingularAttribute<Seller, String> nip;
	public static volatile SingularAttribute<Seller, String> province;
	public static volatile SingularAttribute<Seller, String> zip;
	public static volatile ListAttribute<Seller, Invoice> invoices;
}
