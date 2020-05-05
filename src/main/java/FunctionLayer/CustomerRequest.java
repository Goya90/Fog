package FunctionLayer;

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

    //Creates an object from the values chosen and entered by the customer in the .jsp pages
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
    //used to create an object on the showRequests jsp page
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
