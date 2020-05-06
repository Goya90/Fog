package FunctionLayer;

import DBAccess.DimensionMapper;
import DBAccess.MaterialMapper;
import DBAccess.RequestMapper;
import DBAccess.UserMapper;
import PresentationLayer.Request;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    }

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password);
        UserMapper.createUser( user );
        return user;
    }

    public static ArrayList<Integer> showWidths() throws LoginSampleException, ClassNotFoundException {
        return DimensionMapper.getWidthList();
    }

    public static ArrayList<Integer> showLengths() throws LoginSampleException, ClassNotFoundException {
        return DimensionMapper.getLengthList();
    }

    public static ArrayList<Integer> showHeights() throws LoginSampleException, ClassNotFoundException {
        return DimensionMapper.getHeightList();
    }

    public static ArrayList<String> showFlatRoofMaterialList() throws LoginSampleException, ClassNotFoundException {
        return MaterialMapper.getFlatRoofMaterialList();
    }

    public static ArrayList<String> showSlantedRoofMaterialList() throws LoginSampleException, ClassNotFoundException {
        return MaterialMapper.getSlantedRoofMaterialList();
    }

    public static Material showMaterial(int materialId) throws LoginSampleException, ClassNotFoundException {
        return MaterialMapper.getMaterial(materialId);
    }

    public static ArrayList<String> showRoofMaterialList(boolean flat) throws LoginSampleException, ClassNotFoundException {
        return MaterialMapper.getRoofMaterials(flat);
    }

    public static ArrayList<Integer> showShedLengths() throws LoginSampleException, ClassNotFoundException {
        return DimensionMapper.getShedLengthList();
    }
    public static ArrayList<Integer> showShedWidths() throws LoginSampleException, ClassNotFoundException {
        return DimensionMapper.getShedWidthList();
    }
    public static void createRequest(CustomerRequest request) throws LoginSampleException {
        RequestMapper.createRequest(request);
    }
    public static ArrayList<CustomerRequest> newRequests() throws LoginSampleException {
        return RequestMapper.showNewRequests();
    }
    public static CustomerRequest showRequest(int id) throws LoginSampleException {
        return RequestMapper.getRequestFromID(id);
    }
    public static void updateRequest(double price, int id) throws LoginSampleException {
        RequestMapper.processRequest(price,id);
    }
}