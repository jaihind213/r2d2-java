package r2d2;

import r2d2.exception.DispatchException;
import r2d2.exception.LifeCycleException;
import r2d2.msg.MessengerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DispatchException, LifeCycleException {
        MessengerFactory.getMessenger("producer_type:CONSOLE;k:v;dest_name:topicName;dest_type:TOPIC").dispatch("msg");
    }
}
