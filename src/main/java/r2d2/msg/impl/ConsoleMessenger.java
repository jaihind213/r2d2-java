package r2d2.msg.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import r2d2.constants.MessengerType;
import r2d2.exception.DispatchException;
import r2d2.exception.LifeCycleException;
import r2d2.msg.Messenger;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 11:43 PM
 */
public class ConsoleMessenger extends AbstractMessenger{

    private static Logger logger = LoggerFactory.getLogger(ConsoleMessenger.class);

    public ConsoleMessenger(Map<String, String> config) {
        super(config);
        this.type= MessengerType.CONSOLE;
    }

    @Override
    public void dispatch(String message) throws DispatchException {
        logger.info("CONSOLE MESSENGER sending message: "+message+" ,destination: "+destination.getName()+", hashcode:"+this.hashCode());
    }

    @Override
    public boolean ping() {
        return true;
    }

    @Override
    public void start() throws LifeCycleException {
        logger.info("Started {} messenger.",this.getClass().toString());
    }

    @Override
    public void stop() throws LifeCycleException {
        logger.info("Stopped {} messenger.",this.getClass().toString());
    }
}
