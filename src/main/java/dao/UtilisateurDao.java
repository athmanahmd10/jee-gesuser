package dao;

import java.util.ArrayList;

import beans.Utilisateur;
import repository.UtilisateurRepository;

public class UtilisateurDao {

	private static ArrayList<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
	
	public UtilisateurDao() {
		
	}
	
	static {
		listeUtilisateurs.add(new Utilisateur(1, "soueid", "passer", "Mohamed", "ahmed"));
	}
	
	public ArrayList<Utilisateur> getUsers() {
		return UtilisateurRepository.getUsers();
	}
	
	public Utilisateur getUserById(int id) {
		return UtilisateurRepository.getUserById(id);
	}
	
	public boolean modifyUser(Utilisateur utilisateur) {
		return UtilisateurRepository.modifyUser(utilisateur);
	}
	
	public boolean deleteUser(int id) {
		return UtilisateurRepository.deleteUser(id);
	}
	
	public boolean addUser (Utilisateur utilisateur) {
		return UtilisateurRepository.addUser(utilisateur);
	}
	
	public int getLastId() {
		return listeUtilisateurs.size();
	}
	
}
