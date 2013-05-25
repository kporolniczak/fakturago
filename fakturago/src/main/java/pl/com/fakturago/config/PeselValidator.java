package pl.com.fakturago.config;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;

import pl.com.fakturago.entity.Buyer;

public class PeselValidator implements Validator{

	@Override
	public void validate(FacesContext ctx, UIComponent component, Object object)
			throws ValidatorException {
		if(!(object instanceof String)) throw new ValidatorException
		(new FacesMessage("Uwaga!","Przekazana wartość nie jest łańcuchem znaków"));
		String pesel = (String)object;
		if(!pesel.matches("[0-9]{11}"))throw new ValidatorException
		(new FacesMessage("Uwaga!","Niepoprawny format numeru PESEL"));
		EntityManager em = DBManager.getManager().createEntityManager();
		List<Buyer> list = em.createNamedQuery("Buyer.findByPesel").
		setParameter("pesel",pesel).getResultList();
		em.close();
		if(list.size()>0)throw new ValidatorException(
				new FacesMessage("Uwaga!","Wprowadzony PESEL już istnieje w bazie danych"));
		
	}

}
