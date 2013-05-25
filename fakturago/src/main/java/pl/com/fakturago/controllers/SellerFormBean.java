package pl.com.fakturago.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import pl.com.fakturago.config.DBManager;
import pl.com.fakturago.entity.Seller;

public class SellerFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Seller seller = new Seller();

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	public String loadToEdit(){
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		this.seller = em.find(Seller.class, 1);
		em.close();
		return "./profile.xhtml";
	}
	
	public String edit(ActionEvent ae){
		EntityManager em = DBManager.getManager().createEntityManager();
		FacesContext context = FacesContext.getCurrentInstance();
		em.getTransaction().begin();
		em.merge(this.seller);
		em.getTransaction().commit();
		em.close();
		this.seller = new Seller();
		context.addMessage(null, 
				new FacesMessage("Profile uaktualniony", "Udało Ci się uaktualnić swoje dane"));
		return null;
	}

}
