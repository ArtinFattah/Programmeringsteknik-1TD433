/**
 * Man behöver kunna 
 * 1) skapa signaler med angiven period och grönperiod,
 * 2) tidsstega signaler
 * 3) fråga om signalen är grö eller ej
 * 4) få en String-representation för utskrift
 */
public class TrafficLight {
    private int period;  // hel period
    private int green;   // grönt intervall 
    private int time;    // intern klocka

    public TrafficLight(int p, int g) {
	period = p;
        green = g;
        time = 0;
    }

    public boolean isGreen() {
        return period < green;
    }

    public void step() {
	time++;
	if ( time==period )
	    time = 0;
    }

    public String toString() {
	if ( isGreen() )
	    return "(G)";
	else
	    return "(R)";
    }

}
