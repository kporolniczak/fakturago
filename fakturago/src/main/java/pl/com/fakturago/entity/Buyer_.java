package pl.com.fakturago.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-05-21T16:50:08.022+0200")
@StaticMetamodel(Buyer.class)
public class Buyer_ {
	public static volatile SingularAttribute<Buyer, Integer> id;
	public static volatile SingularAttribute<Buyer, String> address;
	public static volatile SingularAttribute<Buyer, String> city;
	public static volatile SingularAttribute<Buyer, String> mail;
	public static volatile SingularAttribute<Buyer, String> name;
	public static volatile SingularAttribute<Buyer, String> nip;
	public static volatile SingularAttribute<Buyer, String> pesel;
	public static volatile SingularAttribute<Buyer, String> zip;
	public static volatile SingularAttribute<Buyer, Province> province;
	public static volatile ListAttribute<Buyer, Invoice> invoices;
}
