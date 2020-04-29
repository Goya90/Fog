
/*
 ** Forklaring til alle beregninger kan findes i filen Materialeliste beregninger.xlsx
 */

package FunctionLayer;

import java.util.ArrayList;


public class Calculator {

    //Instantiering af variable for carport dimensioner:
    int carportWidth;
    int carportLength;
    int carportHeight;

    //Instantiering af variable der skal bruges i alle eller flere addMaterial() metoder:
    int materialId;
    int minimumQuantity = 1;
    int minimumLength;
    int fixedQuantity;
    int fixedLength;
    int multiplier;
    int divider;
    int convertMM2ToM2 = 10000000;
    int convertMMToM = 1000;
    int distanceBetweenEach;
    int calculatedQuantity;

    //Instantiering af ArrayList som addMaterial() metoderne tilføjer til:
    static ArrayList<Material> bom = new ArrayList<>();

    //Instantiering af et Material objekt som addMaterialer() metoderne bruger:
    Material mat = null;

    public ArrayList<Material> bomCalculator (int width, int length, int height, boolean flatRoof, String roofMaterial, int shedLength, int shedWidth) throws LoginSampleException, ClassNotFoundException {

        //Fejlmeddelelse hvis metoden modtager nul-værdier for carport bredde, længde eller højde:
        if (width == 0 || length == 0 || height == 0) {
            //TODO: returner fejlbesked
        }

        //Metoden sætter variabler der skal bruges i addMaterial() metoderne:
        carportWidth = width;
        carportLength = length;
        carportHeight = height;

        //Grundlæggende materialer til simpel carport tilføjes:
        //TODO: Lav metode der kan kalde alle disse metoder i et loop
        addMaterial1();
        addMaterial3();
        addMaterial6();
        addMaterial23();
        addMaterial24();
        addMaterial27();
        addMaterial28();

        //Hvis taget er fladt tilføjes disse materialer:
        if (flatRoof = true) {
            addMaterial2();
            addMaterial7();
            addMaterial18();
            addMaterial22();
            addMaterial25();
        }
        //Hvis taget har rejsning tilføjes disse materialer:
        else {
            addMaterial10();
            addMaterial11();
            addMaterial12();
            addMaterial13();
            addMaterial15();
            addMaterial16();
            addMaterial17();
            addMaterial19();
            addMaterial20();
            addMaterial21();
        }

        //Tilføjer tag materiale:
        if (roofMaterial.equals("Plastmo sort")){
            addMaterial34();
        } else if (roofMaterial.equals("Plastmo gennemsigtig")) {
            addMaterial35();
        } else if (roofMaterial.equals("Plastmo hvid")) {
            addMaterial36();
        } else if (roofMaterial.equals("Tagsten sort")) {
            addMaterial15();
        } else if (roofMaterial.equals("Tagpap sort")) {
            addMaterial37();
        } else if (roofMaterial.equals("Trapez plast sort")) {
            addMaterial38();
        } else {
            addDummyMaterial();
        }

        //Hvis kunden har valgt redskabsskur
        if (shedLength != 0 && shedWidth != 0) {
            ShedCalculator shedCalc = new ShedCalculator();
            shedCalc.shedBomCalculator(shedLength, shedWidth);
        }

        return bom;
    }

    /*
    //TODO: Find ud af om vi skal bruge denne:
    public Material getMaterialFromDatabase (int MaterialId) {
        Material mat = null;
        try {
            mat = LogicFacade.showMaterial(materialId);
        } catch (LoginSampleException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return mat;
    }
     */

    //Dummy materiale til at vise at materiale ikke blev tilføjet:
    public void addDummyMaterial () throws LoginSampleException, ClassNotFoundException {
        mat.setCategory("FEJL!");
        mat.setName("Materiale mangler");
        mat.setDescription("Kontakt venligst Fog");

        bom.add(mat);
    }

    //Materiale med ID nr. 1 bliver tilføjet.
    public void addMaterial1 () throws LoginSampleException, ClassNotFoundException {
        materialId = 1;

        mat = LogicFacade.showMaterial(materialId);

        fixedQuantity = 2;
        minimumLength = 600;

        mat.setLength(minimumLength + carportLength);
        mat.setQuantity(fixedQuantity);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);

    }

    //Materiale med ID nr. 2 bliver tilføjet:
    public void addMaterial2 () throws LoginSampleException, ClassNotFoundException {
        materialId = 2;
        fixedQuantity = 1;

        mat = LogicFacade.showMaterial(materialId);

        mat.setLength(carportWidth);
        mat.setQuantity(fixedQuantity);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 3 bliver tilføjet:
    public void addMaterial3 () throws LoginSampleException, ClassNotFoundException {
        materialId = 3;
        fixedLength = 900;

        mat = LogicFacade.showMaterial(materialId);

        if (carportLength < 4800) {
            fixedQuantity = 4;
        } else {
            fixedQuantity = 6;
        }

        mat.setLength(fixedLength + carportHeight);
        mat.setQuantity(fixedQuantity);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 6 bliver tilføjet:
    public void addMaterial6 () throws LoginSampleException, ClassNotFoundException {
        materialId = 6;
        fixedQuantity = 2;

        mat = LogicFacade.showMaterial(materialId);

        mat.setLength(carportLength);
        mat.setQuantity(fixedQuantity);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 7 bliver tilføjet:
    public void addMaterial7 () throws LoginSampleException, ClassNotFoundException {
        materialId = 7;
        distanceBetweenEach = 550;

        mat = LogicFacade.showMaterial(materialId);

        mat.setLength(carportWidth);
        mat.setQuantity(carportLength / distanceBetweenEach);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 10 bliver tilføjet:
    public void addMaterial10 () throws LoginSampleException, ClassNotFoundException {
        materialId = 10;
        distanceBetweenEach = 1000;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(carportLength / distanceBetweenEach);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 11 bliver tilføjet: TODO: I denne metoder er der lidt problemer med Double kontra Int. Se om det kan løses mere elegant end med casting.
    public void addMaterial11 () throws LoginSampleException, ClassNotFoundException {
        materialId = 11;
        fixedQuantity = 2;
        Double multiplier = 1.4;

        mat = LogicFacade.showMaterial(materialId);

        double lengthDouble = carportWidth*multiplier;
        int lengthInt = (int) lengthDouble;

        mat.setLength(lengthInt);
        mat.setQuantity(fixedQuantity);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 12 bliver tilføjet:
    public void addMaterial12 () throws LoginSampleException, ClassNotFoundException {
        materialId = 12;
        fixedLength = 540;
        distanceBetweenEach = 1000;

        mat = LogicFacade.showMaterial(materialId);

        mat.setLength(fixedLength);
        mat.setQuantity(carportLength/distanceBetweenEach);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 13 bliver tilføjet:
    public void addMaterial13 () throws LoginSampleException, ClassNotFoundException {
        materialId = 13;
        distanceBetweenEach = 1000;

        mat = LogicFacade.showMaterial(materialId);

        mat.setLength(carportWidth);
        mat.setQuantity(carportLength/distanceBetweenEach);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 14 bliver tilføjet:
    public void addMaterial14 () throws LoginSampleException, ClassNotFoundException {
        materialId = 14;
        fixedQuantity = 600;
        divider = 1000000;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(((carportLength+fixedQuantity) * (carportWidth+fixedQuantity))/divider);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 15 bliver tilføjet:
    public void addMaterial15 () throws LoginSampleException, ClassNotFoundException {
        materialId = 15;
        multiplier = 14;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity((carportLength*carportWidth/convertMM2ToM2)*multiplier);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 16 bliver tilføjet:
    public void addMaterial16 () throws LoginSampleException, ClassNotFoundException {
        materialId = 16;
        divider = 14;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(carportLength/divider);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 17 bliver tilføjet:
    public void addMaterial17 () throws LoginSampleException, ClassNotFoundException {
        materialId = 17;
        divider = 14;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(carportLength/divider);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 18 bliver tilføjet:
    public void addMaterial18 () throws LoginSampleException, ClassNotFoundException {
        materialId = 18;
        multiplier = 15;
        minimumQuantity = 1;

        mat = LogicFacade.showMaterial(materialId);

        calculatedQuantity = (carportLength*carportWidth)/convertMM2ToM2*multiplier;

        if (minimumQuantity > calculatedQuantity) {
            mat.setQuantity(minimumQuantity);
        } else {
            mat.setQuantity(calculatedQuantity);
        }

        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 19 bliver tilføjet:
    public void addMaterial19 () throws LoginSampleException, ClassNotFoundException {
        materialId = 19;
        distanceBetweenEach = 1000;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(carportLength/distanceBetweenEach);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 20 bliver tilføjet:
    public void addMaterial20 () throws LoginSampleException, ClassNotFoundException {
        materialId = 20;
        divider = 15;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity((carportLength*carportWidth/convertMM2ToM2)*divider);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 21 bliver tilføjet:
    public void addMaterial21 () throws LoginSampleException, ClassNotFoundException {
        materialId = 21;
        divider = 15;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity((carportLength*carportWidth/convertMM2ToM2)/divider);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 22 bliver tilføjet:
    public void addMaterial22 () throws LoginSampleException, ClassNotFoundException {
        materialId = 22;
        multiplier = 25;
        minimumQuantity = 1;

        mat = LogicFacade.showMaterial(materialId);

        calculatedQuantity = (carportLength*carportWidth)/convertMM2ToM2*multiplier;

        if (minimumQuantity > calculatedQuantity) {
            mat.setQuantity(minimumQuantity);
        } else {
            mat.setQuantity(calculatedQuantity);
        }

        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale ID 23 bliver tilføjet:
    public void addMaterial23 () throws LoginSampleException, ClassNotFoundException {
        materialId = 23;
        distanceBetweenEach = 500;

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setLength(0); //TODO: skal length sættes?
        mat.setQuantity(carportLength / distanceBetweenEach);

        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 24 bliver tilføjet:
    public void addMaterial24 () throws LoginSampleException, ClassNotFoundException {
        materialId = 24;
        divider = 500;

        Material mat = LogicFacade.showMaterial(materialId);
        mat.setQuantity(carportLength/divider);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 25 bliver tilføjet:
    public void addMaterial25 () throws LoginSampleException, ClassNotFoundException {
        materialId = 25;
        multiplier = 25;
        minimumQuantity = 1;
        distanceBetweenEach = 550;

        mat = LogicFacade.showMaterial(materialId);

        calculatedQuantity = ((carportLength / distanceBetweenEach) * 2 * 4) + (((carportLength * carportWidth) / convertMM2ToM2 / multiplier) * 100);

        if (minimumQuantity > calculatedQuantity) {
            mat.setQuantity(minimumQuantity);
        } else {
            mat.setQuantity(calculatedQuantity);
        }

        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 27 bliver tilføjet:
    public void addMaterial27 () throws LoginSampleException, ClassNotFoundException {
        materialId = 27;

        if (carportLength < 4800) {
            fixedQuantity = 8;
        } else {
            fixedQuantity = 12;
        }

        Material mat = LogicFacade.showMaterial(materialId);

        mat.setLength(0); //TODO: skal length sættes?
        mat.setQuantity(fixedQuantity);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 28 bliver tilføjet:
    public void addMaterial28 () throws LoginSampleException, ClassNotFoundException {
        materialId = 28;
        multiplier = 25;
        minimumQuantity = 1;

        mat = LogicFacade.showMaterial(materialId);

        calculatedQuantity = (carportLength*carportWidth)/convertMM2ToM2*multiplier;

        if (minimumQuantity > calculatedQuantity) {
            mat.setQuantity(minimumQuantity);
        } else {
            mat.setQuantity(calculatedQuantity);
        }
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 34 bliver tilføjet:
    public void addMaterial34 () throws LoginSampleException, ClassNotFoundException {
        materialId = 34;
        fixedQuantity = 600;
        divider = 1000000;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(((carportLength+fixedQuantity) * (carportWidth+fixedQuantity))/divider);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 35 bliver tilføjet:
    public void addMaterial35 () throws LoginSampleException, ClassNotFoundException {
        materialId = 35;
        fixedQuantity = 600;
        divider = 1000000;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(((carportLength+fixedQuantity) * (carportWidth+fixedQuantity))/divider);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 36 bliver tilføjet:
    public void addMaterial36 () throws LoginSampleException, ClassNotFoundException {
        materialId = 36;
        fixedQuantity = 600;
        divider = 1000000;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity(((carportLength+fixedQuantity) * (carportWidth+fixedQuantity))/divider);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 37 bliver tilføjet:
    public void addMaterial37 () throws LoginSampleException, ClassNotFoundException {
        materialId = 37;
        multiplier = 14;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity((carportLength*carportWidth/convertMM2ToM2)*multiplier);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }

    //Materiale med ID nr. 38 bliver tilføjet:
    public void addMaterial38 () throws LoginSampleException, ClassNotFoundException {
        materialId = 38;
        multiplier = 14;

        mat = LogicFacade.showMaterial(materialId);

        mat.setQuantity((carportLength*carportWidth/convertMM2ToM2)*multiplier);
        mat.setPrice(mat.getQuantity()*mat.getPrice());

        bom.add(mat);
    }


}