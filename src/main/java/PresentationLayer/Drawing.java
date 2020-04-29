package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Drawing extends Command {
    @Override

        String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int width = ((int) request.getServletContext().getAttribute("width")/10);
        int length = ((int) request.getServletContext().getAttribute("length")/10);

        /*request.getServletContext().setAttribute("width", width);
        request.getServletContext().setAttribute("length", length);
*/
        Svg svg = new Svg(400, 300, "0,0,800,600",0,0);
        Svg svgInnerDrawing = new Svg(900,800,"0,0,900,800",0,0);
        svg.addRect(0,0,length,width);
        svg.addRect(0,35,4,width);
        svg.addRect(0,565,4,width);

        request.setAttribute("svgdrawing", svg.toString());

  //      request.setAttribute("width", width);
    //    request.setAttribute("height", height);
            return "drawing";
        }
    }

