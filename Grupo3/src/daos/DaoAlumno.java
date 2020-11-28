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
		ResultSet rs;
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		ArrayList<Telefono> listaTelefonos;
		ArrayList<Email> listaEmails;
		Curso cursoAlumno;
		Telefono telefono;
		Alumno alumno;
		Email email;
		
		Connection con = Conexion.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT dni , nombre , curso from alumno where nombre like '%"+nombre+"%' and curso like '%"+curso+"%'";
			rs = st.executeQuery(ordenSql);
			
			while (rs.next()) {	
				alumno = new Alumno();
				listaTelefonos = new ArrayList<Telefono>();
				listaEmails = new ArrayList<Email>();
				
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setCurso(new Curso(rs.getString("curso")));
				
				
				//Telefonos
				listaTelefonos = obtenerTelefonoAlumno(alumno.getDni());
				alumno.setTelefonos(listaTelefonos);
				
				
				listaEmails = obtenerEmailAlumno(alumno.getDni());
				alumno.setEmails(listaEmails);
				
				System.out.println(alumno);
				lista.add(alumno);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs Alumno: " + e.getMessage());
		}
		return lista;
	}
	
	public ArrayList<Email> obtenerEmailAlumno(String dni)
	{
		ResultSet rs;
		ArrayList<Email> lista = new ArrayList<Email>();

		Connection con = Conexion.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT dni, email from emilio where dni ='"+dni+"'";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				Email email = new Email();
				email.setDni(rs.getString("dni"));
				email.setEmail(rs.getString("email"));

				lista.add(email);
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
	
		public ArrayList<Telefono> obtenerTelefonoAlumno(String dni)
		{
			ResultSet rs;
			ArrayList<Telefono> lista = new ArrayList<Telefono>();

			Connection con = Conexion.conecta();
			Statement st;
			try {
				st = con.createStatement();
				String ordenSql = "SELECT dni, tlf from telefono where dni ='"+dni+"'";
				rs = st.executeQuery(ordenSql);

				while (rs.next()) {
					Telefono telefono = new Telefono();
					telefono.setDni(rs.getString("dni"));
					telefono.setTlf(rs.getString("tlf"));

					lista.add(telefono);
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
