// Tentamen 20151016
// Lösningsförslag till uppg A2

public class Beetle { 
  private String name;
  private int x;
  private int y;
  
  public Beetle() {
    this.name="NoName";
    this.x=0;
    this.y=0;
  }
  
  public Beetle(String name, int x, int y) {
    this.name=name;
    this.x=x;
    this.y=y;
  }
  
  public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean collision(Beetle b) {
    if ( (b.x==this.x) && (b.y==this.y)) {
      return true;
    }
    else {
      return false;
    }
  }
    
  public void move(int dx, int dy) {
    this.x = this.x + dx;
    this.y = this.y + dy; 
  }
  
  public String toString() {
    String s = "Name="+this.name + ", x="+this.x + ", y="+this.y;
    return s;
  }
  
  public static void main (String[] arg) {
    Beetle t1 = new Beetle();
    Beetle t2 = new Beetle("Torstina",2,1);
    int nr=2;
    String name = "Ann-Bengt"+nr;
    Beetle t3 = new Beetle(name,5,6);
    System.out.println(t1);
    System.out.println(t2);
    System.out.println(t3);
    t2.move(3,5);
    System.out.println(t2.getName() + " moved to x=" + t2.getX() + ",y=" + t2.getY());
    System.out.println(t1.collision(t2));
    System.out.println(t1.collision(t3));
    System.out.println(t2.collision(t3));
  }
  
}