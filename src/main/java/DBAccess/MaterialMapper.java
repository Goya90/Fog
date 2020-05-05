package DBAccess;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialMapper {

    /*public static ArrayList<Material> getMaterials() throws ClassNotFoundException, LoginSampleException {
        String sql = "SELECT * FROM fog.materials;";
        //Der skal ændres i SQL-statementet
        ArrayList<Material> materialList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    materialList.add(new Material(res.getInt("materialID"), res.getString("materialName"),
                            res.getString("materialUnit"), res.getString("materialDescription")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materialList;
    }
    */
    //returns a material object from db using the material id
    public static Material getMaterial(int materialId) throws ClassNotFoundException, LoginSampleException {
        String sql = "SELECT * FROM fog.materials WHERE materialId = ?;";
        //Der skal ændres i SQL-statementet
        Material material = new Material();
        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, materialId);
            ResultSet res = pstmt.executeQuery();
            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    material.setId(res.getInt("materialId"));
                    material.setCategory(res.getString("category"));
                    material.setName(res.getString("name"));
                    material.setDescription(res.getString("description"));
                    material.setPrice(res.getDouble("price"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return material;
    }

    //Returns material names only for carports with flat roof, from database
    public static ArrayList<String> getFlatRoofMaterialList() throws ClassNotFoundException, LoginSampleException {
        String sql = "SELECT * FROM fog.roofmaterial where flatRoof = true;";
        ArrayList<String> RoofMaterialList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    RoofMaterialList.add(res.getString("roofmaterial"));
                }
            }
        } catch (SQLException ex) {
            throw new LoginSampleException( ex.getMessage() );
        }
        return RoofMaterialList;
    }

    //Returns material names only for carports with slanted roof, from database
    public static ArrayList<String> getSlantedRoofMaterialList() throws ClassNotFoundException, LoginSampleException {
        String sql = "SELECT * FROM fog.roofmaterial WHERE flatRoof = false;";
        ArrayList<String> RoofMaterialList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    RoofMaterialList.add(res.getString("roofmaterial"));
                }
            }
        } catch (SQLException ex) {
            throw new LoginSampleException( ex.getMessage() );
        }
        return RoofMaterialList;
    }

    //Returns material names for either flat or slanted roof, depending on flat roof true or false
    public static ArrayList<String> getRoofMaterials(boolean roof) throws ClassNotFoundException, LoginSampleException {
        ArrayList<String> RoofMaterialList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM fog.roofmaterial WHERE flatRoof = ?;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setBoolean(1,roof);
            ResultSet res = pstmt.executeQuery();
            if (res == null) {
                return null;
            } else {
                while (res.next()) {
                    RoofMaterialList.add(res.getString("roofmaterial"));
                }
            }
        } catch (SQLException ex) {
            throw new LoginSampleException( ex.getMessage() );
        }
        return RoofMaterialList;
    }
}