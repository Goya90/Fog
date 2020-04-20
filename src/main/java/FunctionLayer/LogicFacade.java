package FunctionLayer;

import DBAccess.DimensionMapper;
import DBAccess.UserMapper;

import java.sql.SQLException;
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
        User user = new User(email, password, "customer");
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

}
