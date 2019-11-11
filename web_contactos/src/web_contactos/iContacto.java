package web_contactos;

public interface iContacto {

	public void iniciaContacto(String nombre, String email, int telefono);
	
	public int getIdcontacto();
	
	public void setIdcontacto(int idcontacto);
	
	public String getNombre();
	
	public void setNombre(String nombre);
	
	public String getEmail();
	
	public void setEmail(String email);
	
	public int getTelefono();
	
	public void setTelefono(int telefono);
	
	@Override
	public String toString();
}

