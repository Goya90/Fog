
package FunctionLayer;

import java.util.ArrayList;

import static FunctionLayer.Calculator.bom;

public class ShedCalculator {
    private int shedWidth;
    private int shedLength;
    private int convertToM2 = 1000000;

    int carportWidth = 2000;
    int carportLength = 3000;
    int carportHeight = 4000;

    Calculator cal = new Calculator();


    public ArrayList<Material> shedBomCalculator (int shedWidth, int shedLength) throws LoginSampleException, ClassNotFoundException {

        addMaterial4();
        addMaterial31();
        addMaterial32();
        addMaterial33();
        return bom;
    }

    public void addMaterial4 () throws LoginSampleException, ClassNotFoundException {
        //Længde: (1 x carport højde) - 200
        //Antal: ((skur længde / 60) x 2) + ((skur bredde / 60) x 2))
        int materialId = 4;
        int fixedQuantity = 2;
        int fixedNum = 60;
        int fixedNum2 = 200;

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setLength(carportHeight-fixedNum2);
        mat.setQuantity(((shedLength/fixedNum)*fixedQuantity) + ((shedWidth/fixedNum)*fixedQuantity));
        bom.add(mat);
    }


    public void addMaterial31 () throws LoginSampleException, ClassNotFoundException {
        //Antal: ((skur længde x bredde) / 1000000) + 4
        int materialId = 31;
        int fixedNum = 4;

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(((shedLength*shedWidth)/convertToM2)+fixedNum);

        bom.add(mat);
    }

    public void addMaterial32 () throws LoginSampleException, ClassNotFoundException {
        //Antal: ((skur længde / 60) x 2) + ((skur bredde / 60) x 2)) / 2
        int materialId = 32;
        int fixedNum = 60;
        int fixedNum2 = 2;

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(((shedLength/fixedNum)*fixedNum2) + ((shedWidth/fixedNum))/fixedNum2);

        bom.add(mat);
    }

    public void addMaterial33 () throws LoginSampleException, ClassNotFoundException {
        //Antal: (((skur længde / 60) x 2) + ((skur bredde / 60) x 2)) / 2) x 2
        int materialId = 33;
        int fixedNum = 60;
        int fixedNum2 = 2;

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(((((shedLength/fixedNum)*fixedNum2) + ((shedWidth/fixedNum)*fixedNum2))/fixedNum2)*fixedNum2);

        bom.add(mat);
    }


}