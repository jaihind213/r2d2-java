package r2d2.msg;

import r2d2.BaseTest;
import r2d2.config.ConfigConstants;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 26/02/14
 */
public class MsgFactoryTest extends BaseTest{

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        MessengerFactory.destroyAll();
    }

    public void testGetMessengerForCaseInsenstiveProducerType() throws Exception {
        String type = "CoNsOLe";
        String splConfig = "producer_type"+ ConfigConstants.key_value_delimiter+ type +
                            ConfigConstants.config_tuple_delimeter +     params +
                            ConfigConstants.config_tuple_delimeter +  dest_config;

        Messenger m = MessengerFactory.getMessenger(splConfig);
        assertNotNull(m);
        assertEquals(1,MessengerFactory.getSize());
    }

    public void testGetMessenger() throws Exception {
        Messenger m = MessengerFactory.getMessenger(sample_line_config);
        assertNotNull(m);
        assertEquals(1,MessengerFactory.getSize());
    }

    public void testDestroyMessenger() throws Exception {
        Messenger m = MessengerFactory.getMessenger(sample_line_config);
        MessengerFactory.destroyMessenger(sample_line_config);
        assertEquals(0,MessengerFactory.getSize());
    }
}
