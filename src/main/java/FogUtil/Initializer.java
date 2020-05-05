package FogUtil;

import FunctionLayer.LogicFacade;

import java.util.List;
/**
 * Initializer provides methods that provide data for populating dropdown lists(with carport elements) on .jsp pages,
 * at system startup. The methods call methods in the FacadeLogic class as part of the facade pattern.
 * @author claes
 */

public class Initializer {

    private static List<Integer> widthsList = null;
    private static List<Integer> lengthsList = null;
    private static List<Integer> heightsList = null;
    private static List<String> flatRoofMaterialList = null;
    private static List<String> slantedRoofMaterialList = null;
    private static List<String> roofMaterialList = null;
    private static List <Integer> shedWidthsList = null;
    private static List <Integer> shedLengthsList = null;


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

    public static List<String> getFlatroofMaterialList() {
        if (flatRoofMaterialList == null) {
            try {
                slantedRoofMaterialList = LogicFacade.showFlatRoofMaterialList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flatRoofMaterialList;
    }

    public static List<String> getSlantedRoofMaterialType() {
        if (slantedRoofMaterialList == null) {
            try {
                slantedRoofMaterialList = LogicFacade.showSlantedRoofMaterialList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return slantedRoofMaterialList;
    }

    public static List<String> getRoofMaterialType(boolean rooftype) {
        if (roofMaterialList == null) {
            try {
                roofMaterialList = LogicFacade.showRoofMaterialList(rooftype);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return roofMaterialList;
    }
    public static List<Integer> getShedWidthsList() {
        if (shedWidthsList == null) {
            try {
                shedWidthsList = LogicFacade.showShedWidths();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return shedWidthsList;
    }

    public static List<Integer> getShedLengthsList() {
        if (shedLengthsList == null) {
            try {
                shedLengthsList = LogicFacade.showShedLengths();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return shedLengthsList;
    }
}
