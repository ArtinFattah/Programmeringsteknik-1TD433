// Uppgift B1

import java.util.ArrayList;

public class CashDesk {
  private ArrayList<Customer> queue;
  private Customer current;  // The customer currently beeing served
  // For statistics:
  private int idle;          // Time for cashier without customer
  private int maxTime;       // Maximum queuetime for processed customers
  private int processed;     // Number of processed customers
  
  // UPPGIFT B1a
  public CashDesk() {  
    this.queue = new ArrayList<Customer>();
    this.current = null;
  }
  
  // UPPGIFT B1c
  public void addCustomer(Customer c) {
    this.queue.add(c); 
  }
  
  // UPPGIFT B1c
 public void step() {   // process the queue of customers
    if ( this.current==null ) { 
      if (this.queue.size()==0)
        this.idle++;
      else {
        this.current = this.queue.remove(0);
      }
    } else if (this.current.getItems()==0) {
      this.maxTime = Math.max(this.maxTime, Clock.getTime() - this.current.getBorn());
      this.current = null;
      this.processed++;
    } else {
      this.current.scan();  // Scan an item from the current customer being served
    }
  }
  
  public void printStatistics() {
    System.out.println("\nStatistics");
    System.out.println("Idle time:           " + this.idle);
    System.out.println("Processed customers: " + this.processed);
    System.out.println("Maximal queue time:  " + this.maxTime);
  }
  
   public String toString() {
    String c = "current=<         >";
    if (this.current!=null) {
      c = "current="+this.current;
    }
    return c + " \t queue=" + this.queue;  
  }
  
  public static void main (String [] arg) {
    CashDesk cd = new CashDesk();  // Create the cash desk
    System.out.println(cd);
    cd.printStatistics();
    System.out.println();
    Clock.resetTime();
    int nrCust=0;                  // nr of customers
    for (int i=1; i<=10; i++) {
      Clock.tic();
      if (Math.random()<0.4) {  // 40% prob for a new customer
        int items = (int)(Math.random()*3) + 1;  // the customer has 1-3 items
        nrCust++;  // update nr of customers
        Customer cu = new Customer("cust"+nrCust,items);
        cd.addCustomer(cu);  // the customer is added to the queue at the cash desk
      } 
      System.out.println("time="+Clock.getTime()+": \t"+cd);
      cd.step(); // perform one time step
    } 
    cd.printStatistics();  
  }
}