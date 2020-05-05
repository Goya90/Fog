package DBAccess;
import FunctionLayer.LoginSampleException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class DimensionMapper {

    //Returns the possible carport widths (in cm) from the database
    public static ArrayList<Integer> getWidthList() throws ClassNotFoundException, LoginSampleException {
        String sql = "SELECT width FROM fog.width;";
        ArrayList<Integer> widthList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    widthList.add(res.getInt("width"));
                }
            }
        } catch (SQLException ex) {
            throw new LoginSampleException( ex.getMessage() );
        }
        System.out.println(widthList);
        return widthList;
    }

    //Returns the possible carport lengths (in cm) from the database
    public static ArrayList<Integer> getLengthList() throws ClassNotFoundException, LoginSampleException {
        String sql = "SELECT * FROM fog.length;";
        ArrayList<Integer> lengthList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    lengthList.add(res.getInt("length"));
                }
            }
        } catch (SQLException ex) {
            throw new LoginSampleException( ex.getMessage() );
        }
        return lengthList;
    }

    //Returns the possible carport heights (in cm) from the database
    public static ArrayList<Integer> getHeightList() throws ClassNotFoundException, LoginSampleException {
        String sql = "SELECT * FROM fog.height;";
        ArrayList<Integer> heightList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    heightList.add(res.getInt("height"));
                }
            }
        } catch (SQLException ex) {
            throw new LoginSampleException( ex.getMessage() );
        }
        return heightList;
    }

    //Returns the possible shed lengths (in cm) from the database
    public static ArrayList<Integer> getShedLengthList() throws ClassNotFoundException, LoginSampleException {
        String sql = "SELECT * FROM fog.shedlength;";
        ArrayList<Integer> shedLengthList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    shedLengthList.add(res.getInt("shedLength"));
                }
            }
        } catch (SQLException ex) {
            throw new LoginSampleException( ex.getMessage() );
        }
        return shedLengthList;
    }

    //Returns the possible shed widths (in cm) from the database
    public static ArrayList<Integer> getShedWidthList() throws ClassNotFoundException, LoginSampleException {
        String sql = "SELECT * FROM fog.shedwidth;";
        ArrayList<Integer> shedWidthList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    shedWidthList.add(res.getInt("shedWidth"));
                }
            }
        } catch (SQLException ex) {
            throw new LoginSampleException( ex.getMessage() );
        }
        return shedWidthList;
    }

}
