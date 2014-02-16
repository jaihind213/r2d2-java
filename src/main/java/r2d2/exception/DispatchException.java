package r2d2.exception;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 10:23 PM
 * exception on trying to dispatch a message
 */
public class DispatchException extends Exception{

    public DispatchException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DispatchException(Throwable throwable) {
        super("Error in dispatching exception",throwable);
    }
}
