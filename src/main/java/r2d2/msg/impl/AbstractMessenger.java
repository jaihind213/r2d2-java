package r2d2.msg.impl;

import r2d2.config.ConfigConstants;
import r2d2.msg.Destination;
import r2d2.msg.DestinationType;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 25/02/14
 * Time: 6:40 PM
 */
public abstract class AbstractMessenger {

    protected Map<String,String> config;

    protected Destination destination;

    protected AbstractMessenger(Map<String, String> config) {
        this.config = config;
        this.destination = new Destination (config.get(ConfigConstants.destinationName), DestinationType.valueOf(config.get(ConfigConstants.destinationType)))  ;
    }

    public Destination getDestination() {
        return destination;
    }
}
