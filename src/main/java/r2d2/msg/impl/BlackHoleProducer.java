package r2d2.msg.impl;

import r2d2.constants.MessageDispatchCodes;
import r2d2.exception.DispatchException;
import r2d2.exception.LifeCycleException;
import r2d2.msg.Messenger;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 11:43 PM
 */
public class BlackHoleProducer implements Messenger{

    @Override
    public void dispatch(String message, String topicName) throws DispatchException {
        System.out.println("sending message: "+message+" ,topic: "+topicName);
    }

    @Override
    public boolean ping() {
        return true;
    }

    @Override
    public void start() throws LifeCycleException {
    }

    @Override
    public void stop() throws LifeCycleException {
    }
}
