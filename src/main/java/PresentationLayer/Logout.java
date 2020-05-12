package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        session.invalidate();

        request.getServletContext().setAttribute("width", null);
        request.getServletContext().setAttribute("length", null);
        request.getServletContext().setAttribute("height", null);
        request.getServletContext().setAttribute("roofMaterial", null);
        request.getServletContext().setAttribute("shedWidth", null);
        request.getServletContext().setAttribute("shedLength", null);

        return "index";
    }

}