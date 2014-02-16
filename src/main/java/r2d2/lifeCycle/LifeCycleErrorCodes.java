package r2d2.lifeCycle;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 11:37 PM
 */
public enum LifeCycleErrorCodes {

    SUCCESS(1), FAILURE(-1);

    private final int code;

    LifeCycleErrorCodes(int i) {
        this.code = i;
    }
}
