/**
 * Represents a traffic signal.
 * The signal has three states: 
 * allowing westbound vehicles to pass,
 * allowing northbound vehicles to pass and
 * allowing no one to pass
 */

public class Signal {

  private int timeWest;
  private int timeNorth;
  private int timeStop;
  private int clock;
  
  /** 
   * Defines the signal characteristics
   * @param timeWest Number of timesteps allowing westbounds to pass
   * @param timeNorth Number of time steps allowing northbounds to pass
   * @param timeStop Number of time steps allowing no one to pass
   */
  public Signal(int timeWest, int timeNorth, int timeStop) {
    this.timeWest = timeWest;
    this.timeNorth = timeNorth;
    this.timeStop = timeStop;
    this.clock = 0;
  }
  
  /**
   * Advance the internal clock
   */
  public void step() {
    clock++;
    if (clock == timeWest + timeNorth + timeStop)
      clock = 0;
  }
  
  /**
   * Check if westbounds are allowed to pass
   * @return true if westbounds are allowed to pass, else false
   */
  public boolean greenWest() {
    return clock<timeWest;
  }
  
  /**
   * Check if northbounds are allowed to pass
   * @return true if northbounds are allowed to path, else false
   */
  public boolean greenNorth() {
    return clock >= timeWest + timeStop;
  }
 
  /**
   * @return a string indicating the status of the signal
   */
  public String toString() {
    if (greenWest())
      return "(West)";
    else if (greenNorth())
      return "(North)";
    else 
      return "(Stop)";
  }
    
} 