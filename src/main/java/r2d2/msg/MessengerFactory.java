package r2d2.msg;

import r2d2.config.ConfigConstants;
import r2d2.config.LineConfigParser;
import r2d2.constants.MessengerType;
import r2d2.exception.LifeCycleException;
import r2d2.msg.impl.BlackHoleProducer;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 10:20 PM
 */
public class MessengerFactory {

    public static Messenger getMessenger(String lineConfig) throws LifeCycleException {

        Map<String,String> config = LineConfigParser.extract(lineConfig);
        Messenger messenger = null;
        switch (MessengerType.valueOf(config.get(ConfigConstants.type))){
            case BLACKHOLE:
                messenger = new BlackHoleProducer();
                break;
            default:
                messenger = new BlackHoleProducer();
                break;
        }
        //todo: look at some nice pattern for creation.
        messenger.start();
        return messenger;
    }
}
