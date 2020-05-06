package DBAccess;

import FunctionLayer.CustomerRequest;
import FunctionLayer.LoginSampleException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class RequestMapperTest {

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
            stmt.execute("drop table if exists cust_request");
            stmt.execute("CREATE TABLE cust_request LIKE fog.cust_request;");
            stmt.execute("insert into cust_request VALUES" +
                    "(1, 'Ole Olsen', 11223344, 'ole@gmail.com','', 2400,2800,2000, true, 'Plastmo sort', null, null, false)," +
                    "(2, 'Per Jensen', 99887766, 'per@gmail.com','', 4400, 3800, 2200, false, 'Tagsten sort', 2800, 2400, false)");

        } catch (SQLException ex) {
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }
    @Test
    public void testSetUpOK() {
        //Checker forbindelsen
        assertNotNull(testConnection);
    }

    @Test //Tester, at der kan oprettes en ny customer request, og at antallet af customer requests på arraylisten stemmer overens
    public void createReqTest() throws LoginSampleException {
        CustomerRequest cr = new CustomerRequest("Bente Hansen", 11223344, "bente@bentemail.com", "Kan taget være rødt?",2400, 3000, 2200, false, "Tagsten sort", 0, 0);
        RequestMapper.createRequest(cr);
        ArrayList<CustomerRequest> reqList = RequestMapper.showNewRequests();
        assertThat(reqList, hasSize(3));
    }

}