// Lösningsförslag till tentamen 2016-10-17
// Uppgift A2

/**
 * The class TicketMachine
 *
 * @author Torsten Andersson
 * 
 */

public class TicketMachine {
  // uppg a)
  // The price of a ticket from this machine.
  private int price;
  // Identity of the ticket
  private String identity;
  // Number of tickets
  private int nrOfTickets;
  
  // uppg b)
  public TicketMachine(String id, int price, int nrOfTickets) {
    this.price = price;
    this.nrOfTickets=nrOfTickets;
    this.identity = id;
  }
  
  // uppg c)
  public int getPrice() {
    return this.price;
  }
  
  // uppg d)
  public boolean buy(int nr) {
    if (nr>this.nrOfTickets) { 
      return false;
    }
    else {
      this.nrOfTickets = this.nrOfTickets - nr;
      return true;
    }
  }
  
  // uppg e)
  public String toString() {
    String s = "Biljettens id="+this.identity + ", pris=" + this.price + ", antal=" + this.nrOfTickets;
    return s;
  }
  
  // Given mainmetod
  public static void main(String[] arg) {
    int price = 210;
    int nrOfTickets = 20;
    TicketMachine t = new TicketMachine("Biljettautomat 1", price, nrOfTickets);
    System.out.println(t);
    System.out.println(t.getPrice());
      
    System.out.println(t.buy(5));
    System.out.println(t);
    System.out.println(t.buy(18));
    System.out.println(t);
  }
}