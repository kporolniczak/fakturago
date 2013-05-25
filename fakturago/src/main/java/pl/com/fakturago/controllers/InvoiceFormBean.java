package pl.com.fakturago.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import org.primefaces.event.CellEditEvent;

import pl.com.fakturago.config.DBManager;
import pl.com.fakturago.entity.Invoice;
import pl.com.fakturago.entity.Line;
import pl.com.fakturago.entity.Seller;

public class InvoiceFormBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Seller seller = new Seller();
	private Invoice invoice = new Invoice();
	private List <String>formsOfPayment = new ArrayList<String>();
	private Line line;
	private List <Line> lines = new ArrayList<Line>();
	
	//Constructors   
	public InvoiceFormBean(Line line) {
		this.line = line;
	}
	
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

	public Line getLine() {
		if(line == null)
			line = new Line();
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public InvoiceFormBean(){
	formsOfPayment.add("gotówka");
	formsOfPayment.add("przelew");
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
	
	public void onCellEdit(CellEditEvent event) {  
        Object oldValue = event.getOldValue();  
        Object newValue = event.getNewValue();  
          
        if(newValue != null && !newValue.equals(oldValue)) {  
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);  
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        }  
    }  
	public String reinit() {  
        line = new Line();         
        return "./invoice.xhtml";  
    }  
	
	public String addLine(Line line) {
		Line newLine = new Line();
		newLine.setName(invoice.getNumber());
		lines.add(newLine);
		return "./index.xhtml";
	}

	public InvoiceFormBean(Seller seller, Invoice invoice, Line line) {
		this.seller = seller;
		this.invoice = invoice;
		this.line = line;
	}
	
	public String saveInvoice(ActionEvent ae){

		EntityManager em = DBManager.getManager().createEntityManager();
		FacesContext context = FacesContext.getCurrentInstance();
		em.getTransaction().begin();
		invoice.setId(null);
		em.merge(invoice);
		em.getTransaction().commit();
		em.close();
		context.addMessage(null, 
				new FacesMessage("Invoice saved", "You successfully saved new invoice")); 	
		this.invoice = new Invoice();
		return null;
	}
}
