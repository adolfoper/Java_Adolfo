package Ejercicios_T2;

import Ejercicios_T2.Error_Valida;
import Ejercicios_T2.E02_05_Empleado;


public class E02_05_Gerente extends E02_05_Empleado{
	
	private String departamento;
	  // Getter
	  public String getDepartamento() {
	    return departamento;
	  }

	  // Setter
	  public void setDepartamento(String nuevoValor) throws Error_Valida {
		if (nuevoValor.equals(""))
			throw new Error_Valida("Dirección incorrecta");
	    this.departamento = nuevoValor;
	  }
	  
	private int dietas;
		// Getter
		public int getDietas() {
		    return dietas;
		}

		// Setter
	    public void setDietas(int nuevoValor) throws Error_Valida {
		    this.dietas = nuevoValor;
		}	  
	
	//
	//	Constructor con todos los parametros
	//
	E02_05_Gerente(String nombre, String dni, int sueldo, String departamento, int dietas) throws Error_Valida {
		
		   super (nombre,dni,sueldo);
		   
		   if (nombre.equals(""))
			   throw new Error_Valida("Nombre incorrecto");
		   if (dni.equals(""))
			   throw new Error_Valida("Dni incorrecto");
		   if (departamento.equals(""))
			   throw new Error_Valida("Departamento incorrecto");
		   this.departamento = departamento;
		   this.dietas = dietas;
	}
	
	//
	//	Constructor sin sueldo ni dietas
	//
	E02_05_Gerente(String nombre, String dni, String departamento) throws Error_Valida {
		
		   super (nombre,dni);
		   
		   if (nombre.equals(""))
			   throw new Error_Valida("Nombre incorrecto");
		   if (dni.equals(""))
			   throw new Error_Valida("Dni incorrecto");
		   if (departamento.equals(""))
			   throw new Error_Valida("departamento incorrecto");
		   this.dietas = 0;
	}

}