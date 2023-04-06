import java.util.Scanner;

public class Simulation {
    
  public static void main(String[] args) {
    Queue q = new Queue();
    Scanner sc = new Scanner(System.in);
    System.out.print("Ankomstsannolikhet: ");
    double a = sc.nextDouble();
    System.out.print("Uttagssannolikhet : ");
    double b = sc.nextDouble();
    
    int n = 0;        // element ut
    int timeSum = 0;
    for (int t= 1; t<=500; t++) {
      if (Math.random() < a) {
        q.put(new Qelem(t) );
      }
      if (Math.random() < b && q.size()>0) {
        Qelem e = q.get();
        n++;
        timeSum += t - e.getBorn();
      }
      if (t%100==0) {
        System.out.println("Tidssteg: " + t);
        System.out.println("   Antal element ut: " + n);
        System.out.println("   Genomsnittstid  : " + (float)timeSum/n); 
      }
    }
    
  }
  
}