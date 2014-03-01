package r2d2.constants;

import r2d2.BaseTest;
import r2d2.config.LineConfigParser;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 01/03/14
 * Time: 8:57 PM
 */
public class MessengerTypeTest extends BaseTest{

    public void testLookUpCaseInsensitivity() throws Exception {
        String type = MessengerType.CONSOLE.getType() ;
        try {
            MessengerType.lookup(type.toUpperCase());  //test 1

            MessengerType.lookup(type.toLowerCase());  //test 2

            String lowercaseTypeString = type.toLowerCase();

            char lowerCaseCharacter = lowercaseTypeString.charAt(0); //get the first character.

            type = lowercaseTypeString.replace(lowerCaseCharacter,Character.toUpperCase(lowerCaseCharacter));

            MessengerType.lookup(type);  //-->test 3 string mixed with lower and uppercase
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            fail("Case in sensitivity failed.");
        }
    }

    public void testOfMethod(){
        for (MessengerType messengerType : MessengerType.values()) {
            assertNotNull("Test failed for get Instance of messenger Type:"+messengerType.getType() ,
                messengerType.of(LineConfigParser.extract(sample_line_config)));
            //note: you are giving same config for every messenger type -> thats ok.
        }
    }
}
