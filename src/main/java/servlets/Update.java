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

@WebServlet("/update")
public class Update extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UtilisateurDao utilisateurs = new UtilisateurDao();
	public static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/ajoutUtilisateur.jsp";
	public static final String VUE_LIST_UTILISATEURS = "/WEB-INF/listUtilisateur.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Utilisateur> listUtilisateurs = utilisateurs.getUsers();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Utilisateur utilisateur = utilisateurs.getUserById(id);
		
		if(utilisateur != null) {
			request.setAttribute("utilisateur", utilisateur);
			request.getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
		}
		for (int i =0; i <listUtilisateurs.size(); i++) {
			if(listUtilisateurs.get(i).getId() == id ) {
				listUtilisateurs.remove(i);
				request.getRequestDispatcher("/lister").forward(request, response);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("lastname");
			String firstname = request.getParameter("firstname");
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			Utilisateur utilisateur = new Utilisateur(id, login, password, name, firstname);
			boolean isModified = utilisateurs.modifyUser(utilisateur);
			
			if(isModified) {
				request.setAttribute("utilisateurs", utilisateurs.getUsers());
				request.getRequestDispatcher(VUE_LIST_UTILISATEURS).forward(request, response);
			}
			
			

		} catch (Exception e) {
			response.getWriter().print("veuillez rensegner vos indentifiant");
			request.getRequestDispatcher(VUE_LIST_UTILISATEURS).forward(request, response);
		}

	}
	
}