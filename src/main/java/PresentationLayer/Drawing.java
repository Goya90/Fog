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
        Svg svg = new Svg(width, length, "0,0,800,600",0,0);
        svg.addRect(0,0,length,width);

        //Variable til for loop til spær:
        int x = 0;
        int y = 55;
        int thickness = 4;
        int distanceBetweenEach = 55;

        //For loop som tilføjer antal spær tilpasset carport dimensionerne:
        for (int i = length; i > y; y = y + distanceBetweenEach) {
          svg.addRect(x, y, thickness, width );
        }

        //Tilføjer stolper (4 stk. hvis carport længde < 480 cm. Ellers 6 stk):
        int poleThickness = 8;
        if (length < 481) {

            int yPole1 = (length / 10) * 2;
            int xPole1 = 30;
            svg.addRect(xPole1, yPole1, poleThickness,poleThickness);

            int yPole2 = (length / 10) * 2;
            int xPole2 = width - 30;
            svg.addRect(xPole2, yPole2, poleThickness,poleThickness);

            int yPole3 = (length / 10) * 8;
            int xPole3 = 30;
            svg.addRect(xPole3, yPole3, poleThickness,poleThickness);

            int yPole4 = (length / 10) * 8;
            int xPole4 = width - 30;
            svg.addRect(xPole4, yPole4, poleThickness,poleThickness);

        } else {

                int yPole1 = (length / 10) * 2;
                int xPole1 = 30;
                svg.addRect(xPole1, yPole1, poleThickness,poleThickness);

                int yPole2 = (length / 10) * 2;
                int xPole2 = width - 30;
                svg.addRect(xPole2, yPole2, poleThickness,poleThickness);

                int yPole3 = (length / 10) * 8;
                int xPole3 = 30;
                svg.addRect(xPole3, yPole3, poleThickness,poleThickness);

                int yPole4 = (length / 10) * 8;
                int xPole4 = width - 30;
                svg.addRect(xPole4, yPole4, poleThickness,poleThickness);

                int yPole5 = (length / 10) * 5;
                int xPole5 = 30;
                svg.addRect(xPole5, yPole5, poleThickness,poleThickness);

                int yPole6 = (length / 10) * 5;
                int xPole6 = width - 30;
                svg.addRect(xPole6, yPole6, poleThickness,poleThickness);
            }


        request.setAttribute("svgdrawing", svg.toString());

  //      request.setAttribute("width", width);
    //    request.setAttribute("height", height);
            return "drawing";
        }
    }

