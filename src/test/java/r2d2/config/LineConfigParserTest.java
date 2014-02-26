package r2d2.config;

import junit.framework.Assert;
import r2d2.BaseTest;
import r2d2.constants.MessengerType;
import r2d2.exception.ConfigException;
import r2d2.msg.DestinationType;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 11:02 PM
 */
public class LineConfigParserTest extends BaseTest{

    public static String delim = ConfigConstants.key_value_delimiter;
    public static String tuple_delim = ConfigConstants.config_tuple_delimeter;

    public void testForProperConfig() throws Exception {
         String lineConfig = "key1"+ delim + "value1"
                               + tuple_delim   +
                            "key2"+ delim + "value2"
                                + tuple_delim +
                            ConfigConstants.type+ delim + MessengerType.KAFKA.toString()+ tuple_delim+
                            ConfigConstants.destinationType+ delim + DestinationType.QUEUE.toString()+ tuple_delim+
                            ConfigConstants.destinationName + delim+"testing";
        printLineConfig(lineConfig);
        try {
            Map <String,String> config = LineConfigParser.extract(lineConfig);
            assertEquals(5, config.size());
        } catch (Throwable e) {
            e.printStackTrace();
            fail();
        }

    }

    public void testForConfigWithoutMessengerType() throws Exception {
        String lineConfig = "key1"+ delim + "value1"
                + tuple_delim   +
                "key2"+ delim + "value2"
                +tuple_delim+
                ConfigConstants.destinationType+ delim + "TOPIC"
                +tuple_delim+
                ConfigConstants.destinationName+ delim + "name";
        printLineConfig(lineConfig);
        try {
            Map <String,String> config = LineConfigParser.extract(lineConfig);
            fail("test should not pass as Messenger type is not there in config string");
        } catch (ConfigException testPassed) {
            testPassed.printStackTrace();
        } catch (Throwable failed) {
            failed.printStackTrace();
            fail("expecting ConfigException for test");
        }

    }

    public void testForConfigWithoutDestinationType() throws Exception {
        String lineConfig = "key1"+ delim + "value1"
                + tuple_delim   +
                "key2"+ delim + "value2"
                +tuple_delim+
                ConfigConstants.type+ delim + "BLACKHOLE"
                +tuple_delim+
                ConfigConstants.destinationName+ delim + "name";
        printLineConfig(lineConfig);
        try {
            Map <String,String> config = LineConfigParser.extract(lineConfig);
            fail("test should not pass as Destination type is not there in config string");
        } catch (ConfigException testPassed) {
            testPassed.printStackTrace();
        } catch (Throwable failed) {
            failed.printStackTrace();
            fail("expecting ConfigException for test");
        }

    }

    public void testForConfigWithoutDestinationName() throws Exception {
        String lineConfig = "key1"+ delim + "value1"
                + tuple_delim   +
                "key2"+ delim + "value2"
                +tuple_delim+
                ConfigConstants.type+ delim + "BLACKHOLE"
                +tuple_delim+
                ConfigConstants.destinationType+ delim + "TOPIC";
        printLineConfig(lineConfig);
        try {
            Map <String,String> config = LineConfigParser.extract(lineConfig);
            fail("test should not pass as Destination name is not there in config string");
        } catch (ConfigException testPassed) {
            testPassed.printStackTrace();
        } catch (Throwable failed) {
            failed.printStackTrace();
            fail("expecting ConfigException for test");
        }

    }


    public void testForMalformedConfigWithIncompleteTuple() throws Exception {
        String lineConfig = "ImproperKey1" +delim
                + tuple_delim   +
                "key2"+ delim + "value2";
        printLineConfig(lineConfig);
        try {
            Map <String,String> config = LineConfigParser.extract(lineConfig);
            fail("test should not pass as a tuple was improper in config string");
        } catch (ConfigException testPassed) {
        }

    }

    public void testExtraKeyValueDelimiterInTuple_1() throws Exception {
        String lineConfig = "key1" +delim +"value1"+ delim  // <--- this is the extra delim
                + tuple_delim   +
                "key2"+ delim + "value2"+
                tuple_delim+ ConfigConstants.type+ delim + MessengerType.KAFKA.toString();
        System.out.println("This test should fail as you have not taken care of this edge case!");
        printLineConfig(lineConfig);

        System.out.println("It has an extra colon for first tuple !");

        try {
            Map <String,String> config = LineConfigParser.extract(lineConfig);
            Assert.fail("test 'testExtraKeyValueDelimiterInTuple_1' should not pass as config string was improper");
        } catch (ConfigException testPassed) {
        }

    }

    public void testExtraKeyValueDelimiterInTuple_2() throws Exception {
        String lineConfig = "key1" +delim +delim+"value1"  // <--- this is the extra delim
                + tuple_delim   +
                "key2"+ delim + "value2"+
                tuple_delim+ ConfigConstants.type+ delim + MessengerType.KAFKA.toString();
        printLineConfig(lineConfig);
        try {
            Map <String,String> config = LineConfigParser.extract(lineConfig);
            Assert.fail("test should not pass as config string was improper");
        } catch (ConfigException testPassed) {
        }

    }

    public void testExtraTupleDelimiterInTuple_1() throws Exception {
        String lineConfig = "key1" +delim +"value1"
                + tuple_delim   +   tuple_delim + // <--- this is the extra delim
                "key2"+ delim + "value2"+
                tuple_delim+ ConfigConstants.type+ delim + MessengerType.KAFKA.toString();
        printLineConfig(lineConfig);
        try {
            Map <String,String> config = LineConfigParser.extract(lineConfig);
            Assert.fail("test should not pass as config string was improper");
        } catch (ConfigException testPassed) {
        }

    }

    private void printLineConfig(String config){
        System.out.println("config given was "+config);
    }
}
