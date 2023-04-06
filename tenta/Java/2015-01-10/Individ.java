public class Individ {
  
  // Uppgift 4a, Instansvariabler
  private String id;
  private int[] featureValues;
  
  public Individ(String ident, int[] values) {
    this.id=ident;
    // Djupkopiering  eller grundkopiering?
    this.featureValues = new int[values.length];
    for (int i=0; i<values.length; i++) {
      this.featureValues[i]=values[i];
    }
  }
  
  // Uppgift 4b, metoden matchingValue
  public int matchingValue(Individ annan) {
    int sum=0;
    for (int i=0; i<this.featureValues.length; i++) {
      sum = sum + (int) (Math.pow( this.featureValues[i]-annan.featureValues[i], 2));
    }
    return sum;
  }
  
  public String toString() {
    String s = "";
    for (int i=0; i<this.featureValues.length; i++) {
      s = s + this.featureValues[i] + " ";
    }
   return "<" + this.id + " " + s + ">";
  }
  
  public static void main (String[] arg) {
    int [] featureValuesA = {9,0,0,2,3};
    int [] featureValuesB = {9,0,0,1,6};
    Individ indA = new Individ("A",featureValuesA);
    Individ indB = new Individ("B",featureValuesB);
    System.out.println(indA);
    System.out.println(indB);
    int match = indA.matchingValue(indB);
    System.out.println("Matchningsvärdet är " + match);
  }
    
}