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

        int reqID = Integer.parseInt(request.getParameter("reqID"));
        HttpSession session = request.getSession();

        CustomerRequest custreq = LogicFacade.showRequest(reqID);

        Calculator cal = new Calculator();

        ArrayList<Material> bom = cal.bomCalculator(custreq.getWidth(), custreq.getLength(), custreq.getHeight(),
                custreq.isFlatRoof(), custreq.getRoofMat(), custreq.getShedw(), custreq.getShedl());

        DecimalFormat df = new DecimalFormat("#.##");

        Double total = 0.0;

        for (Material mat : bom) {
            total += mat.getPrice();
        }

        //String formattedTotal = df.format(total);


        request.getServletContext().setAttribute("width", custreq.getWidth());
        request.getServletContext().setAttribute("height", custreq.getHeight());
        request.getServletContext().setAttribute("length", custreq.getLength());
        request.getServletContext().setAttribute("shedWidth", custreq.getShedw());
        request.getServletContext().setAttribute("shedLength", custreq.getShedl());
        request.getServletContext().setAttribute("reqID", reqID);
        request.getServletContext().setAttribute("total", total);

        request.setAttribute("materialList", bom);


        return "billofmaterials";
    }
}
