package r2d2.msg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import r2d2.config.ConfigConstants;
import r2d2.config.LineConfigParser;
import r2d2.constants.MessengerType;
import r2d2.exception.LifeCycleException;
import r2d2.msg.impl.BlackholeMessenger;
import r2d2.msg.impl.ConsoleMessenger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 10:20 PM
 * Regarding synchronization for these methods - The usage does not mandate it now.
 */
public class MessengerFactory {

    private static Logger logger = LoggerFactory.getLogger(MessengerFactory.class);

    private static Map<String,Messenger> cache = new HashMap<String, Messenger>();

    public static Messenger getMessenger(String lineConfig) throws LifeCycleException {
        logger.info("Request for logger with config: "+lineConfig);

        Messenger messenger = cache.get(lineConfig);
        if(messenger != null){
            logger.debug("Logger returned from cache! ");
            return messenger;
        }

        Map<String,String> config = LineConfigParser.extract(lineConfig);

        try {
            MessengerType messengerType  = MessengerType.lookup(config.get(ConfigConstants.type));
            messenger = messengerType.of(config);
        } catch (IllegalArgumentException e) {
            messenger = new BlackholeMessenger(config);
            logger.warn("Could not find requested logger with type: '"+config.get(ConfigConstants.type)+"'. returning blackhole logger as default.");
            logger.warn("Note: Config provided was:["+lineConfig+"] !!!");
        }

        messenger.start();
        logger.info("Logger started successfully!");
        cache.put(lineConfig, messenger);
        logger.info("Request for logger with config: "+lineConfig+" completed.");
        return messenger;
    }

    public static void destroyMessenger(String lineConfig) throws LifeCycleException {
        logger.info("Destroying messenger with line config: " + lineConfig);
        Messenger messenger = cache.remove(lineConfig);
        if(messenger != null){
            messenger.stop();
            logger.info("Destroyed messenger with line config: " + lineConfig);
        }else{
            logger.info("Could not find messenger to destroy with line config: " + lineConfig);
        }
    }

    public static void destroyAll(){
        logger.info("Destroying All messengers ...");
        Set<String> keys = cache.keySet();
        for(String key: keys){
            try {
                logger.info("Destroying messenger with line config: " + key);
                destroyMessenger(key);
            } catch (Throwable e) {
                 logger.error("Error in destroying messenger with config:"+key,e);
            }
        }
    }

    /**
     * helper method to get size of cache.
     * @return int
     */
    public static int getSize(){
        return cache.size();
    }
}
