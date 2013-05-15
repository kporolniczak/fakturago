package pl.com.fakturago.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-05-14T21:59:22.956+0200")
@StaticMetamodel(Service.class)
public class Service_ {
	public static volatile SingularAttribute<Service, Integer> id;
	public static volatile SingularAttribute<Service, BigDecimal> bruttoValue;
	public static volatile SingularAttribute<Service, BigDecimal> discount;
	public static volatile SingularAttribute<Service, BigDecimal> nettoPrice;
	public static volatile SingularAttribute<Service, BigDecimal> nettoValue;
	public static volatile SingularAttribute<Service, String> pkwiu;
	public static volatile SingularAttribute<Service, Integer> quantity;
	public static volatile SingularAttribute<Service, String> unit;
	public static volatile SingularAttribute<Service, BigDecimal> vatValue;
	public static volatile ListAttribute<Service, Invoice> invoices;
	public static volatile SingularAttribute<Service, Vat> vat;
}
