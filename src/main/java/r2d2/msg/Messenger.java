package r2d2.msg;

import r2d2.exception.DispatchException;
import r2d2.lifeCycle.Lifecycle;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 10:21 PM
 */
public interface Messenger extends Lifecycle {
    /**
     * send message to destination
     * @param message
     * @param topicName
     * @return integer values represented in MessageDispatchCodes enum
     * @throws DispatchException
     */
    public void dispatch(String message, String topicName) throws DispatchException;

    /**
     * ping method to check if messenger can reach its destination
     * @return true on success else false
     */
    public boolean ping();
}
