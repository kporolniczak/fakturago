package pl.com.fakturago.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-05-20T19:25:18.378+0200")
@StaticMetamodel(ServInv.class)
public class ServInv_ {
	public static volatile SingularAttribute<ServInv, Integer> idservInv;
	public static volatile SingularAttribute<ServInv, BigDecimal> discount;
	public static volatile SingularAttribute<ServInv, Integer> quantity;
	public static volatile SingularAttribute<ServInv, Service> service;
	public static volatile SingularAttribute<ServInv, Invoice> invoice;
}
