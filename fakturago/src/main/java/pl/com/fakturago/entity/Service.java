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
	
	private String name;

	private BigDecimal nettoPrice;

	private String pkwiu;

	private String unit;

	private int vatRate;

	//bi-directional many-to-one association to ServInv
	@OneToMany(mappedBy="service")
	private List<ServInv> servInvs;

	public Service() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
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

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getVatRate() {
		return this.vatRate;
	}

	public void setVatRate(int vatRate) {
		this.vatRate = vatRate;
	}

	public List<ServInv> getServInvs() {
		return this.servInvs;
	}

	public void setServInvs(List<ServInv> servInvs) {
		this.servInvs = servInvs;
	}

	public ServInv addServInv(ServInv servInv) {
		getServInvs().add(servInv);
		servInv.setService(this);

		return servInv;
	}

	public ServInv removeServInv(ServInv servInv) {
		getServInvs().remove(servInv);
		servInv.setService(null);

		return servInv;
	}

}