package Ejercicios_T4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.math.BigDecimal;

public class Mantenimiento_Tabla {

	// Canal de entrada por teclado
	static Scanner sc = new Scanner(System.in);
	
	// Variables de acceso a base de datos
	static Connection con;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	public static void main(String[] args) {
		
		if (abrir_bd("comercio")) {
			String opcion = "";
			
			// Repetir hasta pulsar salir
			do
			{
				
				System.out.println("Escoja opción:");
				System.out.println("1.- Mantenimiento proveedores");
				System.out.println("2.- Mantenimiento productos");
				System.out.println("0.- Salir");
					
				opcion = sc.nextLine();
					
				switch (opcion) {
				case "1":					// proveedores
					try {
						acceso_proveedores();
					}
					catch (Exception e) {
						System.out.println(e);
					}
					break;
				case "2":					// productos
					try {
						acceso_productos();
					}
					catch (Exception e) {
						System.out.println(e);
					}
					break;
				case "0":					// salir
					break;
				default:					// opcion errónea
					System.out.println("Opción errónea");
						
				}
				
			} while (!opcion.equals("0"));
			
			System.out.println("Fin del programa");	
			sc.close(); 
		}			
	}
	
	//
	//			Acceso a la tabla de proveedores
	//
	private static void acceso_proveedores() throws Exception{
			
		String opcion = "";
		int id;
		String nif, nombre, direccion;
		
		//  Bucle del menú hasta pulsar salir
		do {
			opcion = menu_mantenimiento();
		
			switch (opcion) {
			
			//  Consulta por clave
			case "1":
				
				// Pedir clave
				System.out.println("Introduzca el id del proveedor que quiere ver: ");
				id = Integer.parseInt(sc.nextLine());
	
				// Acceso datos
				pstmt = con.prepareStatement("select * from proveedores where id_proveedor=?");
				pstmt.setInt(1, id);	
				rs = pstmt.executeQuery();
				
				// Mostrar datos
				if (rs.next()) {
					System.out.println("ID:"        + rs.getString("id_proveedor") + 
									   " | NIF:" + rs.getString("nif_proveedor") +
									   " | Nombre:" + rs.getString("nombre_proveedor") +
									   " | Dirección:" + rs.getString("direccion_proveedor")
							);
				} else {
					System.out.println("No encontrado");
				}
				break;
	
			//  Alta proveedor				
			case "2":
				
				// Pedir datos
				do {
					System.out.println("Introduzca nombre del proveedor (obligatorio): ");
					nombre = sc.nextLine();
					System.out.println();
				}
				while (nombre.equals(""));
				
				System.out.println("Introduzca NIF del nuevo proveedor (opcional): ");
				nif = sc.nextLine();
				
				System.out.println("Introduzca dirección del proveedor (opcional): ");
				direccion = sc.nextLine();
				
				// Insertar datos
				pstmt= con.prepareStatement("insert into proveedores "
						                 + "(nombre_proveedor,nif_proveedor,direccion_proveedor) "
						                 + "values(?, ?, ?)", pstmt.RETURN_GENERATED_KEYS);
				pstmt.setString(1, nombre);
				pstmt.setString(2, nif);
				pstmt.setString(3, direccion);
				pstmt.execute();
				
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					id = generatedKeys.getInt(1);
					System.out.println("Proveedor insertado con nuevo código: "+id);
				}
				
				break;
			
			//  Modificar proveedor
			case "3":
				
				// Pedir clave
				System.out.println("Introduzca el id del proveedor a modificar: ");
				id = Integer.parseInt(sc.nextLine());
				
				// Comprobar si existe
				pstmt = con.prepareStatement("select * from proveedores where id_proveedor=?");
				pstmt.setInt(1, id);			
				rs = pstmt.executeQuery();
				
				// Si existe
				if (rs.next()) {
					
					// Mostrar datos actuales
					nif = rs.getString("nif_proveedor");
					nombre = rs.getString("nombre_proveedor");
					direccion = rs.getString("direccion_proveedor");

					System.out.println("Datos actuales:" + 
									   " NIF:" + nif +
									   " | Nombre:" + nombre +
									   " | Dirección:" + direccion);
					
					// Pedir nuevos datos
					System.out.println("Introduzca nuevo NIF (vacio = no modif.)");
					nif = entra_campo(nif);
					
					System.out.println("Introduzca nuevo nombre (vacio = no modif.)");
					nombre = entra_campo(nombre);
					
					System.out.println("Introduzca nueva direccion (vacio = no modif.)");
					direccion = entra_campo(direccion);
					
					// Modificar datos
					pstmt = con.prepareStatement("update proveedores " +
							                     "set nif_proveedor=?, nombre_proveedor=?, direccion_proveedor=? " +
							                     "where id_proveedor=?");
					pstmt.setString(1, nif);
					pstmt.setString(2, nombre);
					pstmt.setString(3, direccion);
					pstmt.setInt(4, id);
					pstmt.execute();
					System.out.println("Proveedor modificado");
		
				} else {
					System.out.println("Proveedor no encontrado");
				}
				
				break;	

			//  Eliminar proveedor
			case "4":
				
				// Pedir clave
				System.out.println("Introduzca el id del proveedor a eliminar (0 = cancelar): ");
				id = Integer.parseInt(sc.nextLine());
					
				// Si el usuario no cancela la operación
				if (id!=0) {
						
					// Validar clave
					pstmt = con.prepareStatement("select id_proveedor from proveedores where id_proveedor=?");
					pstmt.setInt(1, id);
					
					// Comprobar existencia
					rs = pstmt.executeQuery();
					
					if (rs.next()) {		
						
						// Delete proveedor
						pstmt = con.prepareStatement("delete from proveedores where id_proveedor=?");
						pstmt.setInt(1, id);
						pstmt.execute();
						System.out.println("Proveedor eliminado");			
					} else {
						System.out.println("Proveedor no encontrado");
					}
				}
				else {
					System.out.println("Operacion cancelada");
				}
				break;
			}		
		}
		while (!opcion.equals("0"));
	}
	
	//
	//			Acceso a la tabla de productos
	//
	private static void acceso_productos() throws Exception{
			
		String opcion = "";
		int id, id_proveedor;
		double precio;
		String nombre, direccion;
		BigDecimal inter;
		
		// Menú hasta pulsar salir
		do {
			opcion = menu_mantenimiento();
		
			switch (opcion) {
			
			//  Consulta por clave
			case "1":
				
				// Pedir clave
				System.out.println("Introduzca el id del producto que quiere ver: ");
				id = Integer.parseInt(sc.nextLine());
	
				// Acceso datos
				pstmt = con.prepareStatement("select * from productos where id_codigo_producto=?");
				pstmt.setInt(1, id);	
				rs = pstmt.executeQuery();
				
				// Mostrar datos
				if (rs.next()) {
					System.out.println("ID:" + rs.getString("id_codigo_producto") + 
									   " | Nombre producto:" + rs.getString("nombre_producto") +
									   " | ID proveedor:" + rs.getString("id_proveedor") +
									   " | Precio unitario:" + rs.getString("precio_unitario_producto"));
				} else {
					System.out.println("No encontrado");
				}
				break;
	
			//  Alta producto				
			case "2":
				
				// Pedir nombre de producto
				do {
					System.out.println("Introduzca nombre del producto (obligatorio): ");
					nombre = sc.nextLine();
					System.out.println();
				}
				while (nombre.equals(""));
				
				System.out.println("Introduzca id proveedor (vacio = no modif.): ");
				id_proveedor = Integer.parseInt(sc.nextLine());
					
				// Comprobar si existe el proveedor
				pstmt = con.prepareStatement("select * from proveedores where id_proveedor=?");
				pstmt.setInt(1, id_proveedor);			
				rs = pstmt.executeQuery();
					
				// Continuar solo si existe el proveedor
				if (rs.next()) {
				
					System.out.println("Introduzca precio unitario (opcional): ");
					precio = Double.parseDouble(sc.nextLine());

					// Insertar producto
					pstmt= con.prepareStatement("insert into productos "
						                 + "(nombre_producto,precio_unitario_producto,id_proveedor) "
						                 + "values(?, ?, ?)", pstmt.RETURN_GENERATED_KEYS);
					pstmt.setString(1, nombre);

					inter = new BigDecimal(precio);
					pstmt.setBigDecimal(2, inter);
					pstmt.setInt(3, id_proveedor);
					pstmt.execute();

					ResultSet generatedKeys = pstmt.getGeneratedKeys();
					if (generatedKeys.next()) {
						id = generatedKeys.getInt(1);
						System.out.println("Producto insertado con nuevo código: "+id);
					}
				}
				else
					System.out.println("Error, proveedor no encontrado");
				break;
			
			//  Modificar producto
			case "3":
				
				// Pedir clave
				System.out.println("Introduzca el id del producto a modificar: ");
				id = Integer.parseInt(sc.nextLine());
				
				// Comprobar si existe el producto
				pstmt = con.prepareStatement("select * from productos where id_codigo_producto=?");
				pstmt.setInt(1, id);			
				rs = pstmt.executeQuery();
				
				// Si existe
				if (rs.next()) {
					
					// Mostrar datos actuales
					id_proveedor = rs.getInt("id_proveedor");
					nombre = rs.getString("nombre_producto");
					precio = rs.getDouble("precio_unitario_producto");

					System.out.println("ID:"        + rs.getString("id_codigo_producto") + 
							   " | Nombre producto:" + rs.getString("nombre_producto") +
							   " | ID proveedor:" + rs.getInt("id_proveedor") +
							   " | Precio unitario:" + rs.getDouble("precio_unitario_producto"));	
					
					// Inicio pedir datos
					System.out.println("Introduzca nuevo nombre (vacio = no modif.)");
					nombre = entra_campo(nombre);
					
					System.out.println("Introduzca id proveedor (vacio = no modif.): ");
					id_proveedor = entra_campo(id_proveedor);
						
					// Comprobar si existe el proveedor
					pstmt = con.prepareStatement("select * from proveedores where id_proveedor=?");
					pstmt.setInt(1, id_proveedor);			
					rs = pstmt.executeQuery();
					
					// Continuar solo si existe el proveedor
					if (rs.next()) {
	
						System.out.println("Introduzca precio unitario (vacio = no modif.): ");
						precio = entra_campo(precio);
					
						// Modificar datos
						pstmt = con.prepareStatement("update productos " +
							                     "set nombre_producto=?, precio_unitario_producto=?, id_proveedor=? " +
							                     "where id_codigo_producto=?");

						pstmt.setString(1, nombre);
						inter = new BigDecimal(precio);
						pstmt.setBigDecimal(2, inter);
						pstmt.setInt(3, id_proveedor);
						pstmt.setInt(4, id);
						pstmt.execute();
						System.out.println("Producto modificado");
		
					} else {
						System.out.println("Proveedor no encontrado");
					}
				} else {
					System.out.println("Producto no encontrado");
				}
				
				break;	

			//  Eliminar producto
			case "4":
				
				// Pedir clave
				System.out.println("Introduzca el id del producto a eliminar (0 = cancelar): ");
				id = Integer.parseInt(sc.nextLine());
					
				// Si el usuario no cancela la operación
				if (id!=0) {
						
					// Validar clave
					pstmt = con.prepareStatement("select id_codigo_producto from productos where id_codigo_producto=?");
					pstmt.setInt(1, id);
					
					// Comprobar existencia
					rs = pstmt.executeQuery();
					
					if (rs.next()) {		
						
						// Delete producto
						pstmt = con.prepareStatement("delete from productos where id_codigo_producto=?");
						pstmt.setInt(1, id);
						pstmt.execute();
						System.out.println("Prducto eliminado");			
					} else {
						System.out.println("Producto no encontrado");
					}
				}
				else {
					System.out.println("Operacion cancelada");
				}
				break;
			}		
		}
		while (!opcion.equals("0"));
	}

	//
	// Entrada de campo String para modificación	
	//
	private static String entra_campo(String entrada) {
		
		String campo = sc.nextLine();
		if (!campo.equals("")) {
			return campo;
		}
		else
			return entrada;
	}	

	//
	// Entrada de campo int para modificación
	//
	private static int entra_campo(int entrada) {
		
		String campo = sc.nextLine();
		
		if (!campo.equals("")) {
			System.out.println("Pues no es vacío");
			return Integer.parseInt(campo);
		}
		else {
			return entrada;
		}
	}
	
	//
	// Entrada de campo double para modificación
	//
	private static double entra_campo(double entrada) {
		
		String campo = sc.nextLine();
		
		if (!campo.equals("")) {
			return Double.parseDouble(campo);
		}
		else {
			return entrada;
		}
	}
	
	//
	// Menú mantenimiento de base de datos
	//
	private static String menu_mantenimiento() {
		
		String opcion;
		
		// Repetir hasta opción correcta
		do
		{
			System.out.println("\nEscoja opción:");
			System.out.println("1.- Ver registro");
			System.out.println("2.- Añadir registro");
			System.out.println("3.- Modificar registro");
			System.out.println("4.- Eliminar registro");
			System.out.println("0.- Menu anterior");
						
			opcion = sc.nextLine();
			if (!opcion.equals("0") & !opcion.equals("1") & !opcion.equals("2") &
				!opcion.equals("3") & !opcion.equals("4"))
				System.out.println("Opción errónea");	
		}
		while (!opcion.equals("0") & !opcion.equals("1") & !opcion.equals("2") &
			   !opcion.equals("3") & !opcion.equals("4"));	

		return opcion;
	}
	
	//
	// Apertura de la base de datos
	//
	private static boolean abrir_bd(String bd) {
		String cadConexion = "jdbc:mysql://localhost:3306/";
		String usuario = "root";
		String pass = "db2alisdb2";
		boolean retorno;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(cadConexion + bd, usuario, pass);

			stmt = con.createStatement();
			retorno = true;
		} catch (Exception e) {
			System.out.println(e);
			retorno = false;
		}
		return retorno;
	}		
}
