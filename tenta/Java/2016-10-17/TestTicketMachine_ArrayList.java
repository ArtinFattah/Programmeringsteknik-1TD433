// L�sningsf�rslag till tentamen 2016-10-17
// Uppgift A3
// Med en ArrayList

import java.util.*;  // F�r ArrayList

public class TestTicketMachine_ArrayList { 
  
  public static void main (String [] arg) {
    
    // Skapa en ArrayList
    ArrayList <TicketMachine> ticketList = new ArrayList<TicketMachine>();
    
    // Skapa ojekt av TicketMachine och l�gg dem i ArrayList'en
    int n=50;
    for (int i=0; i<n; i++) {
      // Ladda dem med slumpm�ssigt 1-20 biljetter
      int nr = (int) (20*Math.random()+1);
      TicketMachine t = new TicketMachine("Consert"+(i+1),240,nr);
      ticketList.add(t);
    }
    
    // Skriv ut data om dem via toString-metod
    System.out.println(n + " st biljettautomater �r skapade. Deras status �r f�ljande:");
    for (int i=0; i<n; i++) {
      System.out.println(ticketList.get(i));
    }                           
    
    // F�rs�k att k�pa 10 st biljetter fr�n resp biljettautomat
    int antal=0;
    for (int i=0; i<n; i++) {
      if (ticketList.get(i).buy(10)) {
        antal++;
      }
    }    
    
    System.out.println("\nNu har det k�pts 10 st biljetter fr�n varje biljettautomat.");
    System.out.println("Aktuell status efter dessa k�p:");
    // Skriv ut data om dem via toString-metod
    for (int i=0; i<n; i++) {
      System.out.println(ticketList.get(i));
    } 
    
    System.out.println("\nAntal automater det gick att k�pa fr�n " + antal);
    
  }  // main
  
} // class