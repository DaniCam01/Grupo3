package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.Curso;

public class DaoCurso {

	public ArrayList<Curso> getCursos(){
		ResultSet rs;
		ArrayList<Curso> lista = new ArrayList<Curso>();

		Connection con = Conexion.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT curso from curso";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				Curso curso = new Curso();
				curso.setCurso(rs.getString("curso"));

				lista.add(curso);
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