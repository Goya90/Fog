package DBAccess;

import FunctionLayer.CustomerRequest;
import FunctionLayer.LoginSampleException;

import java.sql.*;
import java.util.ArrayList;
/**
 The purpose of Requestmapper is to create new requests from drop-down and customer data entry
 as well as getting stored requests from DB.
 @author claes
 */

public class RequestMapper {

    //Enters a CustomerRequest object into DB
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

    //Creates and returns a list of unprocessed customerRequests from the database
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
    public static CustomerRequest getRequestFromID(int id) throws LoginSampleException {
        CustomerRequest req = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT width,length,height,flatRoof,roofMaterial,shed_length,shed_width FROM cust_request where reqId = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, "" + id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int width = rs.getInt("width");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                boolean flatRoof = rs.getBoolean("flatRoof");
                String material = rs.getString("roofMaterial");
                int shedlength = rs.getInt("shed_length");
                int shedwidth = rs.getInt("shed_width");
                req = new CustomerRequest(width,length,height,flatRoof,material,shedlength,shedwidth);

            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return req;
    }

    public static void processRequest(double price, int id) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE cust_request SET processed = true, price = ? where reqId = ?;";
            PreparedStatement ps = con.prepareStatement( SQL );
            //ps.setInt(1,id);
            ps.setDouble(1,price);
            ps.setInt(2,id);
            ps.executeUpdate();

        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }


    }
    //Does the same as new requests, exept that it gets done requests
    public static ArrayList<CustomerRequest> showDoneRequests() throws LoginSampleException {
        ArrayList<CustomerRequest> newDoneRequestsList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cust_request where processed = true;";
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
                req = new CustomerRequest(id, name, tel, email, comments, width, length, height, rooftype, material, shedl, shedw);
                newDoneRequestsList.add(req);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

        return newDoneRequestsList;
    }


}
