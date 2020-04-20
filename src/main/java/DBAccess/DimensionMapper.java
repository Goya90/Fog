package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DimensionMapper {

    public static ArrayList<Integer> getWidthList() throws ClassNotFoundException, LoginSampleException {

        String sql = "SELECT * FROM fog.width;";
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

        return widthList;

    }

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

}
