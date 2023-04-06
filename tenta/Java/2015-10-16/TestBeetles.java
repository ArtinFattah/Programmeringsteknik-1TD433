// Tentamen 20151016
// Lösnningsförslag uppg A3

//  Med array av Beetle

public class TestBeetles {
  
  public static void main(String[] arg) {
    int nrOfBeetles=100;
    Beetle [] t = new Beetle[nrOfBeetles];
    System.out.println(nrOfBeetles + " beetles created:");
    for (int i=0; i<nrOfBeetles; i++) {
      String name = "Kim"+i;
      t[i]= new Beetle(name,0,0);
      System.out.println(t[i]);
    }
    
    int dx=0;
    int dy=0;
    System.out.println("The beetles are moved");
    for (int i=0; i<nrOfBeetles; i++) {
      t[i].move(dx,dy);
      System.out.println(t[i]);
      dx = dx + 1;
      dy = dy + 1;
    }    
  }  // main
}  // class