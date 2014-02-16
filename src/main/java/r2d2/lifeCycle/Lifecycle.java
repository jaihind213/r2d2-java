package r2d2.lifeCycle;

import r2d2.exception.LifeCycleException;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 10:31 PM
 * lifeCycle methods
 */
public interface Lifecycle {
    /**
     * @return integer as in Enum LifeCycleErrorCodes.
     * @throws LifeCycleException
     */
    public void start() throws LifeCycleException;

    /**
     *
     * @return integer as in Enum LifeCycleErrorCodes.
     * @throws LifeCycleException
     */
    public void stop() throws LifeCycleException;
}
