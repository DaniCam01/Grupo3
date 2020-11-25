package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public ArrayList<Alumno> getAlumnos(String curso, String nombre){
		ResultSet rs, re, rt;
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		ArrayList<Telefono> listaTelefonos;
		ArrayList<Email> listaEmails;
		Curso cursoAlumno;
		
		Connection con = Conexion.conecta();
		Statement st, stt, ste;
		try {
			st = con.createStatement();
			String ordenSql = "select * from alumno where nombre like '%"+nombre+"%' and curso like '%"+curso+"%'";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {	
				Alumno alumno = new Alumno();
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				cursoAlumno = new Curso(rs.getString("curso"));
				alumno.setCurso(cursoAlumno);
				//Telefonos
				listaTelefonos = new ArrayList<Telefono>();
				stt = con.createStatement();
				ordenSql = "select * from telefono where dni = '"+alumno.getDni()+"'";
				rt = st.executeQuery(ordenSql);
				while (rt.next()) {
					Telefono telefono = new Telefono();
					telefono.setDni(alumno.getDni());
					telefono.setTlf(rs.getNString("tlf"));
					listaTelefonos.add(telefono);
				}
				rt.close();
				stt.close();
				alumno.setTelefonos(listaTelefonos);
				
				listaEmails = new ArrayList<Email>();
				ste = con.createStatement();
				ordenSql = "select * from emilio where dni = '"+alumno.getDni()+"'";
				re = st.executeQuery(ordenSql);
				while (rt.next()) {
					Email email = new Email();
					email.setDni(alumno.getDni());
					email.setEmail(rs.getNString("email"));
					listaEmails.add(email);
				}
				re.close();
				ste.close();
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
	
	//Insert
		public void insertaAlumno(Alumno alumno) {
			Connection con = new Conexion().conecta();
			try {
				String ordenSQL;
				ordenSQL = "insert into alumno values(?,?,?)";
				PreparedStatement st = con.prepareStatement(ordenSQL);
				st.setString(1, alumno.getDni());
				st.setString(2, alumno.getNombre());
				st.setString(2, alumno.getCurso().getCurso());
				st.executeUpdate();
				st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
			}
		}
		
		//Delete
		public int borraAlumno(Alumno alumno) {
			int borrados=-1;
			Connection con = new Conexion().conecta();
			String ordenSQL = "delete from alumno where dni = ?";
			try {
				PreparedStatement st = con.prepareStatement(ordenSQL);
				st.setString(1,alumno.getDni());
				borrados = st.executeUpdate();
				st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al eliminar datos en la BDs: " + e.getMessage());
			}
			return borrados;
		}
	
}
