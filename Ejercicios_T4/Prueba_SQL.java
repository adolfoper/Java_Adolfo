package Ejercicios_T4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Prueba_SQL {
	
	public static void main(String[] args) {
		
		if (!abrir_bd("comercio")) {
			System.exit(0); 
		}
		
		
	}
	/* Scanner entrada = new Scanner(System.in);
			int res, id;
				
	 		String nombre;
				do {
					System.out.println("Escoja opci�n:");
					System.out.println("1.- Ver todas las categor�as");
					System.out.println("2.- Ver una categor�a concreta");
					System.out.println("3.- Crear una nueva categor�a");
					System.out.println("4.- Modificar una categor�a");
					System.out.println("5.- Eliminar una categor�a");
					System.out.println("0.- Salir");
					res = Integer.parseInt(entrada.nextLine());

					switch (res) {
					case 1:
						stmt = con.createStatement();
						rs = stmt.executeQuery("select * from categorias");
						while (rs.next())
							System.out.println(rs.getInt("idcategoria") + "  " + rs.getString("nombre"));
						break;
					case 2:
						System.out.println("Introduzca el id de la categor�a que quiere ver: ");
						id = Integer.parseInt(entrada.nextLine());
						pstmt = con.prepareStatement("select * from categorias where idcategoria=?");
						pstmt.setInt(1, id);
						rs = pstmt.executeQuery();
						if (rs.next()) {
							System.out.println("ID:" + rs.getString("idcategoria") + " | Nombre:" + rs.getString("nombre"));
						} else {
							System.out.println("No encontrado");
						}
						break;
					case 3:
						System.out.println("Introduzca el nombre de la categor�a : ");
						nombre = entrada.nextLine();
						pstmt = con.prepareStatement("insert into categorias (nombre) values(?)");
						pstmt.setString(1, nombre);
						pstmt.execute();
						System.out.println("Categor�a insertada");
						break;
					case 4:
						System.out.println("Introduzca el id de la categor�a que quiere modificar: ");
						id = Integer.parseInt(entrada.nextLine());
						System.out.println("Introduzca el nuevo nombre de la categor�a : ");
						nombre = entrada.nextLine();
						pstmt = con.prepareStatement("update categorias set nombre=? where idcategoria=?");
						pstmt.setString(1, nombre);
						pstmt.setInt(2, id);
						pstmt.execute();
						System.out.println("Categor�a modificada");
						break;
					case 5:
						System.out.println("Introduzca el id de la categor�a que quiere eliminar: ");
						id = Integer.parseInt(entrada.nextLine());
						pstmt = con.prepareStatement("delete from categorias where idcategoria=?");
						pstmt.setInt(1, id);
						pstmt.execute();
						System.out.println("Categor�a eliminada");
						break;
					}
				} while (res != 0);
				con.close();
				entrada.close();
			
		} */
	
	private static boolean abrir_bd(String bd) {
		String cadConexion = "jdbc:mysql://localhost:3306/";
		String usuario = "root";
		String pass = "db2alisdb2";
		boolean retorno;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(cadConexion + bd, usuario, pass);
			Statement stmt;
			PreparedStatement pstmt;
			ResultSet rs;
			stmt = con.createStatement();
			retorno = true;
		} catch (Exception e) {
			System.out.println(e);
			retorno = false;
		}
		return retorno;
	}		
}
