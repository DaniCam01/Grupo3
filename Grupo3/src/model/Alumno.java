package model;

import java.util.ArrayList;

public class Alumno {
	private String dni;
	private String nombre;
	private ArrayList<Email> emails;
	private ArrayList<Telefono> telefonos;
	private Curso curso;
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Email> getEmails() {
		return emails;
	}
	public void setEmails(ArrayList<Email> emails) {
		this.emails = emails;
	}
	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Alumno(String dni, String nombre, ArrayList<Email> emails, ArrayList<Telefono> telefonos, Curso curso) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.emails = emails;
		this.telefonos = telefonos;
		this.curso = curso;
	}
	public Alumno() {
		super();
	}
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", emails=" + emails + ", telefonos=" + telefonos
				+ ", curso=" + curso + "]";
	}
	
	
}

