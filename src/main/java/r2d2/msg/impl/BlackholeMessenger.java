package r2d2.msg.impl;

import r2d2.constants.MessengerType;
import r2d2.exception.DispatchException;
import r2d2.exception.LifeCycleException;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 01/03/14
 * Time: 7:55 PM
 */
public class BlackholeMessenger extends AbstractMessenger {

    public BlackholeMessenger(Map<String, String> config) {
        super(config);
        this.type= MessengerType.BLACKHOLE;
    }

    @Override
    public void dispatch(String message) throws DispatchException {
        //do nothing. its a blackhole.    http://en.wikipedia.org/wiki/Black_hole
    }

    @Override
    public boolean ping() {
        return true;
    }


    @Override
    public void start() throws LifeCycleException {
        //do nothing
    }

    @Override
    public void stop() throws LifeCycleException {
        //do nothing
    }
}
