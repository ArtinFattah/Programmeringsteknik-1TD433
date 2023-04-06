/**
 * Represents a traffic crossing controlled by a traffic signal.
 * There are two queues in front of the signal - one for
 * westbound and one for northbound vehicles.
 * The system also represent the vehicle just passed the crossing.
 */
import java.util.ArrayList;

public class TrafficSystem {
  private Signal signal;
  private ArrayList<Vehicle> northBound;
  private ArrayList<Vehicle> westBound;
  private Vehicle passed; // Vehicle just passed the signal
  private int time;
  
  // For statistics
  private int passedToWest;
  private int passedToNorth;
  private int sumTimeToNorth;
  private int sumTimeToWest;
  
  /**
   * Constructor
   * @param signal The signal to be used in the crossing
   */
  public TrafficSystem(Signal signal) {
    this.signal = signal;
    //northBound = new ArrayList<Vehicle>();
    //westBound = new ArrayList<Vehicle>();
  }
  
  /**
   * Add a vehicle to the westbound queue
   * @param v The vehicle to be added
   */
  public void addWestbound(Vehicle v) {
    westBound.add(v);
  }
  
  /**
   * Add a vehicle to the northbound queue
   * @param v The vehicle to be added
   */
  public void addNorthbound(Vehicle v) {
    northBound.add(v);
  }
  
  /**
   * Advance the system one time step.
   * Steps the signal, takes a vehicle from the queue
   * with green signal past the crossing, collects
   * data for statistics and increases the internal clock
   */
  public void step() {
    
    signal.step();
    passed = null;
    
    if (signal.greenWest()) {
      if (westBound.size()>0) {
        passed = westBound.remove(0); 
        passedToWest++;
        sumTimeToWest += time - passed.getBorn();
      }
      
    } else if (signal.greenNorth()) {
      if (northBound.size()>0) {
        passed = northBound.remove(0);
        passedToNorth++;
        sumTimeToNorth += time - passed.getBorn();
      }
      
    } else ;
    time++;
  }
  
  /**
   * Produce a snapshot of the current situation
   */
  public void print() {
    System.out.println("---------------------");
    
    System.out.println("            " + northBound);
    if (passed==null)
      System.out.print("      ");
    else
      System.out.print(passed + "\t");
    System.out.println(signal);
    
    System.out.println("            " + westBound);
  }  
    
  /**
   * Produce statistics
   */
  public void printStatistics() {
    System.out.println("\nStatistics:\n");
    System.out.println("Number of northbound cars: " + 
                       passedToNorth);
    System.out.println("Average queue time       : " + 
                       (float)sumTimeToNorth/passedToNorth);
    System.out.println();
    System.out.println("Number of westbound cars : " + 
                       passedToWest);
    System.out.println("Average queue time       : " + 
                       (float)sumTimeToWest/passedToWest);
  }
  
  /** 
   * Small test program
   */
  public static void main(String[] args) throws InterruptedException {
    Signal s = new Signal(5, 3, 2);
    TrafficSystem ts = new TrafficSystem(s);
    for (int i= 0; i<10; i++) {
      Thread.sleep(10);
      if (Math.random()<0.3)
        ts.addNorthbound(new Vehicle("n", i));
      if (Math.random()<0.4)
        ts.addWestbound(new Vehicle("w", i));
      ts.step();
      ts.print();
    }  
    ts.printStatistics();   
  }
  
}