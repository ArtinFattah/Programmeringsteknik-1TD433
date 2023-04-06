// Uppgift B2

public class Store {
  private String name;   // Store name
  private CashDesk theDesk;  // The store has one cash desk
  
   // UPPGIFT B2a
  public Store(String name) { 
    this.name = name;
    this.theDesk = new CashDesk();
  }
  
  public String toString() {
    return this.name + ":" + this.theDesk;
  }
  
  // UPPGIFT B2b
  public void step() {  
    this.theDesk.step();
  }
  
  // UPPGIFT B2c
  public void addCustomer(Customer c) {  // A customer is added to the queue at the cash desk
    this.theDesk.addCustomer(c);
  }
  
  // UPPGIFT B2d
  public void printStatistics() { 
    this.theDesk.printStatistics();
  }
  
  public static void main(String[] args) {
    Store s = new Store("Pollax");  // Create a store
    System.out.println(s);
    int nrOfCustomers = 0;  // nr of customers
    Clock.resetTime();
    for (int i=0; i<10; i++) {
      Clock.tic();      // tic the clock
    
      if (Math.random()<0.4) {  // 40% prob for a new customer
        nrOfCustomers++;        // update nr of customers
        int items = (int)(Math.random()*4) + 1; // the customer has 1-4 items
        // Create the customer
        Customer cu = new Customer("cust"+nrOfCustomers,items);
        s.addCustomer(cu); // the customer is added to the queue at the cash desk
      }
      // Printout info about the store
      System.out.println("Time=" + Clock.getTime() + " \t " +s); 
      s.step();  // perform one time step
    }
    s.printStatistics();
  } // main
}