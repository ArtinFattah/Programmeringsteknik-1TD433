// Tentamen 20151016
// Lösningsförslag till uppg B1

import java.util.*;

public class Tag {
  
  // Givet
  private Lok loket;            
  private ArrayList<Vagn> vagnar; 
  
  // Uppg B1 a)
  public Tag(Lok L) {
    this.loket = L;
    this.vagnar = new ArrayList<Vagn>();
  }
  
  // UPPGIFT B1 b): Beräknar vagnarnas totalvikt i ton
  public int totalvikt() {
    int sum=0;
    for (int i=0; i<this.vagnar.size(); i++) {
      sum = sum + this.vagnar.get(i).getVikt();
    }
    return sum;
  }
  
  // UPPGIFT B1 c): Returnerar true om vagnen går att koppla in, annars false
  public boolean kopplaIn(Vagn v) {
    // Kontrollera om loket orkar dra alla vagnar inkl vagnen v
    if (v.getVikt()+this.totalvikt() > this.loket.getDragvikt() ) {
      return false;
    }
    this.vagnar.add(v);
    return true;   
  }
  
  // UPPGIFT B1 d): kopplar bort vagn med ordningsnumret nr från tåget
  public boolean kopplaBort(int nr) {
    
    int index=nr-1;  // Räkna om nr till index i arraylist
    if ( (index<0) || (index>=this.vagnar.size()) ){
      return false;
    }
    
    this.vagnar.remove(index);
    return true;
  }
  
   // UPPGIFT B1 e): toString
  public String toString() {
    String s = "["+this.loket + "]";
    s = s + this.vagnar;
    return s;
  }
  
} // Slut klassen Tag
