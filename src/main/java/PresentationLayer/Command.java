package PresentationLayer;

import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
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

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException, ClassNotFoundException;

}
