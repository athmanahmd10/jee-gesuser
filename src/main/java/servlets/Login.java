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

@WebServlet("/login")
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE_CONNEXION = "/WEB-INF/connexion.jsp";
	public static final String VUE_WELCOME = "/WEB-INF/welcome.jsp";
	
	UtilisateurDao utilisateurs = new UtilisateurDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("message", "veuillez remplirer tous les champs");
		request.getRequestDispatcher(VUE_CONNEXION).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String login = request.getParameter("login");
			String password = request.getParameter("password");
			Boolean connected =false;
			ArrayList<Utilisateur> listUtilisateurs = utilisateurs.getUsers();
			
			if("admin".equals(login) && "passer".equals(password)) {
				request.setAttribute("profil", "admin");
				request.getRequestDispatcher(VUE_WELCOME).forward(request, response);
			}else {
				for (int i =0; i <listUtilisateurs.size(); i++) {
					if(listUtilisateurs.get(i).getLogin().equals(login) && 
							listUtilisateurs.get(i).getPassword().equals(password)) {
						connected =true;
						request.setAttribute("profil", "simple");
						request.getRequestDispatcher(VUE_WELCOME).forward(request, response);
					}
				}
				
				if(!connected) {
					request.setAttribute("message", "Les identifiants sont icorrects !!!");
					request.getRequestDispatcher(VUE_CONNEXION).forward(request, response);
				}
			}
			
			

		} catch (Exception e) {
			response.getWriter().print("veuillez rensegner vos indentifiant");
			request.getRequestDispatcher(VUE_CONNEXION).forward(request, response);
		}

	}

}