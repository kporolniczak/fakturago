package pl.com.fakturago.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@Table(name="service")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private BigDecimal bruttoValue;

	private BigDecimal discount;

	private BigDecimal nettoPrice;

	private BigDecimal nettoValue;

	private String pkwiu;

	private int quantity;

	private String unit;

	private BigDecimal vatValue;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="service")
	private List<Invoice> invoices;

	//bi-directional many-to-one association to Vat
	@ManyToOne
	@JoinColumn(name="fk_vatRate")
	private Vat vat;

	public Service() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getBruttoValue() {
		return this.bruttoValue;
	}

	public void setBruttoValue(BigDecimal bruttoValue) {
		this.bruttoValue = bruttoValue;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getNettoPrice() {
		return this.nettoPrice;
	}

	public void setNettoPrice(BigDecimal nettoPrice) {
		this.nettoPrice = nettoPrice;
	}

	public BigDecimal getNettoValue() {
		return this.nettoValue;
	}

	public void setNettoValue(BigDecimal nettoValue) {
		this.nettoValue = nettoValue;
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

	public BigDecimal getVatValue() {
		return this.vatValue;
	}

	public void setVatValue(BigDecimal vatValue) {
		this.vatValue = vatValue;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setService(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setService(null);

		return invoice;
	}

	public Vat getVat() {
		return this.vat;
	}

	public void setVat(Vat vat) {
		this.vat = vat;
	}

}