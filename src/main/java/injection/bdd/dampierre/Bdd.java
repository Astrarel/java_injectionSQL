package injection.bdd.dampierre;

import java.sql.*;

public class Bdd {

    String url = "jdbc:mysql://localhost:3306/employer?useUnicode=true" + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + "serverTimezone=UTC";
    String user = "root";
    String passwd = "root";

    public Connection connexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion réussi !");
            return con;
        }

        catch (SQLException e) {
            System.out.println("Connexion échoué");
            return con;
        }
    }
}
