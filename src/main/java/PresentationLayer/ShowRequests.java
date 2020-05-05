package PresentationLayer;

import FunctionLayer.CustomerRequest;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ShowRequests extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ClassNotFoundException {

        HttpSession session = request.getSession();

        ArrayList<CustomerRequest> reqList = null;
        try {
            reqList = LogicFacade.newRequests();
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }

        request.setAttribute("reqlist", reqList);

        return "showRequests";
    }
}
