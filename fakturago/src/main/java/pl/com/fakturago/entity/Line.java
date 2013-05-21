package pl.com.fakturago.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the line database table.
 * 
 */
@Entity
@Table(name="line")
@NamedQueries({
	@NamedQuery(name = "Line.findAll", query = "SELECT l FROM Line l")
	})
public class Line implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idserv_inv")
	private Integer idservInv;

	private BigDecimal discount;

	private String name;

	private BigDecimal nettoPrice;

	private String pkwiu;

	private int quantity;

	private String unit;

	private int vatrate;

	//bi-directional many-to-one association to Invoice
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_invoice", referencedColumnName="id")
	private Invoice invoice;

	public Line() {
	}

	public Integer getIdservInv() {
		return this.idservInv;
	}

	public void setIdservInv(Integer idservInv) {
		this.idservInv = idservInv;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getNettoPrice() {
		return this.nettoPrice;
	}

	public void setNettoPrice(BigDecimal nettoPrice) {
		this.nettoPrice = nettoPrice;
	}

	public String getPkwiu() {
		return this.pkwiu;
	}

	public void setPkwiu(String pkwiu) {
		this.pkwiu = pkwiu;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getVatrate() {
		return this.vatrate;
	}

	public void setVatrate(int vatrate) {
		this.vatrate = vatrate;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}