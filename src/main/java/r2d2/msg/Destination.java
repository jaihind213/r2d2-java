package r2d2.msg;

/**
 * Created with IntelliJ IDEA.
 * User: vishnuhr
 * Date: 25/02/14
 * Time: 5:58 PM
 */
public class Destination {


    private final String name;
    private final DestinationType type;

    public Destination(String name, DestinationType type) {
        this.name = name;
        this.type = type;
    }

    public Destination(String name) {
        this.name = name;
        this.type = DestinationType.TOPIC;
    }

    public String getName() {
        return name;
    }

    public DestinationType getType() {
        return type;
    }
}
