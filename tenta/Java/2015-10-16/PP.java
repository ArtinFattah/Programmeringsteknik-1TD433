// Tentamen 20151016 - Uppgift B2 - lösning
/*
   Den i uppgiften givna mainmetoden gav följande resultat
     [14,-2,5]
     [14,99,5]
     java.lang.ArrayIndexOutOfBoundsException: 3
         at PP.add 
         
   Det första felet är att den givna konstruktorn utför grundkopiering av arrayen
   Det andra felet är att den givna metoden add inte "förlänger" arrayen när arrayen är full
*/
public class PP {
  private int[] x;
  private int stored;
  
  public PP (int [] q) {
    //  Nedan två satser orsakade ett fel, ty det är grundkopiering av arrayen
    //    this.x = q;
    //    this.stored = q.length;
    // Lösning: Gör djup kopiering
    this.x = new int[q.length];
    for (int i=0;i<this.x.length;i++) {
      this.x[i]=q[i];
    }
    this.stored = this.x.length;
  } 
  
  public void add(int a) {
    // Nedan två satser orsakade fel - Array out of bounds
    //     this.x[this.stored]=a;
    //     this.stored++;
    
    // Lösning: "Förläng" arrayen
    // Genom att skapa en array temp som är större än arrayen this.x
    int [] temp = new int[2*this.x.length+1];
    // Kopiera alla element från this.x till temp
    for (int i=0;i<this.x.length;i++) {
      temp[i]=this.x[i];
    }
    // Sätt this.x till temp, dvs låt this.x referera till arrayen temp
    this.x = temp;
    // Lägg in a sist i arrayen this.x
    this.x[this.x.length-1]=a;
    this.stored++;
  }
  
  public String toString() {
    if (this.stored==0) {
      return "[]";
    }
    String s = "[";
    for (int i=0; i<this.stored-1; i++) {
      s = s + this.x[i] + ",";
    }
    s = s + this.x[this.stored-1] + "]";
    return s;
  }
  
  public static void main (String[] arg) {
   int [] z = new int[3];
   z[0]=14; z[1]=-2; z[2]=5;
   PP p = new PP(z);
   System.out.println(p);
   z[1]=99;
   System.out.println(p);
   p.add(8);
   System.out.println(p);
  }
}