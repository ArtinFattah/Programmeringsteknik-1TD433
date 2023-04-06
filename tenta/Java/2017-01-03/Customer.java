// Given klass

public class Customer {
  private String identity; // Identity of customer
  private int items;  // Number of items (equals to serve time at cashier desk)
  private int born;   // Time when customer was created
  
  public Customer(String id, int items) {
    this.identity = id;
    this.items = items;
    this.born = Clock.getTime();  // Get the current time
  }
 
  public int getItems() {
    return this.items;
  }
  
  public String getId() {
    return this.identity;
  }
 
  public void scan() { // Scan an item (done at the cashDesk)
   this.items--; 
  }
  
  public int getBorn() {
    return this.born;
  }
  
  public String toString() {
    return "<" + this.identity + ":" + this.born + "," + this.items + ">";
  }
  
  public static void main (String[] arg) {
    String id="X";
    int nrOfItems=3;
    Customer cu1 = new Customer(id,nrOfItems);
    System.out.println(cu1);
    Clock.resetTime();
    for (int i=1; i<=nrOfItems+1; i++) {
      Clock.tic();
      System.out.print("time="+Clock.getTime()+":");
      if (cu1.getItems()>0) {
        System.out.println("Scanning item " + cu1.getItems() 
                             + " for customer " + cu1.getId());
        cu1.scan(); 
      }
      else {
        System.out.println("No items left to scan for customer " 
                             + cu1.getId());
      }
    }
    Clock.tic();
    Customer cu2 = new Customer("Y",4);
    System.out.println(cu2);
    System.out.println("Id="+cu2.getId()+",born="+cu2.getBorn()
                         + ",items="+cu1.getItems());
  }
}