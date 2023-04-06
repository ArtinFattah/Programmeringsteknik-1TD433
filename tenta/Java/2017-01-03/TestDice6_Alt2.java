// Uppg A3, alternativ lösning med ArrayList

import java.util.*; // Behövs för ArrayList

public class TestDice6_Alt2 {
   public static void main (String[] arg) {
    int NrOfDice = 20;
    // Skapa en ArrayList med Dice6
    ArrayList <Dice6> dList = new ArrayList<Dice6>();
   
    // Skapa alla Dice6-objekt
    for (int i=0; i<NrOfDice; i++) {
      Dice6 d = new Dice6("Dice"+i);
      dList.add(d); 
    }
   
    System.out.println("Throw each dice until it shows 6");
    for (int i=0; i<NrOfDice; i++) {
      System.out.print("Throwing " + dList.get(i).getId() + " showing:");
      // Kasta denna tärning, dList.get(i), tills den visar en sexa
      while (true) {
        dList.get(i).roll(); // Kasta
        System.out.print(" " + dList.get(i).getValue());  // Skriv ut värdet
        if (dList.get(i).getValue()==6) {
          break;
        }
      } // while
      System.out.println();
    } // for i
    
    System.out.println("Some statistics...");
    // Skriv ut antalet kats man gjort med resp tärning
      for (int i=0; i<NrOfDice; i++) {
        System.out.println(dList.get(i).getId() + " is thrown " + dList.get(i).getNrOfThrows() + " times");
      } // for
      
  } // main 
} // TestDie6_Alt2