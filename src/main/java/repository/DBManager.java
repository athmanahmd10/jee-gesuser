package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    public static Connection getConnection () {
        Connection connection = null;

        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL de connexion à la base de données MySQL
            String url = "jdbc:mysql://localhost:3306/jeedb";

            // Nom d'utilisateur et mot de passe pour la connexion à la base de données
            String username = "abdallahi";
            String password = "password";

            // Établir la connexion à la base de données
            connection = DriverManager.getConnection(url, username, password);

            // Vérifier si la connexion est réussie
            if (connection != null) {
                System.out.println("Connexion à la base de données réussie !");
                return connection;
                // Vous pouvez maintenant effectuer des opérations sur la base de données
            } else {
            	System.out.println("Échec de la connexion à la base de données !");
            	return null;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Pilote JDBC introuvable !");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Erreur : Impossible de se connecter à la base de données !");
            e.printStackTrace();
            return null;
        }
    }
}
