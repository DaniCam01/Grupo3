package model;

public class Telefono {
	private String tlf;
	private String dni;
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String telefono) {
		this.tlf = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Telefono(String telefono, String dni) {
		super();
		this.tlf = telefono;
		this.dni = dni;
	}
	public Telefono() {
		super();
	}
	@Override
	public String toString() {
		return "Telefono [telefono=" + tlf + ", dni=" + dni + "]";
	}
	
	
	
}
