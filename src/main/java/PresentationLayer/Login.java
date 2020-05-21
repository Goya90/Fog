package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Formålet med denne klasse er at validere et login i databasen og sætte bruger objektets værdier som session attributter
 * ved log in. Ved succesfuldt login føres brugeren til admin web siden.
 */
public class Login extends Command {

    /**
     *
     * @param request det indtastede id samt password, fra websiden
     * @param response
     * @return admin websiden
     * @throws LoginSampleException ved SQL fejl
     */
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );

        HttpSession session = request.getSession();

        session.setAttribute( "user", user );
        session.setAttribute("email", email);
        session.setAttribute("userID", user.getId());

        return "adminpage";
    }

}
