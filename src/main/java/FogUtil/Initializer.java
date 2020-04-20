package FogUtil;

import FunctionLayer.LogicFacade;

import java.util.List;

public class Initializer {

    private static List<Integer> widthsList = null;
    private static List<Integer> lengthsList = null;
    private static List<Integer> heightsList = null;

    public static List<Integer> getWidthsList() {
        if (widthsList == null) {
            try {
                widthsList = LogicFacade.showWidths();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return widthsList;
    }

    public static List<Integer> getLengthsList() {
        if (lengthsList == null) {
            try {
                lengthsList = LogicFacade.showLengths();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lengthsList;
    }

    public static List<Integer> getHeightsList() {
        if (heightsList == null) {
            try {
                heightsList = LogicFacade.showHeights();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return heightsList;
    }

}
