package pl.com.fakturago.config;
 
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;

import pl.com.fakturago.entity.Province;

public class ProvinceConverter implements Converter{

	@Override
	public String getAsString(FacesContext ctx, UIComponent c, Object o) {
		if (! (o instanceof Province))
			throw new ConverterException(new FacesMessage("Conversion Failed"));
		Province p = (Province)o;
		return p.getId().toString();
	}
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent c, String s) 
{
		Integer i = Integer.valueOf(s);
		EntityManager em = DBManager.getManager().createEntityManager();
		Province p = em.find(Province.class, i);
		em.close();
		return p;
	}
	
}
