public class TrafficSystem {
  private CarQueue queue = new CarQueue();
  private TrafficLight light;
  private double intensity;
  private int time;      // Systemets klocka
  private int totalTime; // Total kštid fšr bilar som passerat 
  private int nCars;     // Antal bilar som passerat
  
  public TrafficSystem(int period, int green, double intens) {
    light = new TrafficLight(period, green);
    queue = new CarQueue();
    intensity = intens;
    time = 0;
    totalTime = 0;
    nCars = 0;
  }
  
  public void step() {
    time++;
    light.step();
    if (light.isGreen() && !queue.isEmpty()) {
      Car c = queue.get();
      totalTime = totalTime + (time - c.getBorn());
      nCars++;
    }
    if (Math.random() < intensity) {
      queue.put(new Car(time));
    }
  }
  
  public void print() {
    System.out.println("\nTimestep: " + time);
    System.out.println("Current situation: " + light + queue);
    System.out.println("Number of passed cars: " + nCars);
    System.out.println("Average queue time   : " + (float)totalTime/nCars);
  }
  
  public static void main(String[] args) {
    TrafficSystem ts = new TrafficSystem(10, 5, 0.5);
    for (int i=1; i<20; i++) {
      ts.print();
      ts.step();
    }
  }
}