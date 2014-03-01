package r2d2.constants;

import r2d2.msg.Messenger;
import r2d2.msg.impl.BlackholeMessenger;
import r2d2.msg.impl.ConsoleMessenger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 10:38 PM
 */
public enum MessengerType{

    BLACKHOLE("blackhole"){
        @Override
        public Messenger of(Map<String, String> config) {
            return new BlackholeMessenger(config);
        }
    },
    CONSOLE("console"){
        @Override
        public Messenger of(Map<String, String> config) {
            return new ConsoleMessenger(config);
        }
    };

//    KAFKA("kafka"){    //TODO:
//        @Override
//        public Messenger of(Map<String, String> config) {
//            return new KafkaMessenger(config);
//        }
//    };

    private final String type;

    MessengerType(final String type) {
       this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract Messenger of(Map<String, String> config);//get instance of...

    /**
     * Better Alternative to valueOf() method.this method is case insensitive .
     * use this instead of valueOf()...
     * @param value
     * @return  MessengerType enum
     * @throws IllegalArgumentException
     */
    public static MessengerType lookup(String value)throws IllegalArgumentException{
         if(value == null || value.isEmpty()){
             throw new IllegalArgumentException("empty/null value provided for lookup of MessengerType.");
         }
        return valueOf(value.toUpperCase());
    }
}
