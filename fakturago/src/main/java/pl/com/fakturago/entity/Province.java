package pl.com.fakturago.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Buyer
	@OneToMany(mappedBy="province", fetch=FetchType.LAZY)
	private Set<Buyer> buyers;

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

	public Set<Buyer> getBuyers() {
		return this.buyers;
	}

	public void setBuyers(Set<Buyer> buyers) {
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
	@Override
	public boolean equals(Object object){
		if(!(object instanceof Province)){
			return false;
		}
		Province other = (Province) object;
		if((this.id == null && other.id != null 
				|| this.id != null && !this.id.equals(other.id))){
		return false;
		}
		return true;
		}
}