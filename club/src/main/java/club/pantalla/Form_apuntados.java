package club.pantalla;

public class Form_apuntados {
			
	private int idapuntado;
	
	private int idpartida;
	
	private String comentarios;

	public Form_apuntados(int idpartida) {
		super();
		this.idapuntado = 0;
		this.idpartida = idpartida;
		this.comentarios = "";
	}
	
	public int getIdapuntado() {
		return idapuntado;
	}

	public void setIdapuntado(int idapuntado) {
		this.idapuntado = idapuntado;
	}

	public int getIdpartida() {
		return idpartida;
	}

	public void setIdpartida(int idpartida) {
		this.idpartida = idpartida;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Form_apuntados [idapuntado=" + idapuntado + ", idpartida=" + idpartida + ", comentarios=" + comentarios
				+ "]";
	}
	
}
