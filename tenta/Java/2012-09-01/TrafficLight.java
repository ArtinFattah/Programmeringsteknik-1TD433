public class TrafficLight {
  private int period; // Periodicitet
  private int green;  // 
  private int time;
  
  public TrafficLight(int p, int g) {
    period = p;
    green = g;
    time = 0;
  }
  
  public void step() {
    time++;
    if (time==period)
      time = 0;
  }
  
  public boolean isGreen() {
    return time<green;
  }
  
  public String toString() {
    if (isGreen())
      return "(G)";
    else
      return "(R)";
  }

  
  public static void main(String[] a) {
     TrafficLight s = new TrafficLight(7,3);
     TrafficLight t = new TrafficLight(10,5);
     for (int i= 1; i<20; i++) {
       System.out.println(i + "\t" + s + "\t" + t);
       s.step();
       t.step();
     }
     
  }
}

