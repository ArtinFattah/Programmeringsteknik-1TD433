/**
 * Man beh�ver kunna 
 * 1) skapa signaler med angiven period och gr�nperiod,
 * 2) tidsstega signaler
 * 3) fr�ga om signalen �r gr� eller ej
 * 4) f� en String-representation f�r utskrift
 */
public class TrafficLight {
    private int period;  // hel period
    private int green;   // gr�nt intervall 
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
