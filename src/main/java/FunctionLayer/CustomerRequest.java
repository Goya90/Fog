package FunctionLayer;

/**
Denne klasse indeholder constructors samt instansvariable til et kundeforespørgsels objekt
 @author claes
 */

public class CustomerRequest {

    int reqId;
    String name;
    int telno;
    String email;
    String comments;
    int width;
    int length;
    int height;
    boolean flatRoof;
    String roofMat;
    int shedl;
    int shedw;

    /**
     * Constructor, CustomerRequest objekt
     * @param name
     * @param telno
     * @param email
     * @param comments
     * @param width
     * @param length
     * @param height
     * @param flatRoof
     * @param roofMat
     * @param shedl
     * @param shedw
     */
    public CustomerRequest(String name, int telno, String email, String comments, int width, int length, int height,
                           boolean flatRoof, String roofMat, int shedl, int shedw) {
        this.name = name;
        this.telno = telno;
        this.email = email;
        this.comments = comments;
        this.width = width;
        this.length = length;
        this.height = height;
        this.flatRoof = flatRoof;
        this.roofMat = roofMat;
        this.shedl = shedl;
        this.shedw = shedw;
    }

    /**
     * Constructor, CustomerRequest objekt uden reqId.
     * @param reqId
     * @param name
     * @param telno
     * @param email
     * @param comments
     * @param width
     * @param length
     * @param height
     * @param flatRoof
     * @param roofMat
     * @param shedl
     * @param shedw
     */
    public CustomerRequest(int reqId, String name, int telno, String email, String comments, int width, int length,
                           int height, boolean flatRoof, String roofMat, int shedl, int shedw) {
        this.reqId = reqId;
        this.name = name;
        this.telno = telno;
        this.email = email;
        this.comments = comments;
        this.width = width;
        this.length = length;
        this.height = height;
        this.flatRoof = flatRoof;
        this.roofMat = roofMat;
        this.shedl = shedl;
        this.shedw = shedw;
    }

    /**
     * Constructor, CustomerRequest objekt
     * @param width
     * @param length
     * @param height
     * @param flatRoof
     * @param roofMat
     * @param shedl
     * @param shedw
     */
    public CustomerRequest(int width, int length, int height, boolean flatRoof, String roofMat, int shedl, int shedw) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.flatRoof = flatRoof;
        this.roofMat = roofMat;
        this.shedl = shedl;
        this.shedw = shedw;
    }
    //settere og gettere
    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public int getReqId() {
        return reqId;
    }

    public String getName() {
        return name;
    }

    public int getTelno() {
        return telno;
    }

    public String getEmail() {
        return email;
    }

    public String getComments() {
        return comments;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public boolean isFlatRoof() {
        return flatRoof;
    }

    public String getRoofMat() {
        return roofMat;
    }

    public int getShedl() {
        return shedl;
    }

    public int getShedw() {
        return shedw;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "reqId=" + reqId +
                ", name='" + name + '\'' +
                ", telno=" + telno +
                ", email='" + email + '\'' +
                ", comments='" + comments + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", height=" + height +
                ", flatRoof=" + flatRoof +
                ", roofMat='" + roofMat + '\'' +
                ", shedl=" + shedl +
                ", shedw=" + shedw +
                '}';
    }
}
