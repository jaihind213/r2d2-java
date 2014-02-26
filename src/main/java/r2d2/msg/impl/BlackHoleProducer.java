package r2d2.msg.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import r2d2.config.ConfigConstants;
import r2d2.constants.MessageDispatchCodes;
import r2d2.exception.DispatchException;
import r2d2.exception.LifeCycleException;
import r2d2.msg.Destination;
import r2d2.msg.DestinationType;
import r2d2.msg.Messenger;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 11:43 PM
 */
public class BlackHoleProducer extends AbstractMessenger implements Messenger{

    private static Logger logger = LoggerFactory.getLogger(BlackHoleProducer.class);

    public BlackHoleProducer(Map<String,String> config) {
        super(config);
    }

    @Override
    public void dispatch(String message) throws DispatchException {
        logger.info("BLACK HOLE PRODUCER sending message: "+message+" ,destination: "+destination.getName()+", hashcode:"+this.hashCode());
    }

    @Override
    public boolean ping() {
        return true;
    }

    @Override
    public void start() throws LifeCycleException {
        logger.info("Started blackhole logger.");
    }

    @Override
    public void stop() throws LifeCycleException {
        logger.info("Stopped blackhole logger.");
    }
}
