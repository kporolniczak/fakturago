package pl.com.fakturago.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the buyer database table.
 * 
 */
@Entity
@Table(name="buyer")
@NamedQueries({
	@NamedQuery(name = "Buyer.findAll", query = "SELECT p FROM Buyer p")
	})
public class Buyer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String address;

	private String city;

	private String mail;
	
	
	private String name;

	private String nip;

	private String pesel;

	private String zip;

	//bi-directional many-to-one association to Province
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="province",referencedColumnName="id")
	private Province province;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="buyer")
	private Set<Invoice> invoices;

	public Buyer() {
	}
	
	public Buyer(Integer id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNip() {
		return this.nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getPesel() {
		return this.pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Set<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setBuyer(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setBuyer(null);

		return invoice;
	}

	@Override
	public boolean equals(Object object){
		if(!(object instanceof Buyer)){
			return false;
		}
		Buyer other = (Buyer) object;
		if((this.id == null && other.id != null 
				|| this.id != null && !this.id.equals(other.id))){
		return false;
		}
		return true;
		}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
}