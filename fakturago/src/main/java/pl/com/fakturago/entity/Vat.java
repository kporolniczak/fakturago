package pl.com.fakturago.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vat database table.
 * 
 */
@Entity
@Table(name="vat")
public class Vat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte vatrate;

	//bi-directional many-to-one association to Service
	@OneToMany(mappedBy="vat")
	private List<Service> services;

	public Vat() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getVatrate() {
		return this.vatrate;
	}

	public void setVatrate(byte vatrate) {
		this.vatrate = vatrate;
	}

	public List<Service> getServices() {
		return this.services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public Service addService(Service service) {
		getServices().add(service);
		service.setVat(this);

		return service;
	}

	public Service removeService(Service service) {
		getServices().remove(service);
		service.setVat(null);

		return service;
	}

}