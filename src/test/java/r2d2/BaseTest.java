package r2d2;


import junit.framework.TestCase;
import r2d2.config.ConfigConstants;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 11:00 PM
 */
public abstract class BaseTest extends TestCase {

    public String dest_config =

            "dest_name"+ ConfigConstants.key_value_delimiter+"topicName" +
                    ConfigConstants.config_tuple_delimeter +
                    "dest_type"+ ConfigConstants.key_value_delimiter+"TOPIC";

    public String params  =  "k"+ ConfigConstants.key_value_delimiter+ "v" ;


    public String sample_line_config =

            "producer_type"+ ConfigConstants.key_value_delimiter+"CONSOLE" +

                    ConfigConstants.config_tuple_delimeter +     params +

                    ConfigConstants.config_tuple_delimeter +  dest_config;

}
