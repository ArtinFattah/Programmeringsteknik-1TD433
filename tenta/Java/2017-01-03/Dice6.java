// Uppg A2

public class Dice6 {
  
  // Uppg a
  private String identity;
  private int value;
  private int nrOfThrows;
 
  // Uppg b
  public Dice6(String id) {
     this.identity = id;
     this.nrOfThrows=0;
     this.value=1;
  }
  
  // Uppg c
  public String getId() {
    return this.identity;
  }
  
  // Uppg d
  public int getValue() {
    return this.value;
  }
  
  // Uppg e
  public int getNrOfThrows() {
    return this.nrOfThrows;
  }
  
  // Uppg f
  public void roll() {
     this.value = (int) (6*Math.random()+1);
     this.nrOfThrows++;   
  }
  
  // Uppg g
  public String toString() {
    String s = this.identity + ":" + "nrOfThrows="+this.nrOfThrows +",value="+this.value;
    return s;
  }
  
  // Given mainmetod som skall passa klassen ovan
  public static void main (String[] arg) {
    Dice6 d = new Dice6("DiceX");
    System.out.println(d.getId() + ", nr of throws=" + d.getNrOfThrows());
    int n = (int) (5*Math.random()+1);
    for (int i=1; i<=n; i++) {
      d.roll();
      System.out.println(d.getId()+", showing " + d.getValue());
    }
    System.out.println(d.getId()+", nr of throws=" + d.getNrOfThrows());  
    System.out.println(d);
  } // main  
}  // Dice6