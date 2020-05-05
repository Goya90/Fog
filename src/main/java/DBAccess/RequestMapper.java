package DBAccess;

import FunctionLayer.CustomerRequest;
import FunctionLayer.LoginSampleException;

import java.sql.*;
import java.util.ArrayList;

public class RequestMapper {

    public static void createRequest(CustomerRequest request) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO cust_request (name, tel_no, email, comments, width,length,height,flatRoof,roofMaterial,shed_length," +
                    "shed_width,processed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, request.getName() );
            ps.setInt( 2, request.getTelno() );
            ps.setString( 3, request.getEmail() );
            ps.setString( 4, request.getComments() );
            ps.setInt( 5, request.getWidth() );
            ps.setInt( 6, request.getLength() );
            ps.setInt( 7, request.getHeight());
            ps.setBoolean(8, request.isFlatRoof());
            ps.setString( 9, request.getRoofMat() );
            ps.setInt(10, request.getShedl());
            ps.setInt( 11, request.getShedw() );
            ps.setBoolean(12,false);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            request.setReqId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
    public static ArrayList<CustomerRequest> showNewRequests() throws LoginSampleException {
        ArrayList<CustomerRequest> newRequestsList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cust_request where processed = false;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            CustomerRequest req = null;
            while (rs.next()) {
                int id = rs.getInt("reqId");
                String name = rs.getString("name");
                int tel = rs.getInt("tel_no");
                String email = rs.getString("email");
                String comments = rs.getString("comments");
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                boolean rooftype = rs.getBoolean("flatRoof");
                String material = rs.getString("roofMaterial");
                int shedl = rs.getInt("shed_length");
                int shedw = rs.getInt("shed_width");
                req = new CustomerRequest(id,name,tel,email,comments,width,length,height,rooftype,material,shedl,shedw);
                newRequestsList.add(req);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return newRequestsList;
    }

    public static ArrayList<CustomerRequest> showNewRequests2() throws LoginSampleException {
        ArrayList<CustomerRequest> newRequestsList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT name,email,width,length,height FROM cust_request;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            CustomerRequest req = null;
            while (rs.next()) {

                String name = rs.getString("name");
                String email = rs.getString("email");
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                req = new CustomerRequest(name,email,width,length,height);
                newRequestsList.add(req);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return newRequestsList;
    }

}
