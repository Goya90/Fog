package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Denne servlet bruges til at vise materialeliste samt pris på websiden billofmaterials.
 * Et Customerrequest objekt hentes i db via LogiFacade/RequestMapper og en materialeliste
 * beregnes med dette objekts parametre. Materialen sendes til websiden og vises i en tabel.
 */

public class BillOfMaterials extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ClassNotFoundException {

        HttpSession session = request.getSession();
        //Nummer på valgt CustomerRequest
        int reqID;
        //Validering af manuelt brugerinput, skal være et heltal (int)
        try {
            reqID = Integer.parseInt(request.getParameter("reqID"));
        } catch (NumberFormatException e) {
            request.setAttribute( "error", "Fejl: Du har ikke indtastet et heltal, ret din indtastning." );
            return "showRequests";
        }
        //Request objekt instantieres med værdier fra db
        CustomerRequest custreq = LogicFacade.showRequest(reqID);
        //Calculator objekt instantieres
        Calculator cal = new Calculator();
        //Arrayliste tømmes for evt tidligere værdier
        Calculator.bom.clear();
        //Ny arrayliste instantieres
        ArrayList<Material> bom;
        //Materialeliste skabes fra CustomerRequest attributter, fejl smides hvis custreq nr ikke findes i db
        try {
            bom = cal.bomCalculator(custreq.getWidth(), custreq.getLength(), custreq.getHeight(),
                    custreq.isFlatRoof(), custreq.getRoofMat(), custreq.getShedw(), custreq.getShedl());
        } catch (NullPointerException e) {
            request.setAttribute( "error", "FEJL: Der findes ikke en kundeforespørgsel med det indtastede nr." );
            return "adminpage";
        }
        //Samlet pris initialiseres
        Double total = 0.0;
        //samlet pris beregnes
        for (Material mat : bom) {
            total += mat.getPrice();
        }
        //jsp attributter sættes fra custreq objekt med gettere
        request.getServletContext().setAttribute("width", custreq.getWidth());
        request.getServletContext().setAttribute("height", custreq.getHeight());
        request.getServletContext().setAttribute("length", custreq.getLength());
        request.getServletContext().setAttribute("reqID", reqID);
        request.getServletContext().setAttribute("total", total);
        request.getServletContext().setAttribute("shedLength", custreq.getShedl());
        request.getServletContext().setAttribute("shedWidth", custreq.getShedw());
        request.getServletContext().setAttribute("roofMaterial", custreq.getRoofMat());
        //jsp attribut materiallist sættes med værdier fra bom liste
        session.setAttribute("materialList", bom);
        //brugeren sendes til websiden billofmaterials
        return "billofmaterials";
    }
}
