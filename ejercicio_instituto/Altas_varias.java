package ejercicio_instituto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import ejercicio_instituto.Alumnos;
import ejercicio_instituto.Modulos;
import ejercicio_instituto.Mod_alu;
import ejercicio_instituto.Profesores;

public class Altas_varias {
	public static void main(String args[]) {
		// Crear la configuración cogiéndola del xml y añadiendo las clases 
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Profesores.class)
					.addAnnotatedClass(Alumnos.class)
					.addAnnotatedClass(Modulos.class)
					.addAnnotatedClass(Mod_alu.class);	
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		
		// Crear la factoría de sesiones
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		// Crear la sesión
		Session session = factory.getCurrentSession();
		
		try {

			// Iniciar transacción
			session.beginTransaction();

			// Alta 2 profesores
			Profesores manolo= new Profesores("Manolo", "12345678L", "manolo@gmail.com");
			session.save(manolo);
			Profesores antonio= new Profesores("Antonio", "33333333J", "antonio@gmail.com");
			session.save(antonio); 

			// Alta 2 modulos
			Modulos matematicas = new Modulos("Matemáticas");
			Modulos ingles = new Modulos("Ingles");

			// Asignar modulos a profesores
			manolo.addModulos(matematicas);
			session.save(matematicas);			
			
			antonio.addModulos(ingles);
			session.save(ingles); 
			
			// Alta 3 alumnos asociados a sus modulos
			Alumnos alumno1= new Alumnos("Quarterback", "Quarterback@gmail.com");
			alumno1.addModulo(matematicas);
			session.save(alumno1);
			
			Alumnos alumno2= new Alumnos("Animadora", "animadora@gmail.com");
			alumno2.addModulo(matematicas);
			session.save(alumno2);
			
			Alumnos alumno3= new Alumnos("Gafapasta", "gafapasta@gmail.com");
			alumno3.addModulo(ingles);
			session.save(alumno3);
			
			// commit de la transacción
			session.getTransaction().commit();
			session.close();
			Session session2 = factory.getCurrentSession();
			session2.beginTransaction();
			
			// Prueba accesos
			Modulos matematicas_b = session2.get(Modulos.class,matematicas.getIdmodulo());
			Alumnos alumno3_b = session2.get(Alumnos.class, alumno3.getIdalumno());
			Profesores Manolo_b = session2.get(Profesores.class, manolo.getIdprofesor());

			// Strings intermedios para que salgan aparte los mensajes de consola de SQL
			String a = matematicas_b.toString();
			String b = alumno3_b.toString();
			String c = Manolo_b.toString();
			System.out.println("--------------------------------------------");		
			System.out.println(b);
			System.out.println(c);
			System.out.println(a);
			
			// commit de la transacción
			session2.getTransaction().commit();
			session2.close();			

		} finally {
			factory.close();
		}
		
	}

}
