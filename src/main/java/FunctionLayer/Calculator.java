package FunctionLayer;

import java.util.ArrayList;

public class Calculator {

    private int width;
    private int length;
    private int height;
    private boolean flat;
    private boolean shed;

    int carportWidth = width;
    int carportLength = length;
    int carportHeight = height;

    ArrayList<Material> bom = new ArrayList<>();

public ArrayList<Material> bomCalculator (int width, int length, int height) throws LoginSampleException, ClassNotFoundException {

    if (width == 0 || length == 0 || height == 0) {
        //returner fejlbesked
    }

    //Tilføjer materiale ID 1:
    addMaterial1();

    return bom;
}

//Materiale 1 bliver tilføjet:
public void addMaterial1 () throws LoginSampleException, ClassNotFoundException {
    int materialId = 1;
    int fixedQuantity = 2;
    int minimumLength = 600;

    Material mat = LogicFacade.showMaterial(materialId);

    mat.setLength(minimumLength + carportLength);
    mat.setQuantity(fixedQuantity);

    bom.add(mat);
}

    //Materiale 2 bliver tilføjet:
    public void addMaterial2 () throws LoginSampleException, ClassNotFoundException {
        int materialId = 2;
        int fixedQuantity = 1;

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setLength(carportWidth);
        mat.setQuantity(fixedQuantity);

        bom.add(mat);
    }

}
