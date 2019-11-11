package web_contactos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DAO_Contactos {
	
	// Cargar bean Contacto
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
	Contacto contacto = context.getBean("contacto",Contacto.class);
	
	// Crear la configuración hibernate cogiéndola del xml y añadiendo las clases 
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Contacto.class);	
		
	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties());
		
	// Crear la factoría de sesiones
	SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
	public Boolean alta() {
		
		Boolean correcto = true;
		
		// Abrir la sesión
		Session session = factory.getCurrentSession();	
		
		System.out.println("En alta");
		
		try {

			// Iniciar transacción
			session.beginTransaction();

			// Alta 2 profesores
			//Profesores manolo= new Profesores("Manolo", "12345678L", "manolo@gmail.com");
			//session.save(manolo);
						
			// commit de la transacción y cierre
			session.getTransaction().commit();
			session.close();
		} 
		catch (Exception exception) {
			System.out.println("Error:"+exception);
			cerrarFactory() ;
			correcto = false;
		}
		
		return correcto;
	}
	
	public void cerrarFactory() {
		factory.close();
	}

}
