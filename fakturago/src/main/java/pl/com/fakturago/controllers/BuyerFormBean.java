package pl.com.fakturago.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import pl.com.fakturago.config.DBManager;
import pl.com.fakturago.entity.Buyer;


@SessionScoped
@Named("buyerBean")
public class BuyerFormBean implements Serializable {


	private static final long serialVersionUID = 1L;
	private Buyer buyer	 = new Buyer(); 
	
     //Constructors   
	public BuyerFormBean() {
	}
	
	public BuyerFormBean(Buyer buyer) {
		this.buyer = buyer;
	}
	//Getters and setters
	
	public Buyer getBuyer() {
		return buyer;
	}
	
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	//Actions
	
	public List<Buyer> getBuyersList(){
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("Buyer.findAll").getResultList();
		return list;
	}
	
	public String saveBuyer(ActionEvent ae){
		EntityManager em = DBManager.getManager().createEntityManager();
		FacesContext context = FacesContext.getCurrentInstance();
		em.getTransaction().begin();
		buyer.setId(null);
		em.merge(buyer);
		em.getTransaction().commit();
		em.close();	
		context.addMessage(null, new FacesMessage("Dodano użytkownika", "Udało Ci się dodać użytkownika"));
		this.buyer = new Buyer();
		return null;
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
		context.addMessage(null, new FacesMessage("Usunięto użytkownika", "Udało Ci się usunąć użytkownika"));
		return null;
	}
	
	public String loadToEdit(){
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		this.buyer = em.find(Buyer.class,  buyer.getId());
		em.close();
		return "./editBuyer.xhtml";
	}
	
	public void buyerListener(ActionEvent ae){
		String ids = FacesContext.getCurrentInstance().
		getExternalContext().getRequestParameterMap().get("Id").toString();
		this.buyer = new Buyer();
		int id = Integer.parseInt(ids);
		System.out.println(id);
		buyer.setId(id);	
	}
	
	public String edit(){
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		em.merge(this.buyer);
		em.getTransaction().commit();
		em.close();
		this.buyer = new Buyer();
		return "./buyersList.xhtml";
	}
	
	public void onRowSelect(SelectEvent event) {  
        FacesMessage msg = new FacesMessage("Wybrano nabywcę",
        		((Buyer) event.getObject()).getName());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
  
    public void onRowUnselect(UnselectEvent event) {  
        FacesMessage msg = new FacesMessage("Cofnięto wybór", 
        		((Buyer) event.getObject()).getName());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
    public String swicthToBuyersList(){
		return "./buyersList.xhtml";
	}
	
	public String swicthToAddBuyer(){
		this.buyer = new Buyer();
		return "./addBuyer.xhtml";
	}

}

