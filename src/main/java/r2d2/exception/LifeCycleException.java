package r2d2.exception;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 10:32 PM
 */
public class LifeCycleException extends Exception{

    public LifeCycleException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public LifeCycleException(Throwable throwable) {
        super(throwable);
    }
}
