package pl.com.fakturago.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the province database table.
 * 
 */
@Entity
@Table(name="province")
public class Province implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Buyer
	@OneToMany(mappedBy="province")
	private List<Buyer> buyers;

	public Province() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Buyer> getBuyers() {
		return this.buyers;
	}

	public void setBuyers(List<Buyer> buyers) {
		this.buyers = buyers;
	}

	public Buyer addBuyer(Buyer buyer) {
		getBuyers().add(buyer);
		buyer.setProvince(this);

		return buyer;
	}

	public Buyer removeBuyer(Buyer buyer) {
		getBuyers().remove(buyer);
		buyer.setProvince(null);

		return buyer;
	}

}