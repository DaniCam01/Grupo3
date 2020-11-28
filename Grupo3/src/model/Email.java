package model;

public class Email {
	private String email;
	private String dni;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Email(String email, String dni) {
		super();
		this.email = email;
		this.dni = dni;
	}
	public Email() {
		super();
	}
	@Override
	public String toString() {
		return "Email [email=" + email + "]";
	}
	
	
}
