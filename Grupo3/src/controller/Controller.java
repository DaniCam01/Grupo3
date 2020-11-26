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
		DaoEmail daoemail;
		ArrayList<Alumno> listaalumnos; 
		ArrayList<Curso> listacursos; 
		Alumno alumno; 
		Curso objCurso;
		Email objEmail; 
		String curso; 
		String nombre; 
		String dni;
		String email; 
		Int exito;
 
		if (op.equals("inicio")) {
			curso = request.getParameter("curso"); 
			nombre = request.getParameter("nombre"); 
			ArrayList<Alumno> listaalumnos = new DaoAlumno().getAlumnos(curso, nombre);
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
			//añadirlo al objeto alumno 
			alumno.setDni(dni);
			alumno.setNombre(nombre);
			alumno.setCurso(curso);
			//añadir alumno a la lista y volver a pedir la lista de alumnos 
			daoalumno.insertaAlumno(alumno); 
			listaalumnos = daoalumno.getAlumnos(curso, nombre); 
			request.setAttribute("listaalumnos", listaalumnos); 
			dispatcher = request.getRequestDispatcher("index.jsp"); 
			dispatcher.forward(request, response); 
 
		}else if(op.equals("addcurso")){ 
			//curso rellenado 
			curso = request.getParameter("curso"); 
			//añadirlo al objeto curso 
			objCurso.setCurso(curso);
			//insertar curso y volver a pedir la lista de cursos 
			daocurso.insertaCurso(objCurso); 
			listacursos = daocurso.getCursos(); 
			request.setAttribute("listacursos", listacursos); 
			dispatcher = request.getRequestDispatcher("index.jsp"); 
			dispatcher.forward(request, response); 
		}else if(op.equals("addtelefono")){

		}else if(op.equals("addemail")){
			curso = request.getParameter("curso"); 
			nombre = request.getParameter("nombre");
			//email rellenado 
			email = request.getParameter("email");
			dni = request.getParameter("dni"); 
			//añadirlo al objeto email
			objEmail.setDni(dni);
			objEmail.setEmail(email);
			//insertar email y volver a pedir la lista 
			daoemail.insertaEmail(objEmail);

			listaalumnos = daoalumno.getAlumnos(curso, nombre); 
			request.setAttribute("listacursos", listacursos); 
			dispatcher = request.getRequestDispatcher("index.jsp"); 
			dispatcher.forward(request, response); 
		}else if(op.equals("deletealumno")){
			
		}else if(op.equals("deletetelefono")){
			
		}else if(op.equals("deleteemail")){
			urso = request.getParameter("curso"); 
			nombre = request.getParameter("nombre");
			//email a borrar
			email = request.getParameter("email");
			dni = request.getParameter("dni"); 
			//añadirlo al objeto email
			objEmail.setDni(dni);
			objEmail.setEmail(email);
			//borrar y pedir la lista
			exito = daoemail.borraEmail(objEmail);

			if(exito!=-1){
				listaalumnos = daoalumno.getAlumnos(curso, nombre); 
				request.setAttribute("listacursos", listacursos); 
				dispatcher = request.getRequestDispatcher("index.jsp"); 
				dispatcher.forward(request, response); 
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
