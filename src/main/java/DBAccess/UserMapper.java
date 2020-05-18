package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import PresentationLayer.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 Formålet med denne klasse er at oprette nye brugere i db tabellen users samt validere eksisterende brugere
 ved login i samme tabel. Ved fejl i userid/password eller forbindelse til database, returneres en fejlmeddelelse og
 fejlen logges.
 @author claes
 */
public class UserMapper {

    //Opretter et user objekt med parametrene email og password, derefter tilføjes parametren id som sql har tilføjet ved oprettelsen
    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.executeUpdate();
            int id;
            try (ResultSet ids = ps.getGeneratedKeys()) {
                ids.next();
                id = ids.getInt(1);
            }
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    //Returnerer et user objekt ud fra parametrene email og password, hvis disse findes i tabellen users.
    //Hvis brugeren med de givne credentials ikke findes, returneres en fejlmeddelelse. Hvis forbindelse
    //til db ikke findes, returneres en fejlmeddelelse. I begge tilfælde logges fejlen.
    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT userId FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                int id = rs.getInt( "userId" );
                User user = new User( email, password);
                user.setId( id );
                return user;
            } else {
                Log.info("Login "+"Could not validate user");
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            if (ex.getMessage().contains("Communications link failure")) {
                Log.severe("Login "+ ex.getMessage());
                throw new LoginSampleException("Databasen er nede, prøv igen senere");
            }
            Log.severe("Login"+ex.getMessage());
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
