package pl.com.fakturago.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.SelectEvent;

import pl.com.fakturago.config.DBManager;
import pl.com.fakturago.entity.Buyer;
import pl.com.fakturago.entity.Invoice;
import pl.com.fakturago.entity.Seller;
import pl.com.fakturago.entity.ServInv;

public class InvoiceFormBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Seller seller = new Seller();
	private Invoice invoice = new Invoice();
	private ServInv servinv = new ServInv();
	private List <String>formsOfPayment = new ArrayList<String>();
	private List<ServInv> tempServInv = new ArrayList<ServInv>();
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	public List<String> getFormsOfPayment() {
		return formsOfPayment;
	}

	public void setFormsOfPayment(ArrayList<String> formsOfPayment) {
		this.formsOfPayment = formsOfPayment;
	}

	public InvoiceFormBean(){	
	formsOfPayment.add("cash");
	formsOfPayment.add("transfer");
	}
	
	public ServInv getServinv() {
		return servinv;
	}

	public void setServinv(ServInv servinv) {
		this.servinv = servinv;
	}

	public List<ServInv> getTempServInv() {
		return tempServInv;
	}

	public void setTempServInv(List<ServInv> tempServInv) {
		this.tempServInv = tempServInv;
	}

	public String loadToEdit(){
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		this.seller = em.find(Seller.class, 1);
		em.close();
		return "./invoice.xhtml";
	}
	
	public List<Invoice> getInvoicesList(){
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("Invoice.findAll").getResultList();
		return list;
	}
	
	public List<ServInv> getServInvList(){
		EntityManager em = DBManager.getManager().createEntityManager();
		List list = em.createNamedQuery("ServInv.findAll").getResultList();
		return list;
	}
	
	public void onCellEdit(CellEditEvent event) {  
        Object oldValue = event.getOldValue();  
        Object newValue = event.getNewValue();  
          
        if(newValue != null && !newValue.equals(oldValue)) {  
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);  
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        }  
    }  
	public String reinit() {  
        servinv = new ServInv();        
        return null;  
    }  
	
	public void onDialogReturn(SelectEvent event) {  
        ServInv servInv = (ServInv) event.getObject();  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", "Model:");  

        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
}
