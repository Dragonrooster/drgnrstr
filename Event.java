public class Event{


    // Defines and initializes class level chars for event type
    public static final char MUTATION = 'm';
    public static final char REPRODUCTION = 'r';
    public static final char DEATH = 'd';

    //Defining class level variables used in the constructor
    private char e;
    private double timeStamp;
    private Individual i;


    //Constructor for events taking a type, timestamp and the individual affected
    Event(char e, double timeStamp, Individual i){
        this.e = e;
        this.timeStamp = timeStamp;
        this.i = i;
    }

    //Returns the event type
    public char type(){
        return e;
    }

    //Returns the timestamp of the event
    public double time(){
        return timeStamp;
    }

    //Returns the individual associated with this event
    public Individual individual(){
        return i;
    }

    //Returns a string representation of the event
    public String toString() {
        String typ;
        switch (type()) {
            case REPRODUCTION : typ = "reproduction"; break;
            case DEATH: typ = "death"; break;
            case MUTATION: typ = "mutation"; break;
            default: typ = "unknown type"; break;
        }

        return ( "Event type: " + typ + "   Time: " + timeStamp  );
    }
}
