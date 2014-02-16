package r2d2.constants;

/**
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 10:26 PM
 */
public enum MessageDispatchCodes {
    SUCCESS(1), FAILURE(-1), ERR_CONNECT(-2) ;

    private final int errCode;

    MessageDispatchCodes(int i) {
        this.errCode= i;
    }

    public int getErrCode() {
        return errCode;
    }
}
