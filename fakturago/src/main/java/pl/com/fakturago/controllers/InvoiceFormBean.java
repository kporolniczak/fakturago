package pl.com.fakturago.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import pl.com.fakturago.config.DBManager;
import pl.com.fakturago.entity.Invoice;
import pl.com.fakturago.entity.Seller;

public class InvoiceFormBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Seller seller = new Seller();
	private Invoice invoice = new Invoice();
	private List <String>formsOfPayment = new ArrayList<String>();;
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
	
	public String loadToEdit(){
		EntityManager em = DBManager.getManager().createEntityManager();
		em.getTransaction().begin();
		this.seller = em.find(Seller.class, 1);
		em.close();
		return "./invoice.xhtml";
	}
}
