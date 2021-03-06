package PresentationLayer;

import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Denne klasse er parent klassen i Command mønstret. Child klasser arver execute metoden fra denne klasse.
 * Modtagerne er gemt i et hashmap og bliver kaldt via execute metoden (@Override, arvet fra Command).
 *
 */

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        //HashMap befolkes med String som key og klasse/objekt som value
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "redirect", new Redirect());
        commands.put("billofmaterials", new BillOfMaterials());
        commands.put("drawing", new Drawing());
        commands.put("request", new Request());
        commands.put("unknowncommand", new UnknownCommand());
        commands.put("showRequests", new ShowRequests());
        commands.put("processrequest", new ProcessRequest());
        commands.put("logout", new Logout());
        commands.put("doneRequests", new DoneRequests());
        commands.put("markasdone", new MarkAsDone());

    }

    /**
     * Denne metode kalder den Command child klasse jsp siden "peger" på, via parametren "target".
     * HashMap commands initialiseres hvis det er tomt. Hvis targetName findes i commands bruges dette, ellers er UknownCommand
     * default.
     * @param request navnet på den Command child klasse der kaldes
     * @return navnet på den klasse der sendes tilbage
     */
    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );//Henter parametren target på webside = String i Command HashMap
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   //targetName hvis det findes, ellers default

    }

    /**
     *  Denne klasse arves af subklasserne og kaldes ved hj af "submit" på websider
     * @throws LoginSampleException fejl i login detaljer
     * @throws ClassNotFoundException klassen findes ikke
     */
    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException, ClassNotFoundException;

}
