package PresentationLayer;
import DBAccess.Connector;
import FunctionLayer.Calculator;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AddDimensionsCommand extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ClassNotFoundException {

        HttpSession session = request.getSession();
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        int length = Integer.parseInt(request.getParameter("length"));

        // Material mat = new Material();
        Calculator cal = new Calculator(width, height, length); // Calculator-klasse skal laves om

        return "MaterialPage";
    }
}
