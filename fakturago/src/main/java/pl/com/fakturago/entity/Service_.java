package pl.com.fakturago.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-05-20T20:09:56.262+0200")
@StaticMetamodel(Service.class)
public class Service_ {
	public static volatile SingularAttribute<Service, Integer> id;
	public static volatile SingularAttribute<Service, String> name;
	public static volatile SingularAttribute<Service, BigDecimal> nettoPrice;
	public static volatile SingularAttribute<Service, String> pkwiu;
	public static volatile SingularAttribute<Service, String> unit;
	public static volatile SingularAttribute<Service, Integer> vatRate;
	public static volatile ListAttribute<Service, ServInv> servInvs;
}
