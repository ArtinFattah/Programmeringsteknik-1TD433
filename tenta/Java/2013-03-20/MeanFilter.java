/** 
 * A mean value filter
 */
import java.util.ArrayList;

public class MeanFilter {
  private ArrayList<Double> numbers;
  private int max;
  
  /**
   * Set up a filter
   * @param max The maximum number of values to be stored
   */
  public MeanFilter(int max) {
    this.max = max;
    this.numbers = new ArrayList<Double>();
  }
  
  /**
   * Add a new value to the filter and compute the mean. 
   * If the addition causes the number of values to exceed the specified maximum value
   * the oldest value is removed.
   * @param x The value to be added
   * @return The mean of the stored values
   */
  public double add(double x) {
    numbers.add(x);
    if (numbers.size()>max) {
      numbers.remove(0);
    }
    double sum = 0;
    for (int i=0; i<numbers.size(); i++) {
      sum += numbers.get(i);
    }
    return sum/numbers.size();
  }
  
  public String toString() {
    return numbers.toString();
  }
  
  /**
   * Small test program
   */
  public static void main(String[] args) {
    MeanFilter mf = new MeanFilter(3);
    System.out.print  (mf.add(1.)); 
    System.out.println("  " + mf.toString());
    System.out.print  (mf.add(2.));
    System.out.println("  " + mf.toString());
    System.out.print  (mf.add(3.));
    System.out.println("  " + mf.toString());
    System.out.print  (mf.add(4.));
    System.out.println("  " + mf.toString());
    System.out.print  (mf.add(8.));
    System.out.println("  " + mf.toString());
  }  
  
}
