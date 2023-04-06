import java.util.ArrayList;

public class Queue {
  private ArrayList<Qelem> q;
  
  public Queue() {
    q = new ArrayList<Qelem>();
  }
  
  public void put(Qelem e) {
    q.add(e);  
  }
  
  public Qelem get() {
    Qelem e = q.get(0);
    q.remove(0);
    return e;
  }
  
  public int size() {
    return q.size();
  }
}
