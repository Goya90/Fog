package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Formålet med denne klasse er at ændre status på et CustomerRequest i db fra ikke-behandlet
 * til færdiggjort. Efter ændring sendes brugeren tilbage til admin web siden.
 */

public class MarkAsDone extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ClassNotFoundException {

        int id = (int) request.getServletContext().getAttribute("reqID");

        double price = (double) request.getServletContext().getAttribute("total");

        LogicFacade.updateRequest(price,id);

        return "adminpage";
    }
}
