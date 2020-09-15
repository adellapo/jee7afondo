package jee7afondo.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EscuchaContexto implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Contexto iniciado...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Contexto finalizado...");
	}

}
