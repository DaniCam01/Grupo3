package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		RequestDispatcher dispatcher;

		DaoAlumno daoalumno; 
		DaoCurso daocurso; 
		DaoTelefono daotelefono;
		DaoEmail daoemail;
		ArrayList<alumno> listaalumnos; 
		ArrayList<Curso> listacursos; 
		alumno alumno; 
		Curso objCurso;
		Telefono objTelefono;
		Email objEmail; 
		String curso; 
		String nombre; 
		String dni;
		String telefono;
		String email; 
		Int exito;
 
		if (op.equals("inicio")) {
			curso = request.getParameter("curso"); 
			nombre = request.getParameter("nombre"); 
			ArrayList<alumno> listaalumnos = new DaoAlumno().getAlumnos(curso, nombre);
			ArrayList<Curso> listacursos= new DaoCurso.getCursos();

			session.setAttribute("listaalumnos", listaalumnos);
			session.setAttribute("listacursos", listacursos);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			 
		}else if (op.equals("traeralumnos")) { 
			//pedir curso y contenido de la barra del buscador 
			curso = request.getParameter("curso"); 
			nombre = request.getParameter("nombre"); 
			//lista de alumnos 
			listaalumnos = daoalumno.getAlumnos(curso, nombre); 
			request.setAttribute("listaalumnos", listaalumnos); 
			dispatcher = request.getRequestDispatcher("index.jsp"); 
			dispatcher.forward(request, response); 
			 
		}else if(op.equals("addalumno")){ 
			//dni, nombre y curso rellenado 
			dni = request.getParameter("dni"); 
			nombre = request.getParameter("nombre"); 
			curso = request.getParameter("curso"); 
			//aÃ±adirlo al objeto alumno 
			alumno.setDni(dni);
			alumno.setNombre(nombre);
			alumno.setCurso(curso);
			//aÃ±adir alumno a la lista y volver a pedir la lista de alumnos 
			daoalumno.insertaAlumno(alumno); 
			listaalumnos = daoalumno.getAlumnos(curso, nombre); 
			request.setAttribute("listaalumnos", listaalumnos); 
			dispatcher = request.getRequestDispatcher("index.jsp"); 
			dispatcher.forward(request, response); 
 
		}else if(op.equals("addcurso")){ 
			//curso rellenado 
			curso = request.getParameter("curso"); 
			//aÃ±adirlo al objeto curso 
			objCurso.setCurso(curso);
			//insertar curso y volver a pedir la lista de cursos 
			daocurso.insertaCurso(objCurso); 
			listacursos = daocurso.getCursos(); 
			request.setAttribute("listacursos", listacursos); 
			dispatcher = request.getRequestDispatcher("index.jsp"); 
			dispatcher.forward(request, response); 
			
		}else if(op.equals("addtelefono")){
			curso = request.getParameter("curso"); 
			nombre = request.getParameter("nombre");
			//rellenar Telefono 
			telefono = request.getParameter("telefono");//A veces en el DaoTelefeono se usa "tlf" en vez de "telefono", tengo que poner aquí "tlf"?
			dni = request.getParameter("dni"); 
			//añadirlo al objeto telefono
			objTelefono.setDni(dni);
			objTelefono.setTelefono(telefono);
			//insertar telefono y volver a pedir la lista 
			daotelefono.insertaTelefono(objTelefono);

			listaalumnos = daoalumno.getAlumnos(curso, nombre); 
			request.setAttribute("listacursos", listacursos); 
			dispatcher = request.getRequestDispatcher("index.jsp"); 
			dispatcher.forward(request, response); 

		}else if(op.equals("addemail")){
			curso = request.getParameter("curso"); 
			nombre = request.getParameter("nombre");
			//email rellenado 
			email = request.getParameter("email");
			dni = request.getParameter("dni"); 
			//aÃ±adirlo al objeto email
			objEmail.setDni(dni);
			objEmail.setEmail(email);
			//insertar email y volver a pedir la lista 
			daoemail.insertaEmail(objEmail);

			listaalumnos = daoalumno.getAlumnos(curso, nombre); 
			request.setAttribute("listacursos", listacursos); 
			dispatcher = request.getRequestDispatcher("index.jsp"); 
			dispatcher.forward(request, response); 
			
		}else if(op.equals("deletealumno")){
			//dni, nombre y curso rellenado 
			dni = request.getParameter("dni"); 
			nombre = request.getParameter("nombre"); //no sé si hacen también falta nombre y curso, yo por si acaso los pongo tambien
			curso = request.getParameter("curso"); 
			//add al objeto alumno 
			alumno.setDni(dni);
			alumno.setNombre(nombre);
			alumno.setCurso(curso);
			//Borrar alumno de lista y pedir lista 
			exito = daoalumno.borraAlumno(alumno);
			
			
			//Hace falta un exito en cada delete?
			/*if(exito!=-1){
				listaalumnos = daoalumno.getAlumnos(curso, nombre); 
				request.setAttribute("listacursos", listacursos); 
				dispatcher = request.getRequestDispatcher("index.jsp"); 
				dispatcher.forward(request, response); 
			}*/
			
		}else if(op.equals("deletetelefono")){
			
		}else if(op.equals("deleteemail")){
			curso = request.getParameter("curso"); // antes aquí ponía "urso" en vez de curso, supongo que Sara se equivocó
			nombre = request.getParameter("nombre");
			//email a borrar
			email = request.getParameter("email");
			dni = request.getParameter("dni"); 
			//aÃ±adirlo al objeto email
			objEmail.setDni(dni);
			objEmail.setEmail(email);
			//borrar y pedir la lista
			exito = daoemail.borraEmail(objEmail);

			// } 
			//hace falta aquí una llave o hay que poner la llave más abajo y por lo tanto un exito en cada delete?
			if(exito!=-1){
				listaalumnos = daoalumno.getAlumnos(curso, nombre); 
				request.setAttribute("listacursos", listacursos); 
				dispatcher = request.getRequestDispatcher("index.jsp"); 
				dispatcher.forward(request, response);
				
			     // si no se pone aquí o arriba una llave, da error.
			}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
