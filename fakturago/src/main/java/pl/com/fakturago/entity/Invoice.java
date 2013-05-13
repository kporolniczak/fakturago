package pl.com.fakturago.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@Table(name="invoice")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date dateOfDraft;

	@Temporal(TemporalType.DATE)
	private Date dateOfSell;

	private String formOfPayment;

	private String number;

	@Temporal(TemporalType.DATE)
	private Date paidBefore;

	private String placeOfSell;

	private BigDecimal prePayment;

	private BigDecimal toPay;

	private BigDecimal total;

	//bi-directional many-to-one association to Buyer
	@ManyToOne
	@JoinColumn(name="fk_buyer")
	private Buyer buyer;

	//bi-directional many-to-one association to Seller
	@ManyToOne
	@JoinColumn(name="fk_seller")
	private Seller seller;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="fk_service")
	private Service service;

	public Invoice() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfDraft() {
		return this.dateOfDraft;
	}

	public void setDateOfDraft(Date dateOfDraft) {
		this.dateOfDraft = dateOfDraft;
	}

	public Date getDateOfSell() {
		return this.dateOfSell;
	}

	public void setDateOfSell(Date dateOfSell) {
		this.dateOfSell = dateOfSell;
	}

	public String getFormOfPayment() {
		return this.formOfPayment;
	}

	public void setFormOfPayment(String formOfPayment) {
		this.formOfPayment = formOfPayment;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getPaidBefore() {
		return this.paidBefore;
	}

	public void setPaidBefore(Date paidBefore) {
		this.paidBefore = paidBefore;
	}

	public String getPlaceOfSell() {
		return this.placeOfSell;
	}

	public void setPlaceOfSell(String placeOfSell) {
		this.placeOfSell = placeOfSell;
	}

	public BigDecimal getPrePayment() {
		return this.prePayment;
	}

	public void setPrePayment(BigDecimal prePayment) {
		this.prePayment = prePayment;
	}

	public BigDecimal getToPay() {
		return this.toPay;
	}

	public void setToPay(BigDecimal toPay) {
		this.toPay = toPay;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Seller getSeller() {
		return this.seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

}