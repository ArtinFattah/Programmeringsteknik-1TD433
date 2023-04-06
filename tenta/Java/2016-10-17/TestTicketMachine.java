// L�sningsf�rslag till tentamen 2016-10-17
// Uppgift A3
// Med en array

public class TestTicketMachine { 
  
  public static void main (String [] arg) {
    
    // Skapa en array med kapacitet f�r n st biljettautomater
    int n=50;
    TicketMachine [] tArr = new TicketMachine[n];
    
    // Skapa dem
    for (int i=0; i<n; i++) {
      // Ladda dem med slumpm�ssigt 1-20 biljetter
      int nr = (int) (20*Math.random()+1);
      tArr[i]=new TicketMachine("Consert"+(i+1),240,nr);
    }
    
    // Skriv ut data om dem via toString-metod
    System.out.println(n + " st biljettautomater �r skapade. Deras status �r f�ljande:");
    for (int i=0; i<n; i++) {
      System.out.println(tArr[i]);
    }                           
    
    // F�rs�k att k�pa 10 st biljetter fr�n resp biljettautomat
    int antal=0;
    for (int i=0; i<n; i++) {
      if (tArr[i].buy(10)) {
        antal++;
      }
    }    
    
    System.out.println("\nNu har det k�pts 10 st biljetter fr�n varje biljettautomat.");
    System.out.println("Aktuell status efter dessa k�p:");
    // Skriv ut data om dem via toString-metod
    for (int i=0; i<n; i++) {
      System.out.println(tArr[i]);
    } 
    
    System.out.println("\nAntal automater det gick att k�pa fr�n " + antal);
    
  }  // main
  
} // class