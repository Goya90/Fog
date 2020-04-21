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
        //TODO: returner fejlbesked
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

    //Forklaring til formel: 300 mm udhæng i hver ende og et bræt på hver side. Derfor starter værdien på 1200 mm. TODO: Find ud af om forklaring skal med

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

    //Materiale ID 3 bliver tilføjet:
    public void addMaterial3 () throws LoginSampleException, ClassNotFoundException {
        int materialId = 3;
        int fixedLength = 900;
        int fixedQuantity;

        if (carportLength < 4800) {
            fixedQuantity = 4;
        } else {
            fixedQuantity = 6;
        }

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setLength(fixedLength + carportHeight);
        mat.setQuantity(fixedQuantity);

        bom.add(mat);
    }

    //Materiale ID 7 bliver tilføjet:
    public void addMaterial7 () throws LoginSampleException, ClassNotFoundException {
        int materialId = 7;
        int distance = 550;

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setLength(carportWidth);
        mat.setQuantity(carportLength / distance);

        bom.add(mat);
    }

    //Materiale ID 23 bliver tilføjet:
    public void addMaterial23 () throws LoginSampleException, ClassNotFoundException {
        int materialId = 23;
        int distance = 500;

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setLength(0); //TODO: skal length sættes?
        mat.setQuantity(carportLength / distance);

        bom.add(mat);
    }

    //Materiale ID 25 bliver tilføjet:
    public void addMaterial25 () throws LoginSampleException, ClassNotFoundException {
        int materialId = 25;
        int distance = 550;
        int convertToM2 = 1000000;

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setLength(0); //TODO: skal length sættes?
        mat.setQuantity((carportLength / distance) * 2 * 4 + (carportLength * carportWidth) / convertToM2 / 25 * 100);

        bom.add(mat);
    }

    //Materiale ID 27 bliver tilføjet:
    public void addMaterial27 () throws LoginSampleException, ClassNotFoundException {
        int materialId = 27;
        int fixedQuantity;

        if (carportLength < 4800) {
            fixedQuantity = 8;
        } else {
            fixedQuantity = 12;
        }

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setLength(0); //TODO: skal length sættes?
        mat.setQuantity(fixedQuantity);

        bom.add(mat);
    }

}
