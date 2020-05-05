package PresentationLayer;

import FunctionLayer.CustomerRequest;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Request extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ClassNotFoundException {

        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        int length = Integer.parseInt(request.getParameter("length"));
        boolean flatRoof = Boolean.parseBoolean(request.getParameter("flatRoof"));
        String roofMaterial = request.getParameter("roofMaterial");
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        String name = request.getParameter("name");
        int telno = Integer.parseInt(request.getParameter("telno"));
        String mail = request.getParameter("mail");
        String comments = request.getParameter("comments");

        CustomerRequest custreq = new CustomerRequest(name,telno,mail,comments,width,length,height,flatRoof,roofMaterial,shedLength,shedWidth);

        LogicFacade.createRequest(custreq);

        request.getServletContext().setAttribute("width", width);
        request.getServletContext().setAttribute("height", height);
        request.getServletContext().setAttribute("length", length);
        request.getServletContext().setAttribute("flatRoof", flatRoof);
        request.getServletContext().setAttribute("roofMaterial", roofMaterial);
        request.getServletContext().setAttribute("shedWidth", shedWidth);
        request.getServletContext().setAttribute("shedLength", shedLength);
        request.getServletContext().setAttribute("comments", comments);

        return "confirmation";
    }
}
