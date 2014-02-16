package r2d2.config;

import r2d2.config.ConfigConstants;
import r2d2.constants.MessengerType;
import r2d2.exception.ConfigException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 16/02/14
 * Time: 10:36 PM
 * parses a line (string) and extracts config.
 */
public class LineConfigParser {

    public static Map<String,String> extract(String line){

        Map<String,String> config = new HashMap<String, String>();

        if(line == null || line.isEmpty()){
            return  null;
        }
        String[] pairs = line.split(ConfigConstants.config_tuple_delimeter);

        for (int i=0;i<pairs.length;i++)
        {
            String pair = pairs[i];
            String[] keyValue = pair.split(ConfigConstants.key_value_delimiter);
            if(keyValue.length != 2){
                throw new ConfigException("Check config string. config tuple not proper.[kindly check it]");
            }
            config.put(keyValue[0], keyValue[1]);
        }
        isMessengerTypeSpecified(config);
        printConfig(config);
        return config;
    }

    private static void isMessengerTypeSpecified(Map<String,String> config){
        String type =config.get(ConfigConstants.type);

        if(type == null || type.isEmpty()){
          throw new ConfigException("Messenger type not specified in config string");
        }
        try {
            MessengerType.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new ConfigException("Messenger type specified is invalid, in config string");
        }
    }

    private static void printConfig(Map<String,String> config){
        for(Map.Entry<String,String> entry: config.entrySet()){
            System.out.println("Config key: "+entry.getKey()+", ConfigValue:"+entry.getValue());
        }
    }
}
