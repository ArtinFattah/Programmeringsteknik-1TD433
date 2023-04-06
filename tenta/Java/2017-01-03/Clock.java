public class Clock {
  private static int time=0;
  
  public static void tic() {
    time++;
  }
 
  public static int getTime() {
    return time;
  }
  
  public static void resetTime() {
    time=0;
  }
}