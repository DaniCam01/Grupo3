package model;

public class Telefono {
	private String telefono;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Telefono(String telefono) {
		super();
		this.telefono = telefono;
	}
	public Telefono() {
		super();
	}

	@Override
	public String toString() {
		return "Telefono [telefono=" + telefono + "]";
	}
	
}
