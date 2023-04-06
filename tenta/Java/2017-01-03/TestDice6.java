// Uppg A3, lösning med array

public class TestDice6 {
   public static void main (String[] arg) {
    int NrOfDice = 20;
    // Skapa en array med plats för 20 st Dice6
    Dice6 [] dArr = new Dice6[NrOfDice];
   
    // Skapa alla Dice6-objekt
    for (int i=0; i<NrOfDice; i++) {
      dArr[i] = new Dice6("Dice"+i);
    }
   
    System.out.println("Throw each dice until it shows 6");
    for (int i=0; i<NrOfDice; i++) {
      System.out.print("Throwing " + dArr[i].getId() + " showing:");
      // Kasta denna tärning, dArr[i], tills den visar en sexa
      while (true) {
        dArr[i].roll(); // Kasta
        System.out.print(" " + dArr[i].getValue()); // Skriv ut värdet
        if (dArr[i].getValue()==6) {
          break;
        }
      } // while
      System.out.println();
    } // for i
    
    System.out.println("Some statistics...");
    // Skriv ut antalet kats man gjort med resp tärning
      for (int i=0; i<NrOfDice; i++) {
        System.out.println(dArr[i].getId() + " is thrown " + dArr[i].getNrOfThrows() + " times");
      } // for
      
  } // main 
} // TestDie6