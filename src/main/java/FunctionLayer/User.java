package FunctionLayer;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password;

    //Creates a user with 2 parameters
    public User( String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User( String email, String password, int id) {
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
