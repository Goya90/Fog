package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserMapperTest {
    public static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "root";
    private static String DBNAME = "fogtest?serverTimezone=CET&useSSL=false";
    private static String HOST = "localhost";

    @BeforeClass
    public static void setUp() {
        try {
            if (testConnection == null) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.cj.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                Connector.setConnection(testConnection);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }
    @Before
    public void beforeEachTest() {
        try (Statement stmt = testConnection.createStatement()) {
            stmt.execute("drop table if exists users");
            stmt.execute("CREATE TABLE `users` LIKE fog.users;");
            stmt.execute("insert into users VALUES" +
                    "(1, 'test', 'test')," +
                    "(2, 'admin','admin')");
        } catch (SQLException ex) {
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }


    }

    @Test
    public void testSetUpOK() {
        //checker, at forbindelsen er ok
        assertNotNull( testConnection );
    }
    @Test
    public void loginTest() throws LoginSampleException {
        //Tester, om vi kan logge ind
        User user = UserMapper.login( "test", "test" );
        assertTrue( user != null );
    }
    @Test( expected = LoginSampleException.class )
    public void loginTest2() throws LoginSampleException {
        //Tester, om der smides en exception, hvis kodeordet er forkert
        User user = UserMapper.login( "test", "forkertkode" );
    }


}
