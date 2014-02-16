package r2d2.config;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 10:39 PM
 */
public class ConfigConstants {

    /*
     key:value, this constant helps the configParser to identify key & value .
     The key could be configName & value could be configValue
     */
    public static final String key_value_delimiter = ":";


    /*
     k1:v1,k2:v2 ,k3:v3 this constant helps the configParser to identify the tuples
     which hold key value pairs.
     In above example "comma"  is the  config_tuple_delimeter
     */
    public static final String config_tuple_delimeter = ";";


    public static final String type = "type";

}
