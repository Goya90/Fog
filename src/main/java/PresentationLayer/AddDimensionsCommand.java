package PresentationLayer;

import FunctionLayer.Calculator;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.ShedCalculator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AddDimensionsCommand extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ClassNotFoundException {

        //HttpSession session = request.getSession();

        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        int length = Integer.parseInt(request.getParameter("length"));
        boolean flatRoof = Boolean.parseBoolean(request.getParameter("flatRoof"));
        String roofMaterial = request.getParameter("roofMaterial");
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));

        request.getServletContext().setAttribute("width", width);
        request.getServletContext().setAttribute("height", height);
        request.getServletContext().setAttribute("length", length);
        request.setAttribute("flatRoof", flatRoof);
        request.setAttribute("roofMaterial", roofMaterial);
        request.setAttribute("shedWidth", shedWidth);
        request.setAttribute("shedLength", shedLength);


        Calculator cal = new Calculator();

        ShedCalculator shedCal = new ShedCalculator();

        ArrayList<Material> bom = cal.bomCalculator(width, length, height, flatRoof, roofMaterial, shedWidth, shedLength);
        request.setAttribute("materialList", bom);


        return "materialPage";
    }
}