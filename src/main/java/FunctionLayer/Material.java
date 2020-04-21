package FunctionLayer;

public class Material {
    private int materialID;
    private String materialName;
    private String materialUnit;
    private String materialDescription;
    public Material(int materialID, String materialName, String materialUnit, String materialDescription) {
        this.materialID = materialID;
        this.materialName = materialName;
        this.materialUnit = materialUnit;
        this.materialDescription = materialDescription;
    }
    public int getMaterialID() {
        return materialID;
    }
    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }
    public String getMaterialName() {
        return materialName;
    }
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
    public String getMaterialUnit() {
        return materialUnit;
    }
    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }
    public String getMaterialDescription() {
        return materialDescription;
    }
    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }
}
