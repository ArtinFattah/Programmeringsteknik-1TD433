public class Measurements {
  private double[] m;   // MŠtvŠrden
  private int n;        // Aktuellt antal vŠrden
  
  public Measurements() {
    this(10);
  }
  
  public Measurements(int size) {
    m = new double[size];
    n = 0;
  } 
  
  public String toString() {
    String result = "";
    for (int i=0; i<n; i++) {
      result += String.format("%5.2f ", new Double(m[i]));
    }
    return "[" + result + "]";
  }
  
  public void add(double v) {
      m[n] = v;
      n++;    
  }
  
  public double mean() {
    double sum = 0;
    for (int i=0; i<n; i++) {
      sum += m[i];
    }
    return sum/n;
  }
  
  public double variance() {
    double ssum = 0;
    double xsum = 0;
    for (int i= 0; i<n; i++) {
      ssum += m[i]*m[i];
      xsum += m[i];
    }
    return (ssum - xsum*xsum/n)/n;
  }
  
  public double max() {
    double res = m[0];
    for (int i=1; i<n; i++)  {
      if (m[i] > res) {
        res = m[i];
      }
    }
    return res;
  }
  
  public int numberOver(double v) {
    int res = 0;
    for (int i=0; i<n; i++) {
      if (m[i] > v) {
        res++;
      }
    }
    return res;
  }
  
  public Measurements smooth() {
    Measurements res = new Measurements(n);
    res.add(m[0]);
    for (int i=1; i<n-1; i++){
      res.add((m[i-1] + m[i] + m[i+1])/3.);
    }
    res.add(m[n-1]);
    return res;
  }
  
  public static void main(String[] args) {
    Measurements ms = new Measurements();
    for (int i=0; i<10; i++) {
      ms.add(Math.random());
    }
    System.out.println("Original     : " + ms);
    System.out.println("Mean value   : " + ms.mean());
    System.out.println("Maximal value: " + String.format("%4.2f", ms.max()));
    System.out.println("Number > 0.8 : " + ms.numberOver(0.8));
    System.out.println("Smooth       : " + ms.smooth());
 
    ms.add(42.);  // Ger fel
  }
} 