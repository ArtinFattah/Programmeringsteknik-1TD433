import java.util.ArrayList;

public class CarQueue {
  private ArrayList<Car> theQ;
  
  public CarQueue() {
    theQ = new ArrayList<Car>();
  }
  
  public void put(Car c) {
    theQ.add(c);
  }
  
  public Car get() {
    return theQ.remove(0);
  }
  
  public String toString() {
    String s = "";
    for (int i=0; i<theQ.size(); i++)
      s += theQ.get(i) + " ";
    return "[" + s + "]";
  }
  
  public boolean isEmpty() {
    return theQ.size() == 0;
  }
   
}