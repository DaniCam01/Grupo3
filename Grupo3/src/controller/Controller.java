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
        // TODO Auto-generated constructor stub
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
