package PresentationLayer;

import FunctionLayer.CustomerRequest;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ShowRequests extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ClassNotFoundException {

        HttpSession session = request.getSession();

        ArrayList<CustomerRequest> reqList = null; //creates a list of CustomerRequests to be shown on the jsp
        try {
            reqList = LogicFacade.showRequests(false); //Enters the unhandled requests selected from db into the list
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }

        request.setAttribute("reqlist", reqList);//Sets the attribute "reqlist" on jsp to the list created above

        //Sends the user to the jsp showing unhandled requests
        return "showRequests";
    }
}
