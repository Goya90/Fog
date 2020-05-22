package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Denne servlet henter en ny brugers indtastede værdier på login websiden, laver en nyt bruger objekt
 * af disse (hvis de er gyldige) og sender den nye brugers data til db tabellen users. Hvis de to passwords ikke er ens,
 * sendes en fejlmeddelelse.
 */

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        //Henter de indtastede værdier på websiden
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        //Validerer at passwords er ens
        if ( password1.equals( password2 ) ) {
            User user = LogicFacade.createUser( email, password1 ); //Opretter ny bruger via LogicFacade og UserMapper
            HttpSession session = request.getSession();

            session.setAttribute("email",email);
            session.setAttribute( "user", user );
            return "adminpage";
        } else {
            Log.finest("registrer"+"the two passwords did not match");
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}
