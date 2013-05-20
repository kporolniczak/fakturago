package pl.com.fakturago.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-05-20T17:59:50.914+0200")
@StaticMetamodel(Province.class)
public class Province_ {
	public static volatile SingularAttribute<Province, Integer> id;
	public static volatile SingularAttribute<Province, String> name;
	public static volatile ListAttribute<Province, Buyer> buyers;
}
