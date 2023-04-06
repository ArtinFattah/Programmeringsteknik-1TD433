public class Vagn {
  
  private int vikt;       // vagnens vikt i ton

  public Vagn(int vikt) {
    this.vikt=vikt;
  }

  public int getVikt() {
    return this.vikt;
  }
  
  public String toString() {
    return "Vagnens vikt " + this.vikt +" ";
  }
}
