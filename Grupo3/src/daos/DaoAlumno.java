package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Alumno;
import model.Curso;
import model.Email;
import model.Telefono;

public class DaoAlumno {

	@SuppressWarnings("resource")
	public ArrayList<Alumno> getAlumnos(Curso curso, String nombre){
		ResultSet rs;
		ResultSet rt;
		ResultSet re;
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		ArrayList<Telefono> listaTelefonos;
		ArrayList<Email> listaEmails;
		Curso cursoAlumno;
		
		Connection con = Conexion.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select * from alumno where nombre like '%"+nombre+"%' and curso like '%"+curso.getCurso()+"%'";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {	
				Alumno alumno = new Alumno();
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				cursoAlumno = new Curso(rs.getString("curso"));
				alumno.setCurso(cursoAlumno);
				
				listaTelefonos = new ArrayList<Telefono>();
				ordenSql = "select * from telefono where dni = '"+alumno.getDni()+"'";
				rt = st.executeQuery(ordenSql);
				while (rt.next()) {
					Telefono telefono = new Telefono();
					telefono.setDni(alumno.getDni());
					telefono.setTlf(rs.getNString("tlf"));
					listaTelefonos.add(telefono);
				}
				alumno.setTelefonos(listaTelefonos);
				
				listaEmails = new ArrayList<Email>();
				ordenSql = "select * from emilio where dni = '"+alumno.getDni()+"'";
				rt = st.executeQuery(ordenSql);
				while (rt.next()) {
					Email email = new Email();
					email.setDni(alumno.getDni());
					email.setEmail(rs.getNString("email"));
					listaEmails.add(email);
				}
				alumno.setEmails(listaEmails);
				
				lista.add(alumno);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out
					.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return lista;
	}
	
}
