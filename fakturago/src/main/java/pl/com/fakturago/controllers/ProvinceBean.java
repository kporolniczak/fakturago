package pl.com.fakturago.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import pl.com.fakturago.config.DBManager;
import pl.com.fakturago.entity.Province;

@SessionScoped
@Named("provinceBean")
public class ProvinceBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Province province;
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public List<Province> getProvinceList(){
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("Province.findAll").getResultList();
		em.close();
		return list;
	}

}
