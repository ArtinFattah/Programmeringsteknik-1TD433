public class Lok {
  
  private String id;      // lokets identitet
  private int dragvikt;   // max vikt i ton som loket klarar av att dra

  public Lok(String id, int dragvikt) {
    this.id=id;
    this.dragvikt=dragvikt;
  }

  public int getDragvikt() {
    return this.dragvikt;
  }
  
  public String toString() {
    return "<Lokets id="+this.id + ",dragvikt="+this.dragvikt+">";
  }
  
}  // Slut klassen Lok
