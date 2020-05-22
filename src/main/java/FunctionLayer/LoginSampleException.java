package FunctionLayer;

/**
 * Formålet med denne klasse er at sende en besked til brugeren
 * hvis der er de indtastede credentials ikke stemmer med db tabellen users
 *
 */
public class LoginSampleException extends Exception {

    public LoginSampleException(String msg) {
        super(msg);
    }
    

}
