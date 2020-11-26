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
		if (op.equals("inicio")) {
			
			ArrayList<Alumno> listaalumnos = new DaoAlumno().getAlumnos();
			
			session.setAttribute("listaalumnos", listaalumnos);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			
		}else if (op.equals("traeralumnos")) {
			String curso = String.valueOf(request.getParameter("curso"));
			ArrayList<Alumno> listaalumnos = new DaoAlumno().getAlumnos(curso);
			request.setAttribute("listaalumnos", listaalumnos);
			
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}
	}

		DaoAlumno daoalumno; 
		DaoCurso daocurso; 
		ArrayList<Alumno> listaalumnos; 
		ArrayList<Curso> listacursos; 
		Alumno alumno; 
		Curso objCurso; 
		String curso; 
		String nombre; 
		String dni; 
 
		if (op.equals("inicio")) { 
			 
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
			alumno.setAttribute("dni"); 
			alumno.setAttribute("nombre"); 
			alumno.setAttribute("curso"); 
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
			objCurso.setAttribute("curso"); 
			//insertar curso y volver a pedir la lista de cursos 
			daocurso.insertaCurso(objCurso); 
			listacursos = daocurso.getCursos(); 
			request.setAttribute("listacursos", listacursos); 
			dispatcher = request.getRequestDispatcher("index.jsp"); 
			dispatcher.forward(request, response); 
		} 


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
