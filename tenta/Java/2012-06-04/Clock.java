public class Clock {
  private int sec;
  private int min;
  private int hour;
  
  public Clock(int hour, int min, int sec) {
    if (min<0 || min>=60 || sec<0 || sec>=60 || hour<0) {
     System.out.println("Illegal initial values for Clock");
    } else {
     this.sec = sec;
     this.min = min;
     this.hour = hour;
    }
  }
  
  public Clock() {
    this(0,0,0);
  }

  public int getSec() {
    return sec;
  }
  
  public int getMin() {
    return min;
  }
  
  public int getHour() {
     return hour; 
  }

  public void tick() {
    ++sec;
    if (sec==60) {
      sec = 0;
      ++min;
      if (min==60) {
        min = 0;
        ++hour;
      }
    }
  }
  
  public String toString() {
    return String.format("%d:%02d:%02d\n", hour, min, sec);
  }
  
  public static void main(String[] args) {
    Clock c = new Clock(0, 59, 57);
    for (int i = 1; i<=100; i++) {
      c.tick();
      if ( i<6|| i%13==0) {
        System.out.format("%d:%02d:%02d\n", c.getHour(), c.getMin(), c.getSec());
      }
    }
    System.out.format("%d:%02d:%02d\n", c.getHour(), c.getMin(), c.getSec());
    c = new Clock(0, -10, 123);
    System.out.println(c);
    
  }
}