package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BillOfMaterials extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ClassNotFoundException {

        HttpSession session = request.getSession();

        int reqID = Integer.parseInt(request.getParameter("reqID"));

        CustomerRequest custreq = LogicFacade.showRequest(reqID);

        Calculator cal = new Calculator();

        ArrayList<Material> bom = cal.bomCalculator(custreq.getWidth(), custreq.getLength(), custreq.getHeight(),
                custreq.isFlatRoof(), custreq.getRoofMat(), custreq.getShedw(), custreq.getShedl());


        Double total = 0.0;

        for (Material mat : bom) {
            total += mat.getPrice();
        }

        request.getServletContext().setAttribute("width", custreq.getWidth());
        request.getServletContext().setAttribute("height", custreq.getHeight());
        request.getServletContext().setAttribute("length", custreq.getLength());
        request.getServletContext().setAttribute("reqID", reqID);
        request.getServletContext().setAttribute("total", total);

        session.setAttribute("materialList", bom);

        return "billofmaterials";
    }
}