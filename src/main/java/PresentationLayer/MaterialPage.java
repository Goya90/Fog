package PresentationLayer;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class MaterialPage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ClassNotFoundException {
        HttpSession session = request.getSession();
        ArrayList<Material> materialList = null;
        request.setAttribute("materialList", materialList);
        return "materialPage";
    }
}