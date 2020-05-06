package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Drawing extends Command {
    @Override

        String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        //Højde og bredde for den valgte carport hentes
        int width = ((int) request.getServletContext().getAttribute("width")/10);
        int length = ((int) request.getServletContext().getAttribute("length")/10);

        //Viewbox størrelse bliver afhængig af carport størrelse, så tegningen får en passende størrelse
        String viewbox = "0,0,"+width+","+length;

        //SVG klassen kaldes med carport dimensionerne
        Svg svg = new Svg(width, length, viewbox,0,0);

        //Rammen på tegningen tilføjes
        svg.addRect(0,0,length,width);

        //Diverse variable instantieres
        int x = 0;
        int y;
        int thickness;
        int distanceBetweenEach = 55;

        //Tilføjer remme:
        thickness = 8;
        svg.addStrap(30, 0, length, thickness);
        int xStrap = width - 30;
        svg.addStrap(xStrap, 0, length, thickness );

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

        //Variable til kryds:
        int xStartingPoint;
        int xEndingPoint;
        int yStartingPoint;
        int yEndingPoint;

        //Første streg til kryds tegnes:
        xStartingPoint = 30;
        xEndingPoint = width - 24;
        yStartingPoint = length - 50;
        yEndingPoint = 50;
        svg.addCross(xStartingPoint, yStartingPoint, xEndingPoint, yEndingPoint);

        //Første streg til kryds tegnes:
        xStartingPoint = 30;
        xEndingPoint = width - 24;
        yStartingPoint = length - 50;
        yEndingPoint = 50;
        svg.addCross(xStartingPoint, yEndingPoint , xEndingPoint, yStartingPoint);

        //For loop som tilføjer antal spær tilpasset carport dimensionerne:
        thickness = 4;
        y = 55;
        for (int i = length; i > y; y = y + distanceBetweenEach) {
            svg.addRect(x, y, thickness, width );
        }



        request.setAttribute("svgdrawing", svg.toString());

        request.getServletContext().setAttribute("width", null);
        request.getServletContext().setAttribute("length", null);
        request.getServletContext().setAttribute("height", null);
        request.getServletContext().setAttribute("roofMaterial", null);
        request.getServletContext().setAttribute("shedWidth", null);
        request.getServletContext().setAttribute("shedLength", null);

            return "drawing";
        }
    }

