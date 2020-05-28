package PresentationLayer;

import FunctionLayer.CustomerRequest;
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
        //Henter værdien fra webside attribut
        int id = (int) request.getServletContext().getAttribute("reqID");
        //Laver en CustomerRequest instans fra id
        CustomerRequest cust = LogicFacade.showRequest(id);
        //Henter pris på request med en getter
        double dbpris = cust.getPrice();
        //Checker at der eksisterer en pris i db inden request sættes til processed=true
        if (dbpris > 0) {
            LogicFacade.updateRequest(id);
        } else {                            //Skriver fejlmedd på webside hvis ingen pris
            request.setAttribute( "error", "Fejl: Der er ikke sat en pris på forespørgslen" );
            return "adminpage";
        }
        //Opdaterer pris for det valgte id i tabellen cust_request via LogicFacade/RequestMapper

        //Sender brugeren retur til admin siden
        return "adminpage";
    }
}
