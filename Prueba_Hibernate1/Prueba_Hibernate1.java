package Prueba_Hibernate1;
import java.sql.Connection;
import java.sql.DriverManager;


public class Prueba_Hibernate1 {
	public static void main(String args[]) {
		String bd="comercio";
		String user= "root";
		String pass= "db2alisdb2";
		//String jdbcUrl= "jdbc:mysql://localhost:3306/"+bd+"?useSSL=false&serverTimezone=UTC";
		String jdbcUrl= "jdbc:mysql://localhost:3306/"+bd+"?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
				
		try{
			System.out.println("Conectando:"+ jdbcUrl);
			Connection myConn=DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Todo bien");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
			
	}
}
