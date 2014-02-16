package r2d2;

import r2d2.exception.DispatchException;
import r2d2.exception.LifeCycleException;
import r2d2.msg.Messenger;
import r2d2.msg.MessengerFactory;
import r2d2.msg.impl.BlackHoleProducer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DispatchException, LifeCycleException {
        MessengerFactory.getMessenger("type:BLACKHOLE;k:v").dispatch("asd", "asd");
    }
}
