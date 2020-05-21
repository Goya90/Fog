package FunctionLayer;

import java.util.ArrayList;
import static FunctionLayer.Calculator.bom;

/**
 * Formålet med denne klasse er at kunne tilføje materialer til skur til materialelisten hvis dette er valgt.
 */

public class ShedCalculator {

    int widthShed;
    int lengthShed;
    int convertToM2 = 1000000;
    int carportHeight;

    public ArrayList<Material> shedBomCalculator (int height, int shedWidth, int shedLength) throws LoginSampleException, ClassNotFoundException {

        carportHeight = height;
        widthShed = shedWidth;
        lengthShed = shedLength;

        addMaterial4();
        addMaterial31();
        addMaterial32();
        addMaterial33();
        return bom;
    }

    public void addMaterial4 () throws LoginSampleException, ClassNotFoundException {
        int materialId = 4;
        int fixedQuantity = 2;
        int fixedNum = 60;
        int fixedNum2 = 200;

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setLength(carportHeight-fixedNum2);
        mat.setQuantity(((lengthShed/fixedNum)*fixedQuantity) + ((widthShed/fixedNum)*fixedQuantity));
        bom.add(mat);
    }


    public void addMaterial31 () throws LoginSampleException, ClassNotFoundException {
        int materialId = 31;
        int fixedNum = 4;

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(((lengthShed*widthShed)/convertToM2)+fixedNum);

        bom.add(mat);
    }

    public void addMaterial32 () throws LoginSampleException, ClassNotFoundException {
        int materialId = 32;
        int fixedNum = 60;
        int fixedNum2 = 2;
        int numberPerPack = 400;
        int calculatedQuantity;
        int minimumQuantity = 1;

        Material mat = LogicFacade.showMaterial(materialId);

        calculatedQuantity = (((lengthShed/fixedNum)*fixedNum2) + ((widthShed/fixedNum)/fixedNum2))/numberPerPack;

        if (calculatedQuantity > minimumQuantity) {
            mat.setQuantity(calculatedQuantity);
        } else {
            mat.setQuantity(minimumQuantity);
        }

        bom.add(mat);
    }

    public void addMaterial33 () throws LoginSampleException, ClassNotFoundException {
        int materialId = 33;
        int fixedNum = 60;
        int fixedNum2 = 2;
        int numberPerPack = 300;
        int calculatedQuantity;
        int minimumQuantity = 1;

        Material mat = LogicFacade.showMaterial(materialId);

        calculatedQuantity = ((((lengthShed/fixedNum)*fixedNum2) + (((widthShed/fixedNum)*fixedNum2))/fixedNum2)*fixedNum2)/numberPerPack;

        if (calculatedQuantity > minimumQuantity) {
            mat.setQuantity(calculatedQuantity);
        } else {
            mat.setQuantity(minimumQuantity);
        }

        bom.add(mat);
    }


}
