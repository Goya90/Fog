package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessRequest extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ClassNotFoundException {

        int id = (int) request.getServletContext().getAttribute("reqID");

        double price = (double) request.getServletContext().getAttribute("total");

        LogicFacade.updateRequest(price,id);

        return "adminpage";
    }
}
