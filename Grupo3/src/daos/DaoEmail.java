package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Alumno;
import model.Email;

public class DaoEmail {

	public ArrayList<Email> getEmails(Alumno alumno){
		ResultSet rs;
		ArrayList<Email> lista = new ArrayList<Email>();

		Connection con = Conexion.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT dni, email from emilio where dni = '"+alumno.getDni()+"'";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				Email email = new Email();
				email.setEmail(rs.getString("email"));
				email.setDni(rs.getString("dni"));

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
	
	//insert
	public void insertaEmail(Email email) {
		Connection con = new Conexion().conecta();
		try {
			String ordenSQL;
			ordenSQL = "insert into emilio values(?,?)";
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, email.getDni());
			st.setString(2, email.getEmail());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
		}
	}
	
	//Delete
		public int borraEmail(Email email) {
			int borrados=-1;
			Connection con = new Conexion().conecta();
			String ordenSQL = "delete from emilio where email=? and dni=?";
			try {
				PreparedStatement st = con.prepareStatement(ordenSQL);
				st.setString(1,email.getEmail());
				st.setString(2,email.getDni());
				borrados = st.executeUpdate();
				st.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al eliminar datos en la BDs: " + e.getMessage());
			}
			return borrados;
		}
}
