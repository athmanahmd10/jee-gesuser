package repository;
import java.sql.*;
import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurRepository {

    // Méthode pour récupérer la liste des utilisateurs
    public static ArrayList<Utilisateur> getUsers() {
        ArrayList<Utilisateur> dataList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBManager.getConnection();

            // Créer une déclaration SQL
            statement = connection.createStatement();

            // Exécuter une requête SQL pour sélectionner tous les éléments de la table
            String query = "SELECT * FROM users";
            resultSet = statement.executeQuery(query);

            // Parcourir le résultat et ajouter chaque élément à la liste
            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
            	String firstName = resultSet.getString("prenom");
            	String lastName = resultSet.getString("nom");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                Utilisateur utilisateur = new Utilisateur(id, login, password, lastName, firstName);
                dataList.add(utilisateur);
            }
        } catch (SQLException e) {
            System.out.println("Erreur : Impossible de se connecter à la base de données ou de récupérer les données !");
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture des ressources !");
                e.printStackTrace();
            }
        }

        return dataList;
    }
    
    // Méthode pour récupérer les éléments de la table et les mettre dans une liste
    public static Utilisateur getUserById(int userId) {
        ArrayList<Utilisateur> dataList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;

        try {
            connection = DBManager.getConnection();

            // Créer une déclaration SQL
            statement = connection.createStatement();

            // Exécuter une requête SQL pour sélectionner tous les éléments de la table
            String query = "SELECT * FROM users WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            // Exécuter la requête SQL
            resultSet = preparedStatement.executeQuery();

            // Récupérer les informations de l'utilisateur
            if (resultSet.next()) {
            	int id = resultSet.getInt("id");
            	String firstName = resultSet.getString("prenom");
            	String lastName = resultSet.getString("nom");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                utilisateur = new Utilisateur(id, login, password, lastName, firstName);
            }
        } catch (SQLException e) {
            System.out.println("Erreur : Impossible de se connecter à la base de données ou de récupérer les données !");
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture des ressources !");
                e.printStackTrace();
            }
        }

        return utilisateur;
    }
    
    // Méthode qui permet de modifier  un utilisateur en fonction de l'id
    public static boolean modifyUser(Utilisateur utilisateur) {

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBManager.getConnection();



         // Requête SQL pour mettre à jour l'utilisateur en fonction de son ID
            String query = "UPDATE users SET nom = ?, prenom = ?, login = ?, password = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getLogin());
            preparedStatement.setString(4, utilisateur.getPassword());
            preparedStatement.setInt(5, utilisateur.getId());

            // Exécuter la requête SQL
            int rowsAffected = preparedStatement.executeUpdate();

            // Vérifier si la mise à jour a été effectuée avec succès
            if (rowsAffected > 0) {
                System.out.println("L'utilisateur avec l'ID " + utilisateur.getId() + " a été modifié avec succès !");
                return true;
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID spécifié !");
            }
        } catch (SQLException e) {
            System.out.println("Erreur : Impossible de se connecter à la base de données ou de récupérer les données !");
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture des ressources !");
                e.printStackTrace();
            }
        }

        return false;
    }
    
    // Méthode qui permet de modifier  un utilisateur en fonction de l'id
    public static boolean deleteUser(int userId) {

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBManager.getConnection();



            // Requête SQL pour supprimer l'utilisateur en fonction de son ID
            String query = "DELETE FROM users WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            // Exécuter la requête SQL
            int rowsAffected = preparedStatement.executeUpdate();

            // Vérifier si la mise à jour a été effectuée avec succès
            if (rowsAffected > 0) {
                System.out.println("L'utilisateur avec l'ID " + userId + " a été supprimé avec succès !");
                return true;
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID spécifié !");
            }
        } catch (SQLException e) {
            System.out.println("Erreur : Impossible de se connecter à la base de données ou de récupérer les données !");
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture des ressources !");
                e.printStackTrace();
            }
        }

        return false;
    }
    
    // Méthode qui permet d'ajouter un utilisateur
    public static boolean addUser(Utilisateur utilisateur) {

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBManager.getConnection();



            // Requête SQL pour insérer un nouvel utilisateur
            String query = "INSERT INTO users (nom, prenom, login, password) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getLogin());
            preparedStatement.setString(4, utilisateur.getPassword());
            
            // Exécuter la requête SQL
            int rowsAffected = preparedStatement.executeUpdate();

            // Vérifier si l'ajout a été effectué avec succès
            if (rowsAffected > 0) {
                System.out.println("Nouvel utilisateur ajouté avec succès !");
                return true;
            } else {
                System.out.println("Échec de l'ajout de l'utilisateur !");
            }
        } catch (SQLException e) {
            System.out.println("Erreur : Impossible de se connecter à la base de données ou de récupérer les données !");
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture des ressources !");
                e.printStackTrace();
            }
        }

        return false;
    }

    
    
    public static void main(String[] args) {
       Utilisateur utilisateur = new Utilisateur(3, "bobbrown", "pass123", "Brown", "Bobby");
       
       System.out.println(modifyUser(utilisateur));
    }
}
