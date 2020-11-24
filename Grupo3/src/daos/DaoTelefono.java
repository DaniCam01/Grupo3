package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Alumno;
import model.Telefono;

public class DaoTelefono {

	public ArrayList<Telefono> getTelefonos(Alumno alumno){
		ResultSet rs;
		ArrayList<Telefono> lista = new ArrayList<Telefono>();

		Connection con = Conexion.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT dni, tlf from telefono where dni = '"+alumno.getDni()+"'";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				Telefono telefono = new Telefono();
				telefono.setTlf(rs.getString("tlf"));
				telefono.setDni(rs.getString("dni"));

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
	public void insertaTelefono(Telefono telefono) {
		Connection con = new Conexion().conecta();
		try {
			String ordenSQL;
			ordenSQL = "insert into telefono values(?,?)";
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, telefono.getDni());
			st.setString(2, telefono.getTlf());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
		}
	}

	
	
	//Delete
	public int borraTelefono(Telefono telefono) {
		int borrados=-1;
		Connection con = new Conexion().conecta();
		String ordenSQL = "delete from telefono where tlf=? and dni=?";
		try {
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1,telefono.getTlf());
			st.setString(2,telefono.getDni());
			borrados = st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al eliminar datos en la BDs: " + e.getMessage());
		}
		return borrados;
	}

}
