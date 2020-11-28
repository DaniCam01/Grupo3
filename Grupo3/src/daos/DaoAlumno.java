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
				ResultSet rst;
				ArrayList<Telefono> listaT = new ArrayList<Telefono>();
				Statement stt;
				try {
					stt = con.createStatement();
					String ordenSqlT = "SELECT dni, email from emilio where dni ='"+alumno.getDni()+"'";
					rst = stt.executeQuery(ordenSqlT);

					while (rst.next()) {
						telefono = new Telefono();
						telefono.setDni(rst.getString("dni"));
						telefono.setTlf(rst.getString("tlf"));

						listaT.add(telefono);
					}
					rst.close();
					stt.close();
				} catch (SQLException e) {
					System.out.println("Error al acceder a la BDs: " + e.getMessage());
				}
				alumno.setTelefonos(listaT);
				//-------------------------------------------
				
				
				//Emails
				ResultSet rse;
				ArrayList<Email> listaE = new ArrayList<Email>();
				Statement ste;
				try {
					ste = con.createStatement();
					String ordenSqlE = "SELECT dni, email from emilio where dni ='"+alumno.getDni()+"'";
					rse = ste.executeQuery(ordenSqlE);

					while (rse.next()) {
						email = new Email();
						email.setDni(rse.getString("dni"));
						email.setEmail(rse.getString("email"));

						listaE.add(email);
					}
					rse.close();
					ste.close();
				} catch (SQLException e) {
					System.out.println("Error al acceder a la BDs: " + e.getMessage());
				}
				alumno.setEmails(listaE);
				//------------------------------------
				
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
			
	//Insert
		public void insertaAlumno(Alumno alumno) {
			Connection con = new Conexion().conecta();
			try {
				String ordenSQL;
				ordenSQL = "insert into alumno values(?,?,?)";
				PreparedStatement st = con.prepareStatement(ordenSQL);
				st.setString(1, alumno.getDni());
				st.setString(2, alumno.getNombre());
				st.setString(3, alumno.getCurso().getCurso());
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

