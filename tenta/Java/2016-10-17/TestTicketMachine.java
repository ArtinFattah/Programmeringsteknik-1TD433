// Lösningsförslag till tentamen 2016-10-17
// Uppgift A3
// Med en array

public class TestTicketMachine { 
  
  public static void main (String [] arg) {
    
    // Skapa en array med kapacitet för n st biljettautomater
    int n=50;
    TicketMachine [] tArr = new TicketMachine[n];
    
    // Skapa dem
    for (int i=0; i<n; i++) {
      // Ladda dem med slumpmässigt 1-20 biljetter
      int nr = (int) (20*Math.random()+1);
      tArr[i]=new TicketMachine("Consert"+(i+1),240,nr);
    }
    
    // Skriv ut data om dem via toString-metod
    System.out.println(n + " st biljettautomater är skapade. Deras status är följande:");
    for (int i=0; i<n; i++) {
      System.out.println(tArr[i]);
    }                           
    
    // Försök att köpa 10 st biljetter från resp biljettautomat
    int antal=0;
    for (int i=0; i<n; i++) {
      if (tArr[i].buy(10)) {
        antal++;
      }
    }    
    
    System.out.println("\nNu har det köpts 10 st biljetter från varje biljettautomat.");
    System.out.println("Aktuell status efter dessa köp:");
    // Skriv ut data om dem via toString-metod
    for (int i=0; i<n; i++) {
      System.out.println(tArr[i]);
    } 
    
    System.out.println("\nAntal automater det gick att köpa från " + antal);
    
  }  // main
  
} // class