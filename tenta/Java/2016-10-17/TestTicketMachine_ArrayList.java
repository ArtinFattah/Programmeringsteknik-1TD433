// Lösningsförslag till tentamen 2016-10-17
// Uppgift A3
// Med en ArrayList

import java.util.*;  // För ArrayList

public class TestTicketMachine_ArrayList { 
  
  public static void main (String [] arg) {
    
    // Skapa en ArrayList
    ArrayList <TicketMachine> ticketList = new ArrayList<TicketMachine>();
    
    // Skapa ojekt av TicketMachine och lägg dem i ArrayList'en
    int n=50;
    for (int i=0; i<n; i++) {
      // Ladda dem med slumpmässigt 1-20 biljetter
      int nr = (int) (20*Math.random()+1);
      TicketMachine t = new TicketMachine("Consert"+(i+1),240,nr);
      ticketList.add(t);
    }
    
    // Skriv ut data om dem via toString-metod
    System.out.println(n + " st biljettautomater är skapade. Deras status är följande:");
    for (int i=0; i<n; i++) {
      System.out.println(ticketList.get(i));
    }                           
    
    // Försök att köpa 10 st biljetter från resp biljettautomat
    int antal=0;
    for (int i=0; i<n; i++) {
      if (ticketList.get(i).buy(10)) {
        antal++;
      }
    }    
    
    System.out.println("\nNu har det köpts 10 st biljetter från varje biljettautomat.");
    System.out.println("Aktuell status efter dessa köp:");
    // Skriv ut data om dem via toString-metod
    for (int i=0; i<n; i++) {
      System.out.println(ticketList.get(i));
    } 
    
    System.out.println("\nAntal automater det gick att köpa från " + antal);
    
  }  // main
  
} // class