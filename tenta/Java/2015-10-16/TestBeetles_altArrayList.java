// Tentamen 20151016

// Lösningsförslag uppg A3

// Lösning med ArrayList

import java.util.*;

public class TestBeetles_altArrayList {
  
  public static void main(String[] arg) {
    int nrOfBeetles=100;
    ArrayList <Beetle>  t = new ArrayList<Beetle>();
    System.out.println(nrOfBeetles + " beetles created:");
    for (int i=0; i<nrOfBeetles; i++) {
      String name = "Kim"+i;
      t.add (new Beetle(name,0,0));
      System.out.println(t.get(i));
    }
    
    int dx = 0;
    int dy = 0;
    System.out.println("The beetles are moved");
    for (int i=0; i<nrOfBeetles; i++) {
      t.get(i).move(dx,dy);
      System.out.println(t.get(i));
      dx = dx + 1;
      dy = dy + 2;
    }   
  } // main
} // class