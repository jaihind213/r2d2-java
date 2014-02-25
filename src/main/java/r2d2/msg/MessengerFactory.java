package r2d2.msg;

import r2d2.config.ConfigConstants;
import r2d2.config.LineConfigParser;
import r2d2.constants.MessengerType;
import r2d2.exception.LifeCycleException;
import r2d2.msg.impl.BlackHoleProducer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 10:20 PM
 * jni signature -> (Ljava/lang/String;)Lr2d2/msg/Messenger;
 */
public class MessengerFactory {

    private static Map<String,Messenger> cache = new HashMap<String, Messenger>();

    public static Messenger getMessenger(String lineConfig) throws LifeCycleException {

        Messenger messenger = cache.get(lineConfig);
        if(messenger != null){
            return messenger;
        }

        Map<String,String> config = LineConfigParser.extract(lineConfig);
        switch (MessengerType.valueOf(config.get(ConfigConstants.type))){
            case BLACKHOLE:
                messenger = new BlackHoleProducer(config);
                break;
            default:
                messenger = new BlackHoleProducer(config);
                break;
        }
        //todo: look at some nice pattern for creation.
        messenger.start();
        cache.put(lineConfig,messenger);
        return messenger;
    }
}
