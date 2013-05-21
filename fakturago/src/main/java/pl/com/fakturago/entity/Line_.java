package pl.com.fakturago.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-05-21T21:30:57.770+0200")
@StaticMetamodel(Line.class)
public class Line_ {
	public static volatile SingularAttribute<Line, Integer> idservInv;
	public static volatile SingularAttribute<Line, BigDecimal> discount;
	public static volatile SingularAttribute<Line, String> name;
	public static volatile SingularAttribute<Line, BigDecimal> nettoPrice;
	public static volatile SingularAttribute<Line, String> pkwiu;
	public static volatile SingularAttribute<Line, Integer> quantity;
	public static volatile SingularAttribute<Line, String> unit;
	public static volatile SingularAttribute<Line, Integer> vatrate;
	public static volatile SingularAttribute<Line, Invoice> invoice;
}
