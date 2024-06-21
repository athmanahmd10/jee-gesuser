package servlets;

import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adduser")
public class Ajouter extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE_AJOUT_UTILISATEURS = "/WEB-INF/ajoutUtilisateur.jsp";
	public static final String VUE_LIST_UTILISATEURS = "/WEB-INF/listUtilisateur.jsp";
	
	UtilisateurDao utilisateurs = new UtilisateurDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("utilisateurs", utilisateurs.getUsers());
		request.getRequestDispatcher(VUE_AJOUT_UTILISATEURS).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String firstname = request.getParameter("firstname");
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			int lastId = utilisateurs.getLastId();
			
			Utilisateur user = new Utilisateur(login, password, name, firstname);
			boolean addedUser = utilisateurs.addUser(user);
			
			if(addedUser) {
				request.setAttribute("utilisateurs", utilisateurs.getUsers());
				request.getRequestDispatcher(VUE_LIST_UTILISATEURS).forward(request, response);
			}
			
			

		} catch (Exception e) {
			response.getWriter().print("veuillez rensegner vos indentifiant");
			request.getRequestDispatcher(VUE_AJOUT_UTILISATEURS).forward(request, response);
		}

	}
}