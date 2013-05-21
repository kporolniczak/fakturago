package pl.com.fakturago.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-05-21T16:50:08.228+0200")
@StaticMetamodel(Province.class)
public class Province_ {
	public static volatile SingularAttribute<Province, Integer> id;
	public static volatile SingularAttribute<Province, String> name;
	public static volatile ListAttribute<Province, Buyer> buyers;
	public static volatile ListAttribute<Province, Seller> sellers;
}
