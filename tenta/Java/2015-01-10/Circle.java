public class Circle {
  private double r,x,y;
  
  public Circle (double x, double y, double r) {
    this.x = x; this.y = y; this.r = r;  
  }
  
  public double area () {  
    return Math.PI * this.r * this.r;
  }
  
  public void scale (double sf) { 
    this.r = sf * this.r ;
  }
  
  // uppg b
  public String toString() {
    return "x="+this.x + ", y="+this.y + ", r="+this.r;
  }
  
  // uppg c
  public boolean collide(Circle c) {
    double dx = this.x - c.x;
    double dy = this.y- c.y;
    double d = Math.sqrt(dx*dx + dy*dy);
    return d <= this.r + c.r;
  }

  public static void main ( String [ ] arg ) {
    Circle c = new Circle(0.0,0.0,0.5);
    System.out.println(c);
    c.scale(2.0); 
    System.out.println(c);
    double a = c.area();
    System.out.println(a);
  }
}