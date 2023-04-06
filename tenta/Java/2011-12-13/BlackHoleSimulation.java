import java.awt.*;
import javax.swing.*;
  
public class BlackHoleSimulation extends JFrame {
   
  public static void main(String[] args) {
    JFrame frame = new JFrame("TheWorld"); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 600);
    frame.setBackground(Color.WHITE);
    frame.setLayout(new FlowLayout());
    Box b = new Box(500,0.05);
    b.fill(100, 0.015);    // 100 particles with radius 0.015
    frame.add(b);
    frame.pack();
    frame.setVisible(true);
    JOptionPane.showMessageDialog(null, "Start simulation?");

    for (int i=0; i<500; i++) {
      try {
        b.step();
        b.repaint();
        Thread.sleep(50);
      } catch(InterruptedException e) {}
    }
    JOptionPane.showMessageDialog(null, "Simulation ended");
    frame.dispose();      
  } 
  
}