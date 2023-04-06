import java.util.*;
import java.io.*;

public class Group {
  private ArrayList<Individ> individList;
  
  public Group(String filnamn) throws IOException {
    
    this.individList = new ArrayList<Individ>();  
    
    File input = new File(filnamn);
    if (!input.exists()) {
      System.out.println("Filen '" + filnamn + "' existerar ej");
      return;
    }
    Scanner fsc = new Scanner(input);
    
    String id;
    int [] eg = new int[5];
    while (fsc.hasNextLine() ) {
      id = fsc.next();
      for (int i=0; i<5; i++) {
        eg[i]=fsc.nextInt();
      }
      Individ ind = new Individ(id,eg);
      this.individList.add(ind);
    }
    fsc.close();
  }
  
  public int getAntal() {
    return this.individList.size();
  }
  
  // Uppgift 5
  public Individ[] bestMatch() {
    // Skapa en array för resultatet
    Individ [] best = new Individ[2];
    int index1=-1, index2=-1, m, min=10000000;
    for (int i=0; i<this.individList.size()-1; i++) {
      for (int j=i+1; j<this.individList.size(); j++) {
        m = this.individList.get(i).matchingValue( this.individList.get(j));
        if (m<min) {
          index1=i;  // "Bästa" paret av individer
          index2=j;
          min=m;
        }
      } // j-loopen  
    } // i-loopen
    best[0]=this.individList.get(index1);
    best[1]=this.individList.get(index2);
    return best;
  }
  
  public  String toString() {
    String s ="";
    for (int i=0;i<this.individList.size();i++) {
      s = s + this.individList.get(i) + "\n";
    }
    return s;
  }
}
