package pl.com.fakturago.controllers;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;

import pl.com.fakturago.config.DBManager;
import pl.com.fakturago.entity.Buyer;

@SessionScoped
@Named("buyerBean")
public class BuyerFormBean {

	private Buyer buyer = new Buyer();
	private String title;
	private String text;  
        
	public Buyer getBuyer() {
		return buyer;
	}
	
	 public String getTitle() {  
	        return title;  
	    } 
	 public String getText() {  
	        return text;  
	    } 
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	public List<Buyer> getBuyerList(){
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("Buyer.findAll").getResultList();
		return list;
	}
	
	public String saveBuyer(){
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		buyer.setId(null);
		em.persist(buyer);
		em.getTransaction().commit();
		em.close();
		this.buyer = new Buyer();
		return null;
	}
	
	public void buyerListener(ActionEvent ae){
	String ids = FacesContext.getCurrentInstance().
		getExternalContext().getRequestParameterMap().get("buyerID").toString();
	int id = Integer.parseInt(ids);
	this.buyer.setId(id);
	}
	
	public String deleteBuyer(){
		EntityManager em = DBManager.getManager().createEntityManager();
		FacesContext context = FacesContext.getCurrentInstance(); 
		em.getTransaction().begin();
		this.buyer = em.find(Buyer.class, buyer.getId());
		em.remove(this.buyer);
		this.buyer = new Buyer();
		em.getTransaction().commit();
		em.close();
		context.addMessage(null, new FacesMessage("Saved","You sucessfully added buyer to the database"));
		return null;
	}

}