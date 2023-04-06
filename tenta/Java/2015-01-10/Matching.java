import java.io.*;

public class Matching {
  
  public static void main (String[] arg ) throws IOException{
    
    Group g = new Group("individdata.txt");
    
    System.out.println("Antal individer i gruppen: " + g.getAntal() );
    System.out.println(g);
    Individ[] best = g.bestMatch();
    System.out.println("Bästa match:" + best[0] + " och " + best[1]);
    
  }  // main
  
} // Matchning