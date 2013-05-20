package pl.com.fakturago.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-05-20T17:59:50.913+0200")
@StaticMetamodel(Invoice.class)
public class Invoice_ {
	public static volatile SingularAttribute<Invoice, Integer> id;
	public static volatile SingularAttribute<Invoice, Date> dateOfDraft;
	public static volatile SingularAttribute<Invoice, Date> dateOfSell;
	public static volatile SingularAttribute<Invoice, String> formOfPayment;
	public static volatile SingularAttribute<Invoice, String> number;
	public static volatile SingularAttribute<Invoice, Date> paidBefore;
	public static volatile SingularAttribute<Invoice, String> placeOfSell;
	public static volatile SingularAttribute<Invoice, BigDecimal> prePayment;
	public static volatile SingularAttribute<Invoice, BigDecimal> toPay;
	public static volatile SingularAttribute<Invoice, BigDecimal> total;
	public static volatile SingularAttribute<Invoice, Buyer> buyer;
	public static volatile SingularAttribute<Invoice, Seller> seller;
	public static volatile ListAttribute<Invoice, ServInv> servInvs;
}
