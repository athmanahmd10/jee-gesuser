package servlets;

import java.io.IOException;
import java.util.ArrayList;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE_LIST_UTILISATEURS = "/WEB-INF/listUtilisateur.jsp";
	
	UtilisateurDao utilisateurs = new UtilisateurDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		boolean isDeleted = utilisateurs.deleteUser(id);
		
		if(isDeleted) {
			request.setAttribute("utilisateurs", utilisateurs.getUsers());
			request.getRequestDispatcher(VUE_LIST_UTILISATEURS).forward(request, response);
		}
	}
	
}