package pl.com.fakturago.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


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
	@PrimaryKeyJoinColumn
	private Integer id;

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

	@Transient
	private Line line = new Line();
	@Transient
	private BigDecimal toPay;

	//bi-directional many-to-one association to Buyer
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_buyer")
	private Buyer buyer;

	//bi-directional many-to-one association to Line
	@OneToMany(cascade = CascadeType.ALL, mappedBy="invoice")
	
	private List<Line> lines;

	public Invoice() {
		this.line=line;
		this.lines=new ArrayList<Line>();
		
	}

	public Invoice(Date dateOfDraft, Date dateOfSell, String formOfPayment,
			String number, Date paidBefore, String placeOfSell,
			BigDecimal prePayment, BigDecimal toPay, BigDecimal total,
			Buyer buyer, List<Line> lines) {
		this.dateOfDraft = dateOfDraft;
		this.dateOfSell = dateOfSell;
		this.formOfPayment = formOfPayment;
		this.number = number;
		this.paidBefore = paidBefore;
		this.placeOfSell = placeOfSell;
		this.prePayment = prePayment;
		this.buyer = buyer;
		this.lines = lines;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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
		if(this.prePayment == null)
			prePayment = new BigDecimal(0);
		return this.getTotal().subtract(this.prePayment);
	}


	public BigDecimal getTotal() {
		return this.totalBrutto(this.lines);
	}


	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public List<Line> getLines() {
		return this.lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public Line getLine() {
		if(line == null)
			line = new Line();
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public Line addLine(Line line) {
		getLines().add(line);
		line.setInvoice(this);
		return line;
	}

	public Line removeLine(Line line) {
		getLines().remove(line);
		line.setInvoice(null);

		return line;
	}
	
	public String reinit() { 
        line = new Line();         
        return "./invoice.xhtml";  
    }  

	public BigDecimal totalBrutto(List<Line> lines){
	BigDecimal sum = new BigDecimal(0);
	for(Line l : lines){
		sum=sum.add(l.getBruttoValue());
	}
	return sum;
	}
	
	@Override
	public boolean equals(Object object){
		if(!(object instanceof Invoice)){
			return false;
		}
		Invoice other = (Invoice) object;
		if((this.id == null && other.id != null 
				|| this.id != null && !this.id.equals(other.id))){
		return false;
		}
		return true;
		}

}