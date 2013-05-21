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
@NamedQueries({
	@NamedQuery(name = "Province.findAll", query = "SELECT p FROM Province p")
	})
public class Province implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Buyer
	@OneToMany(mappedBy="province")
	private List<Buyer> buyers;

	//bi-directional many-to-one association to Seller
	@OneToMany(mappedBy="provinceBean")
	private List<Seller> sellers;

	public Province() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public List<Seller> getSellers() {
		return this.sellers;
	}

	public void setSellers(List<Seller> sellers) {
		this.sellers = sellers;
	}

	public Seller addSeller(Seller seller) {
		getSellers().add(seller);
		seller.setProvinceBean(this);

		return seller;
	}

	public Seller removeSeller(Seller seller) {
		getSellers().remove(seller);
		seller.setProvinceBean(null);

		return seller;
	}

}