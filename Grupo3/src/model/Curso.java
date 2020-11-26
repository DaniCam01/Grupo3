package model;

public class Curso {
	private String curso;

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Curso(String curso) {
		super();
		this.curso = curso;
	}

	public Curso() {
		super();
	}

	@Override
	public String toString() {
		return "Curso [curso=" + curso + "]";
	}
	
	
}

