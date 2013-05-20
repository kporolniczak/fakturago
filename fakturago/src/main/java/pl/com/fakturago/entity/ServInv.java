package pl.com.fakturago.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="serv_inv")
@NamedQueries({
	@NamedQuery(name = "ServInv.findAll", query = "SELECT s FROM ServInv s")
	})
public class ServInv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idserv_inv")
	private Integer idservInv;

	private BigDecimal discount;

	private Integer quantity;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="fk_service")
	private Service service;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	@JoinColumn(name="fk_invoice")
	private Invoice invoice;

	public ServInv(BigDecimal discount, int quantity, Service service,
			Invoice invoice) {
		this.discount = discount;
		this.quantity = quantity;
		this.service = service;
		this.invoice = invoice;
	}

	public ServInv() {		
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

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Double getNettoValue(){
		if(this.quantity == null || this.service.getNettoPrice() == null)
			return 0.0;
		else
		return this.quantity * this.service.getNettoPrice().doubleValue();
	}
}