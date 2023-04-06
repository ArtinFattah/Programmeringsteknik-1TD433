import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Box extends JPanel {
  
  public static double deathRadius; // Black hole radius 
  public static int size; // Drawing size of the box
  
  ArrayList<Particle> a; // The collection of particles
  
  public Box(int sz, double dr) {
    setPreferredSize(new Dimension(sz+5, sz+5));
    deathRadius = dr;
    size = sz;
    a = new ArrayList<Particle>();
  }
  
  public static double getDeathRadius() {
    return deathRadius;
  }
  
  public static int getsize() {
    return size;
  }
  
  /** Feeds the black hole with one particle */
  public static void feed(Particle p) {
    double a = (deathRadius*deathRadius +
                p.getRadius()*p.getRadius())*Math.PI;
    deathRadius = Math.sqrt(a/Math.PI);  
  }
  
  /** Adds a particle to the box */
  public void add(Particle p) {
    a.add(p);
  }
  
  /** Advances all particles one time step */
  public void step() {
    for (Particle p : a)
      p.move();
    sweep(); // Remove all dead particles
  }
  
  /** Removes all dead particles from the arraylist */
  private void sweep() {
    int n = 0;
    for (int i=0; i<a.size(); i++) {
      if (a.get(i).isDead()) {
        a.remove(i);
        n++;
      }
    }
  }
  
  /** Fills the box with n random particles of size r */
  public void fill(int n, double r) {
    for (int i=0; i<n; i++) {
      Vector p = new Vector(Math.random(), Math.random());
      Vector v = Vector.randomVector(0.05*Math.random());
      add(new Particle(p, v, r));
    }    
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.RED);
    g.drawRect(0,0,size,size);
    g.setColor(Color.BLACK);
    int dr = (int)(deathRadius*size);
    g.fillOval(size/2-dr, size/2-dr, 2*dr, 2*dr); // Black hole
    for(Particle p : a) {
      p.paintComponent(g); // Individual particles 
    }
  }
}