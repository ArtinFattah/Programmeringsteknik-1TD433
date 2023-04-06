public class Vector {
  private double x;
  private double y;
  
  public Vector(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  public String toString() {
    return "<" + x + ", " + y + ">";
  }
  
  /** Modify this vector by adding v */
  public void add(Vector v) {
    x += v.x;
    y += v.y;
  }
  
  /** Returns the distance from this vector (point) to vector (point) v */
  public double distance(Vector v) {
    return Math.sqrt((x-v.x)*(x-v.x) + (y-v.y)*(y-v.y));
  }
  
  public double getx() {
    return x;
  }
  
  public double gety() {
    return y;
  }
  
  public void setx(double x) {
   this.x = x; 
  }
  
  public void sety(double y) {
    this.y = y;
  }
  
  /** Creates and returns a copy of this vector */
  public Vector copy() {
    return new Vector(x,y);
  }
  
  /** Creates a vector of specified length pointing in a random direction */
  public static Vector randomVector(double len) {
    double angle = Math.random()*2.*Math.PI;
    return new Vector(Math.cos(angle)*len, Math.sin(angle)*len);
  }
  
}