package r2d2.msg;

import r2d2.BaseTest;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 26/02/14
 */
public class MsgFactoryTest extends BaseTest{

    final String config  = "producer_type:BLACKHOLE;k:v;dest_name:topicName;dest_type:TOPIC";

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        MessengerFactory.destroyAll();
    }

    public void testGetMessenger() throws Exception {
        Messenger m = MessengerFactory.getMessenger(config);
        assertNotNull(m);
        assertEquals(1,MessengerFactory.getSize());
    }

    public void testDestroyMessenger() throws Exception {
        Messenger m = MessengerFactory.getMessenger(config);
        MessengerFactory.destroyMessenger(config);
        assertEquals(0,MessengerFactory.getSize());
    }
}
