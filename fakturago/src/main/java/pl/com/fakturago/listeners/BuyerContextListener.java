package pl.com.fakturago.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import pl.com.fakturago.config.DBManager;

public class BuyerContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		DBManager.getManager().createEntityManagerFactory();

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		DBManager.getManager().closeEntityManagerFactory();

	}
}
